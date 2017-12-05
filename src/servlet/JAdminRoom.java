package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ReginfoDaoImpl;
import entity.Reginfo;

/**
 * Servlet implementation class JAdminRoom
 */
@WebServlet(name="/JAdminRoom",urlPatterns="/jadmin/room.do")
public class JAdminRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JAdminRoom() {
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

		ReginfoDaoImpl regInfoD = new ReginfoDaoImpl();
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("assign")) {
				int number = Integer.parseInt(request.getParameter("perRoom"));
				ArrayList<Reginfo> regs = regInfoD.findByIncrease();
				int totalNumber = regs.size();
				request.getSession().setAttribute("reginfos", regs);
				request.getSession().setAttribute("perRoom", number);
				int remain = totalNumber % number;
				int roomNum = remain == 0 ? totalNumber / number : totalNumber
						/ number + 1;
				System.out.println(remain);
				System.out.println(roomNum);
				request.setAttribute("room", roomNum);
				request.setAttribute("perroom", number);
				request.setAttribute("remain", remain);
			} else if (action.equals("assure")) {
				ArrayList<Reginfo> regsAssure = (ArrayList<Reginfo>) request
						.getSession().getAttribute("reginfos");
				int number = (Integer) request.getSession().getAttribute(
						"perRoom");
				String[] rooms = request.getParameterValues("rooms");
				System.out.println(regsAssure.size());
				Iterator<Reginfo> regIter = regsAssure.iterator();
				int exameNum = 1;
				for (String room : rooms) {
					for (int i = 1; i <= number; i++) {
						if (!regIter.hasNext())
							break;
						Reginfo tempReg = regIter.next();
						regInfoD.update(tempReg.getUsername(), exameNum + "-"
								+ room, i);
					}
					exameNum++;
				}
			}
		}
		request.getRequestDispatcher("/jadmin/assignroom.jsp").forward(request,
				response);
	}

}
