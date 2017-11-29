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
import entity.Stu;
import util.Encrypt;

/**
 * Servlet implementation class StuRegister
 */
@WebServlet(name="/StuRegister",urlPatterns="/register.do")
public class StuRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuRegister() {
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
	     String username = request.getParameter("username");
	     String password = request.getParameter("password");
	     String confirmpass = request.getParameter("confirmpass");
	     String code = request.getParameter("code");
	     String regip = request.getRemoteAddr(); 
	     request.setAttribute("username", username);
	     request.setAttribute("password", password);
	     request.setAttribute("confirmpass", confirmpass);
	     request.setAttribute("code", code);
	     String mess = validateForm(username, password, confirmpass,code);
	     if (!"".equals(mess)){
	       request.setAttribute("stuAddMess", mess);
	       request.getRequestDispatcher("/register.jsp").forward(request, response);
	     }else {
	       Stu stu = new Stu();
	       stu.setUsername(username);
	       stu.setPassword(Encrypt.SHA(password));
	       stu.setRegip(regip);
	       String sessioncode = session.getAttribute("sessioncode").toString();
	       if (!code.equals(sessioncode)) {
	         request.setAttribute("stuAddMess", "* 验证码错误！");
	         request.getRequestDispatcher("/register.jsp").forward(request, response);
	       }else if (stuDao.findByUsername(username) != null) {
	         request.setAttribute("stuAddMess", "* 用户名已存在！");
	         request.getRequestDispatcher("/register.jsp").forward(request, response);
	       }else if (stuDao.add(stu) != 0) {
	         request.setAttribute("stuLoginMess", "* 注册成功，请登录！");
	         request.removeAttribute("username");
	         request.removeAttribute("password");
	         request.removeAttribute("confirmpass");
	         request.removeAttribute("code");
	         request.getRequestDispatcher("/index.jsp").forward(request, response);
	       }else {
	         request.setAttribute("stuAddMess", "* 用户注册失败！");
	         request.getRequestDispatcher("/register.jsp").forward(request, response);
	       }
	     }
	}
	
	private String validateForm(String username,String password,String confirmpass,String code){
		if (username == null || !username.matches("\\w{6,20}")){
		      return "* 用户名不合法！";
		    }else if (password == null || !password.matches("\\w{6,20}")) {
		      return "* 密码不合法！";
		    }else if (!password.equals(confirmpass)) {
		      return "* 两次输入的密码不一致，请重新输入！";
		    }else if (code == null || !code.matches("\\d{4}")) {
		      return "* 验证码错误！";
		    }
		    return "";
  }
}
