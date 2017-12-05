package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDao;
import dao.MajorDao;
import dao.SchoolDao;
import dao.impl.CourseDaoImpl;
import dao.impl.MajorDaoImpl;
import dao.impl.SchoolDaoImpl;
import entity.Course;
import entity.Major;
import entity.School;
import util.Message;

/**
 * Servlet implementation class ZAdminRelease
 */
@WebServlet(name="/ZAdminRelease",urlPatterns="/zadmin/release.do")
public class ZAdminRelease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZAdminRelease() {
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
	    SchoolDao schoolDao = new SchoolDaoImpl();
	    MajorDao majorDao = new MajorDaoImpl();
	    CourseDao courseDao = new CourseDaoImpl();
	    String action = request.getParameter("action");
	    //���ԺУ������Ϣ
	    if("schoolAdd".equals(action)){
	      School school = new School();
	      school.setShcode(request.getParameter("shcode"));
	      school.setShname(request.getParameter("shname"));
	      school.setShaddr(request.getParameter("shaddr"));
	      school.setShzip(request.getParameter("shzip"));
	      school.setShtel(request.getParameter("shtel"));
	      school.setShtest(request.getParameter("shtest"));
	      school.setShyear(request.getParameter("shyear"));
	      if(schoolDao.add(school) != 0){
	        servletContext.setAttribute("school", school);
	        session.setAttribute("mess", new Message("schoolAddMess", "ѧУ������Ϣ���óɹ���"));
	      }else{
	        session.setAttribute("mess", new Message("schoolAddMess", "ѧУ������Ϣ����ʧ�ܣ�"));
	      }
	      response.sendRedirect(servletContext.getContextPath()+"/zadmin/release.jsp");
	     //����µ�רҵ
	    }else if("majorAdd".equals(action)){
	      String mcode = request.getParameter("mcode");
	      Major major = new Major();
	      major.setMcode(mcode);
	      major.setMname(request.getParameter("mname"));
	      major.setPlannum(Integer.parseInt(request.getParameter("plannum")));
	      if(majorDao.findByMcode(mcode) != null){
	        session.setAttribute("mess", new Message("majorAddMess", "רҵ���벻���ظ���"));
	      }else if(majorDao.add(major) != 0){
	        servletContext.setAttribute("majors", majorDao.findAll());
	        session.setAttribute("mess", new Message("majorAddMess", "רҵ��ӳɹ���"));
	      }else{
	        session.setAttribute("mess", new Message("majorAddMess", "רҵ���ʧ�ܣ�"));
	      }
	      response.sendRedirect(servletContext.getContextPath()+"/zadmin/release.jsp#major");
	    //ɾ������רҵ
	    }else if("majorDelete".equals(action)){
	      String mcode = request.getParameter("mcode");
	      Major major = majorDao.findByMcode(mcode);
	      if (major != null && !courseDao.findByCmname(major.getMname()).isEmpty()){
	        session.setAttribute("mess", new Message("majorDeleteMess", "����ɾ��'"+major.getMname()+"'רҵ�����пγ̣�"));
	      }
	      else if(majorDao.deleteByMcode(mcode) != 0){
	        servletContext.setAttribute("majors", majorDao.findAll());
	        session.setAttribute("mess", new Message("majorDeleteMess", "רҵɾ���ɹ���"));
	      }else{
	        session.setAttribute("mess", new Message("majorDeleteMess", "רҵɾ��ʧ�ܣ�"));
	      }
	      response.sendRedirect(servletContext.getContextPath()+"/zadmin/release.jsp#major");
	    //����µĿγ�
	    }else if ("courseAdd".equals(action)){
	      String ccode = request.getParameter("ccode");
	      Course course = new Course();
	      course.setCcode(ccode);
	      course.setCname(request.getParameter("cname"));
	      course.setCmname(request.getParameter("cmname"));
	      course.setCstarttime(request.getParameter("cstarttime"));
	      course.setCendtime(request.getParameter("cendtime"));
	      if(courseDao.findByCcode(ccode) != null){
	        session.setAttribute("mess", new Message("courseAddMess", "�γ̴��벻���ظ���"));
	      }else if(courseDao.add(course) != 0){
	        servletContext.setAttribute("courses", courseDao.findAll());
	        session.setAttribute("mess", new Message("courseAddMess", "�γ���ӳɹ���"));
	      }else{
	        session.setAttribute("mess", new Message("courseAddMess", "�γ����ʧ�ܣ�"));
	      }
	      response.sendRedirect(servletContext.getContextPath()+"/zadmin/release.jsp#course");
	    //ɾ�����пγ�
	    }else if("courseDelete".equals(action)){
	      String ccode = request.getParameter("ccode");
	      if(courseDao.deleteByCcode(ccode) != 0){
	        servletContext.setAttribute("courses", courseDao.findAll());
	        session.setAttribute("mess", new Message("courseDeleteMess", "�γ�ɾ���ɹ���"));
	      }else{
	        session.setAttribute("mess", new Message("courseDeleteMess", "�γ�ɾ��ʧ�ܣ�"));
	      }
	      response.sendRedirect(servletContext.getContextPath()+"/zadmin/release.jsp#course");
	    //�������
	    }else{
	      session.removeAttribute("mess");
	      response.sendRedirect(servletContext.getContextPath()+"/zadmin/release.jsp");
	    }
	}

}
