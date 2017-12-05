package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import dao.ReginfoDao;
import dao.impl.ReginfoDaoImpl;

/**
 * Servlet implementation class StuPhoto
 */
@WebServlet(name="/StuPhoto",urlPatterns="/stu/photo.do")
public class StuPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuPhoto() {
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
		  SmartUpload upload = new SmartUpload();
		  upload.initialize(this.getServletConfig(),request,response);
		  upload.setAllowedFilesList("jpg,JPG");

		  try {
			  upload.upload();
			  String filename = "/upload/"+username+".jpg";
			  Files files = upload.getFiles();
			  files.getFile(0).saveAs(filename, SmartUpload.SAVE_VIRTUAL);
			} catch (SmartUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
		  ReginfoDao regDao = new ReginfoDaoImpl();
		  regDao.update(username+".jpg", username);
		  request.getRequestDispatcher("/stu/photo.jsp").forward(request, response);
	}

}
