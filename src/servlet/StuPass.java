package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StuDao;
import dao.impl.StuDaoImpl;
import util.Encrypt;

/**
 * Servlet implementation class StuPass
 */
@WebServlet(name="/StuPass",urlPatterns="/stu/pass.do")
public class StuPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuPass() {
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
	    StuDao stuDao = new StuDaoImpl();
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
	      request.getRequestDispatcher("/stu/pass.jsp").forward(request, response);
	    }else {
	      String sessioncode = session.getAttribute("sessioncode").toString();
	      if (!code.equals(sessioncode)) {
	        request.setAttribute("passModifyMess", "* 验证码错误！");
	        request.getRequestDispatcher("/stu/pass.jsp").forward(request, response);
	      }else {
	        String username = (String)session.getAttribute("username");
	        if (stuDao.validateLogin(username, Encrypt.SHA(oldpass)) == null) {
	          request.setAttribute("passModifyMess", "* 旧密码输入错误！");
	          request.getRequestDispatcher("/stu/pass.jsp").forward(request, response);
	        }else if (stuDao.passModify(username, Encrypt.SHA(newpass)) != 0) {
	          request.removeAttribute("oldpass");
	          request.removeAttribute("newpass");
	          request.removeAttribute("confirmpass");
	          request.removeAttribute("code");
	          session.removeAttribute("username");
	          request.setAttribute("stuLoginMess", "* 密码修改成功，请重新登录！");
	          request.getRequestDispatcher("/index.jsp").forward(request, response); 
	        } else {
	          request.setAttribute("passModifyMess", "* 密码修改失败！");
	          request.getRequestDispatcher("/stu/pass.jsp").forward(request, response);
	        }
	      }
	    }
	}

	private String validateForm(String oldpass, String newpass, String confirmpass, String code) {
		// TODO Auto-generated method stub
		if (oldpass == null || !oldpass.matches("\\w{6,20}")){
		      return "* 旧密码错误！";
		    }else if (newpass == null || !newpass.matches("\\w{6,20}")) {
		      return "* 新密码不合法！";
		    }else if (!newpass.equals(confirmpass)) {
		      return "* 两次输入的新密码不一致，请重新输入！";
		    }else if (code == null || !code.matches("\\d{4}")) {
		      return "* 验证码错误！";
		    }
		    return "";
	}

}
