package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StageDao;
import dao.impl.StageDaoImpl;
import entity.Stage;
import util.Message;

/**
 * Servlet implementation class SAdminStageAdd
 */
@WebServlet(name="/SAdminStageAdd",urlPatterns="/sadmin/stageadd.do")
public class SAdminStageAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SAdminStageAdd() {
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
	    StageDao stageDao = new StageDaoImpl();
	    String action = request.getParameter("action");
	    
	    if ("stageAdd".equals(action)){
	      int stagenum = Integer.parseInt(request.getParameter("stagenum").toString());
	      Stage stage = new Stage();
	      stage.setStagenum(stagenum);
	      stage.setStagename(request.getParameter("stagename"));
	      stage.setStarttime(request.getParameter("starttime"));
	      stage.setEndtime(request.getParameter("endtime"));
	      stage.setNote(request.getParameter("note"));
	      if(stageDao.findByStagenum(stagenum) != null){
	        session.setAttribute("mess", new Message("stageAddMess", "½×¶Î±àºÅ²»ÄÜÖØ¸´£¡"));
	      }else if(stageDao.add(stage) != 0){
	        servletContext.setAttribute("stages", stageDao.findAll());
	        session.setAttribute("mess", new Message("stageAddMess", "Ìí¼Ó½×¶Î³É¹¦£¡"));
	      }else{
	        session.setAttribute("mess", new Message("stageAddMess", "Ìí¼Ó½×¶ÎÊ§°Ü£¡"));
	      }
	      response.sendRedirect(servletContext.getContextPath()+"/sadmin/stageadd.jsp#add");
	    //É¾³ýÏµÍ³½×¶Î
	    }else if("stageDelete".equals(action)){
	      int stagenum = Integer.parseInt(request.getParameter("stagenum").toString());;
	      if(stageDao.deleteByStagenum(stagenum) != 0){
	        servletContext.setAttribute("stages", stageDao.findAll());
	        session.setAttribute("mess", new Message("stageDeleteMess", "½×¶ÎÉ¾³ý³É¹¦£¡"));
	      }else{
	        session.setAttribute("mess", new Message("stageDeleteMess", "½×¶ÎÉ¾³ýÊ§°Ü£¡"));
	      }
	      response.sendRedirect(servletContext.getContextPath()+"/sadmin/stageadd.jsp");
	    //ÆäËûÇé¿ö
	    }else{
	      session.removeAttribute("mess");
	      response.sendRedirect(servletContext.getContextPath()+"/sadmin/stageadd.jsp");
	    }
	}

}
