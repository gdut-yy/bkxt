package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecordDao;
import dao.impl.RecordDaoImpl;
import entity.Adminuser;
import entity.Record;
import util.PageModel;

/**
 * Servlet implementation class AdminRecord
 */
@WebServlet(name="/AdminRecord",urlPatterns="/admin/record.do")
public class AdminRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRecord() {
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
	    RecordDao recordDao = new RecordDaoImpl();
	    
	    int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize").toString());
	    int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo").toString());
	    Adminuser adminuser = (Adminuser)session.getAttribute("adminuser");
	    String logname = adminuser.getAdminname();
	    String usergroup = adminuser.getAdmingroup();
	    PageModel<Record> pm =  recordDao.pageByLogname(logname, usergroup,pageSize, pageNo);
	    pm.setPageNav(request.getRequestURI());
	    
	    request.setAttribute("pm", pm);
	    request.getRequestDispatcher("/admin/record.jsp").forward(request, response);
	}

}
