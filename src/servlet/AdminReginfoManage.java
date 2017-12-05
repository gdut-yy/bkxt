package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDao;
import dao.impl.RecordDaoImpl;
import entity.Major;
import entity.Reginfo;
import util.PageModel;

/**
 * Servlet implementation class AdminReginfoManage
 */
@WebServlet(name="/AdminReginfoManage",urlPatterns="/admin/reginfomanage.do")
public class AdminReginfoManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReginfoManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
	    this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize").toString());
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo").toString());
		RecordDao recordDao = new RecordDaoImpl();

		ArrayList<Major> majors = (ArrayList<Major>)this.getServletContext().getAttribute("majors");
		request.setAttribute("majors", majors);
		String majorName = request.getParameter("mname");
		
		String isconfirm = request.getParameter("isconfirm");
		if (majorName != null && isconfirm != null) {
			PageModel<Reginfo> pm = recordDao.pageReginfo(majorName, isconfirm,pageSize, pageNo);
			pm.setPageNav(request.getRequestURI());
			request.setAttribute("pm", pm);
		}
		request.getRequestDispatcher("/jadmin/infomanage.jsp").forward(request,response);
	}

}
