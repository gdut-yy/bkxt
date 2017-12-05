package listener;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.CourseDao;
import dao.CurrstageDao;
import dao.MajorDao;
import dao.SchoolDao;
import dao.StageDao;
import dao.impl.CourseDaoImpl;
import dao.impl.CurrstageDaoImpl;
import dao.impl.MajorDaoImpl;
import dao.impl.SchoolDaoImpl;
import dao.impl.StageDaoImpl;
import entity.Course;
import entity.Currstage;
import entity.Major;
import entity.School;
import entity.Stage;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	sce.getServletContext().removeAttribute("school");
        sce.getServletContext().removeAttribute("majors");
        sce.getServletContext().removeAttribute("courses");
        sce.getServletContext().removeAttribute("stages");
        sce.getServletContext().removeAttribute("currstage");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	SchoolDao schoolDao = new SchoolDaoImpl();
        MajorDao majorDao = new MajorDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();
        StageDao stageDao = new StageDaoImpl();
        CurrstageDao currstageDao = new CurrstageDaoImpl();  
        School school = schoolDao.getSchool();
        ArrayList<Major> majors = majorDao.findAll(); 
        ArrayList<Course> courses = courseDao.findAll(); 
        ArrayList<Stage> stages = stageDao.findAll(); 
        Currstage currstage = currstageDao.findCurrent();  
        sce.getServletContext().setAttribute("school", school);
        sce.getServletContext().setAttribute("majors", majors);
        sce.getServletContext().setAttribute("courses", courses);
        sce.getServletContext().setAttribute("stages", stages);
        sce.getServletContext().setAttribute("currstage", currstage);
    }
	
}
