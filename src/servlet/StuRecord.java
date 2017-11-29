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
import entity.Record;
import util.PageModel;

/**
 * Servlet implementation class StuRecord
 */
@WebServlet(name="/StuRecord",urlPatterns="/stu/record.do")
public class StuRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuRecord() {
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
	    HttpSession session = request.getSession();
	    RecordDao recordDao = new RecordDaoImpl();
	    int pageSize,pageNo;
	    try{
	      pageSize = request.getParameter("pageSize") == null ? 10 : Integer.parseInt(request.getParameter("pageSize").toString());
	      pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo").toString());
	    }catch (NumberFormatException e) {
	      pageSize=10;
	      pageNo=1;
	    }
	    String username = (String)session.getAttribute("username");
	    PageModel<Record> pm =  recordDao.pageByLogname(username, "Ñ§Éú",pageSize, pageNo);
	    pm.setPageNav(request.getRequestURI());
	    request.setAttribute("pm", pm);
	    request.getRequestDispatcher("/stu/record.jsp").forward(request, response);
	}

}
