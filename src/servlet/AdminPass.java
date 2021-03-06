package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminuserDao;
import dao.impl.AdminuserDaoImpl;
import entity.Adminuser;
import util.Encrypt;

/**
 * Servlet implementation class AdminPass
 */
@WebServlet(name="/AdminPass",urlPatterns="/admin/pass.do")
public class AdminPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html; charset=utf-8");
	    HttpSession session = request.getSession();
	    AdminuserDao adminuserDao = new AdminuserDaoImpl();
	    String oldpass = request.getParameter("oldpass");
	    String newpass = request.getParameter("newpass");
	    String confirmpass = request.getParameter("confirmpass");
	    String code = request.getParameter("code");
	    
	    request.setAttribute("oldpass",oldpass);
	    request.setAttribute("newpass",newpass);
	    request.setAttribute("confirmpass",confirmpass);
	    request.setAttribute("code",code);
	    
	    String mess = validateForm(oldpass, newpass, confirmpass,code);
	    if (!"".equals(mess)){
	      request.setAttribute("passModifyMess", mess);
	      request.getRequestDispatcher("/admin/pass.jsp").forward(request, response);
	    }else {
	      String sessioncode = session.getAttribute("sessioncode").toString();
	      
	      if (!sessioncode.equals(code)) {
	        request.setAttribute("passModifyMess", "* ��֤�����");
	        request.getRequestDispatcher("/admin/pass.jsp").forward(request, response);
	      }else {
	        Adminuser adminuser = (Adminuser)session.getAttribute("adminuser");
	        String adminname = adminuser.getAdminname();
	        if (adminuserDao.validateLogin(adminname, Encrypt.SHA(oldpass)) == null) {
	          request.setAttribute("passModifyMess", "* �������������");
	          request.getRequestDispatcher("/admin/pass.jsp").forward(request, response);
	        }else if (adminuserDao.passModify(adminname, Encrypt.SHA(newpass)) != 0) {
	          request.removeAttribute("oldpass");
	          request.removeAttribute("newpass");
	          request.removeAttribute("confirmpass");
	          request.removeAttribute("code");
	          session.removeAttribute("adminuser");
	          request.setAttribute("adminLoginMess", "* �����޸ĳɹ��������µ�¼��");
	          request.getRequestDispatcher("/manage.jsp").forward(request, response); 
	        } else {
	          request.setAttribute("passModifyMess", "* �����޸�ʧ�ܣ�");
	          request.getRequestDispatcher("/admin/pass.jsp").forward(request, response);
	        }
	      }
	    }
	}

	private String validateForm(String oldpass, String newpass, String confirmpass, String code) {
		// TODO Auto-generated method stub
		if (oldpass == null || !oldpass.matches("\\w{6,20}")){
		      return "* ���������";
		    }else if (newpass == null || !newpass.matches("\\w{6,20}")) {
		      return "* �����벻�Ϸ���";
		    }else if (!newpass.equals(confirmpass)) {
		      return "* ��������������벻һ�£����������룡";
		    }else if (code == null || !code.matches("\\d{4}")) {
		      return "* ��֤�����";
		    }
		    return "";
	}

}
