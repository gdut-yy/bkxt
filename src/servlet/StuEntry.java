package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReginfoDao;
import dao.impl.ReginfoDaoImpl;
import entity.Reginfo;

/**
 * Servlet implementation class StuEntry
 */
@WebServlet(name="/StuEntry",urlPatterns="/stu/entry.do")
public class StuEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuEntry() {
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
		HttpSession session = request.getSession();
		  
		  String username = session.getAttribute("username").toString();
		  String action = request.getParameter("action");
		  ReginfoDao regDao = new ReginfoDaoImpl();
		  Reginfo reg = new Reginfo();
		  reg = regDao.findByUser(username);
		  String sname = reg.getSname();
		  if(action!=null && action.equals("entry")){
			  reg.setUsername(username);	  
			  reg.setSname(request.getParameter("sname"));
			  reg.setIdcode(request.getParameter("idcode"));
			  reg.setSsex(request.getParameter("ssex"));
			  reg.setAos(request.getParameter("aos"));
			  reg.setCet(request.getParameter("cet"));
			  reg.setConaddr(request.getParameter("conaddr"));
			  reg.setGradutetime(request.getParameter("gradutetime"));
			  reg.setHomeaddr(request.getParameter("homeaddr"));
			  reg.setIsnew(request.getParameter("isnew"));
			  reg.setMajor(request.getParameter("major"));
			  reg.setMname(request.getParameter("mname"));
			  reg.setMobile(request.getParameter("mobile"));
			  reg.setNation(request.getParameter("nation"));
			  reg.setPolitical(request.getParameter("political"));
			  reg.setReceiver(request.getParameter("receiver"));
			  reg.setSchool(request.getParameter("school"));
			  reg.setSource(request.getParameter("source"));
			  reg.setTelphone(request.getParameter("telphone"));
			  reg.setZipcode(request.getParameter("zipcode")); 
			  if(sname == null)
				  regDao.add(reg);
			  else
				  regDao.update(reg);
			  request.getSession().setAttribute("reginfo", reg);
			  request.setAttribute("reginfo", reg);
			  request.getRequestDispatcher("/stu/photo.jsp").forward(request, response);
		  }
		  else{
			  request.getSession().setAttribute("reginfo", reg);
			  request.setAttribute("reginfo", reg);
			  request.getRequestDispatcher("/stu/entry.jsp").forward(request, response);
		  }
	}

}
