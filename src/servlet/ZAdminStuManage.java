package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import dao.impl.StuDaoImpl;
import entity.Stu;
import util.Encrypt;

/**
 * Servlet implementation class ZAdminStuManage
 */
@WebServlet(name="/ZAdminStuManage",urlPatterns="/zadmin/stumanage.do")
public class ZAdminStuManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZAdminStuManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html; charset=utf-8");
	    ServletContext servletContext = request.getServletContext();
	    StuDao stuDao = new StuDaoImpl();
	    String action = request.getParameter("action");
	    if("findStusLikeUsername".equals(action)){
	      String username = request.getParameter("username").toString();
	      ArrayList<Stu> stus = stuDao.findStusLikeUsername(username);
	      request.setAttribute("stus", stus);
	      request.getRequestDispatcher("/zadmin/stumanage.jsp").forward(request, response);
	    }else if("findStusLikeIdcode".equals(action)) {
	      String idcode = request.getParameter("idcode").toString();
	      ArrayList<Stu> stus = stuDao.findStusLikeIdcode(idcode);
	      request.setAttribute("stus", stus);
	      request.getRequestDispatcher("/zadmin/stumanage.jsp").forward(request, response);
	    }else if ("stuPassReset".equals(action)){
	      String username = request.getParameter("username").toString();
	      if(stuDao.passModify(username, Encrypt.SHA("000000")) != 0){
	        request.setAttribute("stuPassResetMess", "* 用户 " + username + " 的密码已重置为‘000000’！");
	        request.getRequestDispatcher("/zadmin/stumanage.jsp").forward(request, response);
	      }else{
	        request.setAttribute("stuPassResetMess", "* 用户 " + username + " 的密码清零操作失败！");
	        request.getRequestDispatcher("/zadmin/stumanage.jsp").forward(request, response);
	      }
	    }else{
	      response.sendRedirect(servletContext.getContextPath()+"/zadmin/stumanage.jsp");
	    }
	}

}
