package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CountListener
 *
 */
@WebListener
public class CountListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public CountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	ServletContext context=se.getSession().getServletContext(); 
        if(context.getAttribute("count") == null){ 
          Integer count = new Integer(1); 
          context.setAttribute("count", count);
        }else{ 
          Integer count = (Integer)context.getAttribute("count"); 
          context.setAttribute("count", count+1);
        } 
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	ServletContext context=se.getSession().getServletContext(); 
        Integer count = (Integer)context.getAttribute("count"); 
        context.setAttribute("count", count-1);
    }
	
}
