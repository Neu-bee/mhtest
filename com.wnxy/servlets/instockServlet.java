package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.instockDao;
import entitys.goods;
import entitys.instock;

/**
 * Servlet implementation class instockServlet
 */
@WebServlet({"/instock/list.do","/instock/instockDel.do","/instock/instockOut.do","/instock/instockIn.do"})
public class instockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public instockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletPath();
		request.setCharacterEncoding("UTF-8");
		instockDao id=new instockDao();
		
		if(path.equals("/instock/list.do")){
			String inStock_code = request.getParameter("inStock_code");
			List<instock> li = id.getAllinstock(inStock_code);
			
			request.setAttribute("inStock_code", inStock_code);
			request.setAttribute("list", li);
			request.getRequestDispatcher("instock.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
