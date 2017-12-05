package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminuserDao;
import dao.RecordDao;
import dao.impl.AdminuserDaoImpl;
import dao.impl.RecordDaoImpl;
import entity.Adminuser;
import entity.Record;
import util.Encrypt;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet(name="/AdminLogin",urlPatterns="/adminLogin.do")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
	    RecordDao recordDao = new RecordDaoImpl();
	    
	    String adminname = request.getParameter("adminname");
	    String adminpass = request.getParameter("adminpass");
	    String code = request.getParameter("code");
	    
	    /*表单数据保存至request作用域*/
	    request.setAttribute("adminname", adminname);
	    request.setAttribute("adminpass", adminpass);
	    request.setAttribute("code", code);
	    /*表单数据规范性的服务器端验证*/
	    String mess = validateForm(adminname, adminpass, code);
	    if (!"".equals(mess)){
	      request.setAttribute("adminLoginMess", mess);
	      request.getRequestDispatcher("/manage.jsp").forward(request, response);
	    }else {
	      String sessioncode = session.getAttribute("sessioncode").toString();
	      
	      if (!code.equals(sessioncode)) {
	        request.setAttribute("adminLoginMess", "* 验证码错误！");
	        request.getRequestDispatcher("/manage.jsp").forward(request, response);
	      }else {
	        Adminuser adminuser = adminuserDao.validateLogin(adminname, Encrypt.SHA(adminpass));
	        if (adminuser == null) {
	          request.setAttribute("adminLoginMess", "* 用户名或密码输入错误！");
	          request.getRequestDispatcher("/manage.jsp").forward(request, response);
	        }else {
	          Record record = new Record();
	          record.setLogname(adminuser.getAdminname());
	          record.setUsergroup(adminuser.getAdmingroup());
	          record.setLogip(request.getRemoteAddr());
	          if (recordDao.add(record) != 0) {
	            session.setAttribute("adminuser", adminuser);
	            response.sendRedirect(request.getContextPath() + "/admin/state.jsp");
	            
	          } else {
	            request.setAttribute("adminLoginMess", "* 登录异常！");
	            request.getRequestDispatcher("/manage.jsp").forward(request, response);
	          }
	        }
	      }
	    }
	}

	private String validateForm(String adminname, String adminpass, String code) {
		// TODO Auto-generated method stub
		if (adminname == null || !adminname.matches("\\w{6,20}")){
		      return "* 用户名错误！";
		    }else if (adminpass == null || !adminpass.matches("\\w{6,20}")) {
		      return "* 密码错误！";
		    }else if (code == null || !code.matches("\\d{4}")) {
		      return "* 验证码错误！";
		    }
		    return "";
	}

}
