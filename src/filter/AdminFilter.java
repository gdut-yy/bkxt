package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminFilter implements Filter{

  @Override
  public void destroy() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    // TODO Auto-generated method stub
    HttpServletRequest req = (HttpServletRequest)request;
    HttpSession session = req.getSession();
    if(session != null && session.getAttribute("adminuser") != null){
        chain.doFilter(request, response);    
    }else{
        req.setAttribute("adminLoginMess", "* 璇峰厛鐧诲綍锛�");
        req.getRequestDispatcher("/manage.jsp").forward(request, response);
    }
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // TODO Auto-generated method stub
    
  }

}
