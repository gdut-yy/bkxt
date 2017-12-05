package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartUpload;

import util.Message;

/**
 * Servlet implementation class SAdminDb
 */
@WebServlet(name="/SAdminDb",urlPatterns="/sadmin/db.do")
public class SAdminDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SAdminDb() {
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
		String action = request.getParameter("action"); 
		

		if("backup".equals(action)){
			Runtime runtime = Runtime.getRuntime();
			
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
			String time=format.format(date);

			Process process = runtime.exec("cmd /c mysqldump -uroot -proot bkxt >C:/Progra~1/apache-tomcat-7.0.56/webapps/bkxt/backup/"+time+".sql");	
			try {
				int tag = process.waitFor();
				if(tag == 0){
					 session.setAttribute("mess", new Message("backupMess", "备份成功"));
				}else{
					session.setAttribute("mess", new Message("backupMess", "备份失败"));
				}
				
				SmartUpload su=new SmartUpload();  
				su.initialize(this.getServletConfig(),request,response);  
				su.setContentDisposition(null);  
				su.downloadFile("/backup/"+time+".sql");    
				response.getOutputStream().close();  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			response.sendRedirect(servletContext.getContextPath()+"/sadmin/db.jsp");
			
		}else if("restore".equals(action)){
			Runtime runtime = Runtime.getRuntime();
			String relativepath = "/backup/";	
			SmartUpload su = new SmartUpload();
			String message = null;
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
			String time=format.format(date);

			try {
				su.initialize(getServletConfig(), request, response);
				su.setMaxFileSize(1000000);
				su.setAllowedFilesList("sql");
				su.upload();
				com.jspsmart.upload.File file = su.getFiles().getFile(0);
				if (file.isMissing()) {
					message = "*请先选择要上传的文件";
				} else {
					file.saveAs(relativepath + time+".sql",SmartUpload.SAVE_VIRTUAL);	
					message = "*上传成功!";
				}

			}catch (SecurityException e) {
				if (e.getMessage().trim().matches("(.*)1010\\)\\.$")) {
					message = "*上传的文件类型不正确!";
				} else if (e.getMessage().trim().matches("(.*)1105\\)\\.$")) {
					message = "*文件大小超出了1M!";
				}else {
					message = "*上传错误!";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Process process = runtime.exec("cmd /c mysql -uroot -proot bkxt <C:/Progra~1/apache-tomcat-7.0.56/webapps/bkxt/backup/"+time+".sql");	
			try {
				int tag = process.waitFor();
				if(tag == 0){
					 session.setAttribute("mess", new Message("restoreMess", "还原成功"));
				}else{
					session.setAttribute("mess", new Message("restoreMess", message+" 还原失败"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect(servletContext.getContextPath()+"/sadmin/db.jsp");
		}
	}

}
