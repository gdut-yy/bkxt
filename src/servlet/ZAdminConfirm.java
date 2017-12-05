package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ReginfoDaoImpl;
import entity.Reginfo;

/**
 * Servlet implementation class ZAdminConfirm
 */
@WebServlet(name="/ZAdminConfirm",urlPatterns="/zadmin/confirm.do")
public class ZAdminConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZAdminConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		String idcode = request.getParameter("idcode");
		String confirmid = request.getParameter("confirm");

		if (idcode != null) {
			ReginfoDaoImpl reginfoImp = new ReginfoDaoImpl();
			Reginfo reg = null;
			reg = reginfoImp.findByIdcode(idcode);
			request.setAttribute("reginfo", reg);
			request.setAttribute("isconfirmed", reg.getIsconfirm());
		}
		if (confirmid != null) {
			ReginfoDaoImpl reginfoImp = new ReginfoDaoImpl();
			reginfoImp.update(confirmid, 1);
		}
		request.getRequestDispatcher("/zadmin/confirm.jsp").forward(request,
				response);
	}

}
