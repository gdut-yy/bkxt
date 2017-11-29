package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecordDao;
import dao.StuDao;
import dao.impl.RecordDaoImpl;
import dao.impl.StuDaoImpl;
import entity.Record;
import util.Encrypt;

/**
 * Servlet implementation class StuLogin
 */
@WebServlet(name="/StuLogin",urlPatterns="/login.do")
public class StuLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuLogin() {
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
	    RecordDao recordDao = new RecordDaoImpl();
	    String username = request.getParameter("username");    /*接收表单数据*/
	    String password = request.getParameter("password");
	    String code = request.getParameter("code");
	    request.setAttribute("username", username);    /*表单数据保存至request作用域*/
	    request.setAttribute("password", password);
	    request.setAttribute("code", code);
	    String mess = validateForm(username, password, code);    /*表单数据规范性的服务器端验证*/
	    if (!"".equals(mess)){
	      request.setAttribute("stuLoginMess", mess);
	      request.getRequestDispatcher("/index.jsp").forward(request, response);
	    }else {
	      String sessioncode = session.getAttribute("sessioncode").toString();
	      if (!code.equals(sessioncode)) {
	        request.setAttribute("stuLoginMess", "* 验证码错误！");
	        request.getRequestDispatcher("/index.jsp").forward(request, response);
	      }else if (stuDao.validateLogin(username, Encrypt.SHA(password)) == null) {
	        request.setAttribute("stuLoginMess", "* 用户名或密码输入错误！");
	        request.getRequestDispatcher("/index.jsp").forward(request, response);
	      }else {
	        Record record = new Record();
	        record.setLogname(username);
	        record.setUsergroup("学生");
	        record.setLogip(request.getRemoteAddr());
	        if (recordDao.add(record) != 0) {
	          session.setAttribute("username", username);
	          response.sendRedirect(request.getContextPath() + "/stu/notice.jsp");
	        } else {
	          request.setAttribute("stuLoginMess", "* 登录异常！");
	          request.getRequestDispatcher("/index.jsp").forward(request, response);
	        }
	      }
	    }
	}
	
	private String validateForm(String username,String password,String code){
	    if (username == null || !username.matches("\\w{6,20}")){
	      return "* 用户名错误！";
	    }else if (password == null || !password.matches("\\w{6,20}")) {
	      return "* 密码错误！";
	    }else if (code == null || !code.matches("\\d{4}")) {
	      return "* 验证码错误！";
	    }
	    return "";
	}
}
