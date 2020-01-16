package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import daos.orderDao;
import daos.shoppingsDao;
import entitys.orders;
import entitys.shoppings;

/**
 * Servlet implementation class orderServlet
 */
@WebServlet("/front/order_sub.do")
public class orderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String shoppingIds=request.getParameter("sids");
		String orderPrice=request.getParameter("totalprice");
		String orderRemark=request.getParameter("orderRemark");
		int cusId=(int)request.getSession(false).getAttribute("uid");
		
		//System.out.println("------===========>>>>>>>>"+shoppingIds);
		//×Ö·û´®¸ñÊ½ÐÞ¸Ä
		char[] cs=shoppingIds.toCharArray();
		String shoppingIdsFormat="";
		for(int i=0;i<cs.length;i++){
			if((cs[i]>='0'&&cs[i]<='9') ||(cs[i]==',')){
				shoppingIdsFormat=shoppingIdsFormat+cs[i];
			}
		}
		
		orders order=new orders(cusId, Float.parseFloat(orderPrice), orderRemark);
		
		orderDao od=new orderDao();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		try {
			od.addOrder(order, shoppingIdsFormat);
			out.print("½áËãÍê±Ï£¬Ð»Ð»»Ý¹Ë£¡");
			out.flush();
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.flush();
			out.close();
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
