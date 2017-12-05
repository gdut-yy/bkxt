package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.RecordDao;
import dao.impl.GradeDaoImpl;
import dao.impl.RecordDaoImpl;
import entity.SupGrade;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import util.PageModel;

/**
 * Servlet implementation class JAdminGradeInput
 */
@WebServlet(name="/JAdminGradeInput",urlPatterns="/jadmin/gradeinput.do")
public class JAdminGradeInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JAdminGradeInput() {
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
		response.setContentType("text/html");
	    int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize").toString());
	    int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo").toString());

	    HttpSession session = request.getSession();
	    RecordDao recordDao = new RecordDaoImpl();
	    System.out.println(pageNo);
	    PageModel<SupGrade> pm =  recordDao.pageByLogname(pageSize, pageNo);
	    pm.setPageNav(request.getRequestURI());
	    
	    File file = (File)request.getAttribute("file1");
		if(file != null){
			try {
				GradeDaoImpl gradeImpl = new GradeDaoImpl();
				Workbook workbook = Workbook.getWorkbook(file);
				Sheet sheet = workbook.getSheet(0);
				for(int row = 2;row < sheet.getRows()-1;row++){
					SupGrade supgrade = new SupGrade();
					supgrade.setTestcardnum(sheet.getCell(1,row).getContents().trim());
					supgrade.setSname(sheet.getCell(2,row).getContents().trim());
					supgrade.setCname(sheet.getCell(3,row).getContents().trim());
					supgrade.setScore(Integer.parseInt(sheet.getCell(4,row).getContents().trim()));
					supgrade.setNote(sheet.getCell(5,row).getContents().trim());
					gradeImpl.gradeAdd(supgrade);	
					}
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    request.setAttribute("pm", pm);
	    request.getRequestDispatcher("/jadmin/grade.jsp").forward(request, response);
	}

}
