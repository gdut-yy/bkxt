package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDao;
import dao.impl.MajorDaoImpl;
import dao.impl.RecordDaoImpl;
import dao.impl.ReginfoDaoImpl;
import entity.Major;
import entity.Reginfo;
import entity.School;
import util.PageModel;

/**
 * Servlet implementation class JAdminCardNum
 */
@WebServlet(name="/JAdminCardNum",urlPatterns="/jadmin/cardnum.do")
public class JAdminCardNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JAdminCardNum() {
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
		int pageSize = request.getParameter("pageSize") == null ? 5 : Integer
				.parseInt(request.getParameter("pageSize").toString());
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer
				.parseInt(request.getParameter("pageNo").toString());
		RecordDao recordDao = new RecordDaoImpl();

		String method = request.getParameter("action");

		if (method != null && method.equals("assign")) {
			ReginfoDaoImpl reginfoDao = new ReginfoDaoImpl();
			ArrayList<Reginfo> array = reginfoDao.findAll();
			Map<String, Integer> map = new HashMap<String, Integer>();
			School school = (School) this.getServletContext().getAttribute(
					"school");
			ArrayList<Major> majors = (ArrayList<Major>) this
					.getServletContext().getAttribute("majors");
			String shoolCode = school.getShcode();
			String year = school.getShyear();
			String testcardnum = year + shoolCode;

			for (Major major : majors) {
				map.put(major.getMname(), 1);
			}
			for (Reginfo reg : array) {
				MajorDaoImpl majorimp = new MajorDaoImpl();
				if (reg.getIsconfirm() == 0)
					continue;
				String tempMajor = reg.getMname();
				int tempNum = (Integer) map.get(tempMajor);
				map.put(tempMajor, tempNum + 1);
				testcardnum = testcardnum + majorimp.getByName(tempMajor)
						+ tempNum;
				reginfoDao.addCode(reg.getUsername(), testcardnum);
			}
		}
		PageModel<Reginfo> pm = recordDao.pageReginfo(pageSize, pageNo);
		pm.setPageNav(request.getRequestURI());
		request.setAttribute("pm", pm);
		request.getRequestDispatcher("/jadmin/assignnum.jsp").forward(request,
				response);
	}

}
