package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminuserDao;
import dao.impl.AdminuserDaoImpl;
import entity.Adminuser;
import util.Encrypt;

/**
 * Servlet implementation class SAdminManage
 */
@WebServlet(name="/SAdminManage",urlPatterns="/sadmin/manage.do")
public class SAdminManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SAdminManage() {
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
	    AdminuserDao adminuserDao = new AdminuserDaoImpl();
	    String action = request.getParameter("action");
	    if("findAll".equals(action)){
	      ArrayList<Adminuser> adminusers = adminuserDao.findAll();
	      request.setAttribute("adminusers", adminusers);
	      request.getRequestDispatcher("/sadmin/manage.jsp").forward(request, response);
	    }else {
	      if ("add".equals(action)){
	        String adminname = request.getParameter("adminname");
	        String adminpass = request.getParameter("adminpass");
	        String admingroup = request.getParameter("admingroup");
	        Adminuser adminuser = new Adminuser();
	        adminuser.setAdminname(adminname);
	        adminuser.setAdminpass(Encrypt.SHA(adminpass));
	        adminuser.setAdmingroup(admingroup);
	        request.setAttribute("newadmin", adminuser);
	        String mess = validateForm(adminname, adminpass, admingroup);
	        if (!"".equals(mess)){
	          request.setAttribute("addMess", mess);
	        }else {
	          if(adminuserDao.findByAdminname(adminname) != null){
	            request.setAttribute("addMess", "* �û����Ѵ��ڣ�");
	          }else if(adminuserDao.add(adminuser) != 0 ){
	            request.removeAttribute("newadmin");
	            request.setAttribute("addMess", "* ����¹���Ա�ɹ���");
	          }else {
	            request.setAttribute("addMess", "* ����¹���Աʧ�ܣ�");
	          }
	        }
	      }else if ("deleteByAdminname".equals(action)){
	        String adminname = request.getParameter("adminname");
	        if(adminuserDao.findByAdminname(adminname).getAdmingroup().equals("ϵͳ����Ա")){
	          request.setAttribute("manageMess", "* ����ɾ��ϵͳ����Ա��");
	        }else if(adminuserDao.deleteByAdminname(adminname) != 0){
	          request.setAttribute("manageMess", "* ɾ������Ա�ɹ���");
	        }else{
	          request.setAttribute("manageMess", "* ɾ������Աʧ�ܣ�");
	        }
	      }else if ("passReset".equals(action)){
	        String adminname = request.getParameter("adminname");
	        if(adminuserDao.passModify(adminname,Encrypt.SHA("000000")) != 0){
	          request.setAttribute("manageMess", "* ����Ա��������ɹ���");
	        }else{
	          request.setAttribute("manageMess", "* ����Ա��������ʧ�ܣ�");
	        } 
	      }
	      request.getRequestDispatcher("/sadmin/manage.do?action=findAll").forward(request, response); 
	    }
	}

	private String validateForm(String adminname, String adminpass, String admingroup) {
		// TODO Auto-generated method stub
		if (adminname == null || !adminname.matches("\\w{6,20}")){
		      return "* �û������Ϸ���";
		    }else if (adminpass == null || !adminpass.matches("\\w{6,20}")) {
		      return "* ���벻�Ϸ���";
		    }else if (!"��������Ա".equals(admingroup) && !"�������Ա".equals(admingroup)) {
		      return "* �û������ô���";
		    }
		    return "";
	}

}
