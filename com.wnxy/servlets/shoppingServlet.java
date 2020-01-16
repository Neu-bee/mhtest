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
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.mysql.cj.Session;

import daos.shoppingsDao;
import entitys.shoppings;

/**
 * Servlet implementation class shoppingServlet
 */
@WebServlet({"/front/addShop.do","/front/getShopping.do","/front/updateCartCount.do","/front/goCount.do"})
public class shoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletPath();
		
		if(path.equals("/front/addShop.do")){
			String goodsId=request.getParameter("goodsId");
			System.out.println("goodsId  "+goodsId+"  到达shopServ");	
			int cusId=(int) request.getSession(false).getAttribute("uid");
			System.out.println("cusId是：   "+cusId);
			
			shoppings shopping=new shoppings(Integer.parseInt(goodsId), cusId);
			shoppingsDao shoppingDao=new shoppingsDao();
			
			try {
				shoppingDao.addShoppings(shopping);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			try {
				//获得我的所有购物记录
				List<shoppings> li=shoppingDao.getShoppingsByCusId(cusId);
				//获得登录成功的用户名
				String cuname=(String)request.getSession(false).getAttribute("cuname");
				//将用户名和转购物记录的集合封装到Map中
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("cuname", cuname);
				System.out.println("-------------------cuname"+cuname);
				map.put("shoppings", li);
				//将map转换为json对象
				HttpSession session=request.getSession();
				
				JSONObject js=new JSONObject(map);
				
				out.print(js);
				out.flush();
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.flush();
				out.close();
			}
		}
		//整合订单
		else if(path.equals("/front/goCount.do")){
			String shoppingIds=request.getParameter("sids");
			//System.out.println("------===========>>>>>>>>"+shoppingIds);
			//格式修改
			char[] cs=shoppingIds.toCharArray();
			String shoppingIdsFormat="";
			for(int i=0;i<cs.length;i++){
				if((cs[i]>='0'&&cs[i]<='9') ||(cs[i]==',')){
					shoppingIdsFormat=shoppingIdsFormat+cs[i];
				}
			}
			//System.out.println("------===========>>>>>>>>"+shoppingIdsFormat);
			shoppingsDao shoppingDao=new shoppingsDao();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			try {
				List<shoppings> li=shoppingDao.getSubShoppings(shoppingIdsFormat);
				String cuname=(String)request.getSession(false).getAttribute("cuname");
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("cuname", cuname);
				map.put("shoppings", li);
				JSONObject js=new JSONObject(map);
				out.print(js);
				out.flush();
				out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.flush();
				out.close();
			}
		}
		
		
		
		else if(path.equals("/front/getShopping.do")){
			
			//调用Dao层的方法获得我的购物车记录
//			int cusId=Integer.parseInt((String)request.getSession(false).getAttribute("cusId"));
			int cusId=(int) request.getSession(false).getAttribute("uid");
			System.out.println("cusId是：   "+cusId);
			
			shoppingsDao shoppingDao=new shoppingsDao();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			try {
				//获得我的所有购物记录
				List<shoppings> li=shoppingDao.getShoppingsByCusId(cusId);
				//获得登录成功的用户名
				String cuname=(String)request.getSession(false).getAttribute("cuname");
				//将用户名和转购物记录的集合封装到Map中
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("cuname", cuname);
				//System.out.println("cuname"+cuname);
				map.put("shoppings", li);
				//将map转换为json对象
				HttpSession session=request.getSession();
				session.setAttribute("dataMap", map);
				
				JSONObject js=new JSONObject(map);
				
				out.print(js);
				out.flush();
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.flush();
				out.close();
			}
		}
		
	
		
	else if(path.equals("/front/updateCartCount.do")){
		String shopping_count=request.getParameter("shopping_count");
		String shopping_id=request.getParameter("shopping_id");
		shoppingsDao sd=new shoppingsDao();
		System.out.println("shopping_id"+shopping_id+"shopping_count"+shopping_count);
		try {
			sd.updateShoppingsCount(Integer.parseInt(shopping_id), Integer.parseInt(shopping_count));
			PrintWriter out=response.getWriter();
			out.print("shopping_id"+shopping_id+"shopping_count"+shopping_count);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		
		
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
