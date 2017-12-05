package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.ReginfoDaoImpl;
import entity.Reginfo;

/**
 * Servlet implementation class StuForm
 */
@WebServlet(name="/StuForm",urlPatterns="/stu/form.do")
public class StuForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuForm() {
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
		ReginfoDaoImpl regimpl = new ReginfoDaoImpl();
		  HttpSession session = request.getSession();
		  Reginfo reg = regimpl.findByUser((String)session.getAttribute("username"));
		  request.setAttribute("reginfo", reg);
	    request.getRequestDispatcher("/stu/form.jsp").forward(request, response);
	}

}
