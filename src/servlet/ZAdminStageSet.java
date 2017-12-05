package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CurrstageDao;
import dao.impl.CurrstageDaoImpl;
import entity.Adminuser;
import util.Message;

/**
 * Servlet implementation class ZAdminStageSet
 */
@WebServlet(name="/ZAdminStageSet",urlPatterns="/zadmin/stageset.do")
public class ZAdminStageSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZAdminStageSet() {
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
	    ServletContext servletContext = request.getServletContext();
	    HttpSession session = request.getSession();
	    String action = request.getParameter("action");
	   
	    if("stageSet".equals(action)){
	      CurrstageDao currstageDao = new CurrstageDaoImpl();
	      Adminuser adminuser = (Adminuser)session.getAttribute("adminuser");
	      String adminname = adminuser.getAdminname();
	      String currstage = request.getParameter("currstage");
	      if (currstageDao.set(adminname, currstage) != 0) {
	        servletContext.setAttribute("currstage", currstageDao.findCurrent());
	        session.setAttribute("mess", new Message("stageSetMess", "Ω◊∂Œ…Ë÷√≥…π¶£°"));
	      }else {
	        session.setAttribute("mess", new Message("stageAddMess", "Ω◊∂Œ…Ë÷√ ß∞‹£°"));
	      }
	      response.sendRedirect(servletContext.getContextPath()+"/zadmin/stageset.jsp");
	    }else{
	      session.removeAttribute("mess");
	      response.sendRedirect(servletContext.getContextPath()+"/zadmin/stageset.jsp");
	    }
	}

}
