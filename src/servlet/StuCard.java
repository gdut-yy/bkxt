package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.CourseDaoImpl;
import dao.impl.MajorDaoImpl;
import dao.impl.ReginfoDaoImpl;
import entity.Course;
import entity.Currstage;
import entity.Reginfo;

/**
 * Servlet implementation class StuCard
 */
@WebServlet(name="/StuCard",urlPatterns="/stu/card.do")
public class StuCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuCard() {
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
		Currstage stage = (Currstage)this.getServletContext().getAttribute("currstage");
	    ReginfoDaoImpl regimpl = new ReginfoDaoImpl();
		  HttpSession session = request.getSession();
		  Reginfo reg = regimpl.findByUser((String)session.getAttribute("username"));
		  MajorDaoImpl majimp = new MajorDaoImpl();
		  CourseDaoImpl courseImpl = new CourseDaoImpl();
		  ArrayList<Course> courses = courseImpl.findByCmname(reg.getMname());
		  request.setAttribute("courses", courses);
		  request.setAttribute("reginfo", reg);
		  request.getRequestDispatcher("/stu/card.jsp").forward(request, response);
	}

}
