package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.GradeDaoImpl;
import dao.impl.ReginfoDaoImpl;
import entity.Reginfo;
import entity.SupGrade;

/**
 * Servlet implementation class StuGrade
 */
@WebServlet(name="/StuGrade",urlPatterns="/stu/grade.do")
public class StuGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuGrade() {
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
		HttpSession session =  request.getSession();
		  String username = (String)session.getAttribute("username");
		  ReginfoDaoImpl reginfoImp =  new ReginfoDaoImpl();
		  Reginfo reginfo = reginfoImp.findByUser(username);
		  String testcardnum = reginfo.getTestcardnum();
		  GradeDaoImpl gradeImp = new GradeDaoImpl();
		  ArrayList<SupGrade> supgrades = gradeImp.findByCardnum(testcardnum);
		  request.setAttribute("grade", supgrades);
		  request.getRequestDispatcher("/stu/grade.jsp").forward(request, response);
	}

}
