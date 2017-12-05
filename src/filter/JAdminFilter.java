package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Adminuser;


@WebFilter(filterName="JAdminFilter",urlPatterns="/jadmin/*")
public class JAdminFilter implements Filter{

  @Override
  public void destroy() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    
    HttpServletRequest req = (HttpServletRequest)request;
    HttpSession session = req.getSession();
    if(session != null && session.getAttribute("adminuser") != null){
      Adminuser adminuser = (Adminuser)session.getAttribute("adminuser");
      if("鏁欏姟绠＄悊鍛�".equals(adminuser.getAdmingroup())){
        chain.doFilter(request, response);
      }else{
        req.setAttribute("adminLoginMess", "* 璇峰厛鐧诲綍锛�");
        req.getRequestDispatcher("/manage.jsp").forward(request, response);
      }
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
