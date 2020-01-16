package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
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

import daos.goodsDao;
import entitys.goods;


/**
 * Servlet implementation class goodsFrontServlet
 */
@WebServlet("/front/frontList.do")
public class goodsFrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsFrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");

		if (path.equals("/front/frontList.do")) {
			String goods_code = req.getParameter("goods_code");
			String goods_name = req.getParameter("goods_name");
			Map<String, Object> map;
			goodsDao gd = new goodsDao();
			String cuname=(String)req.getSession(false).getAttribute("cuname");
			// 分页
			
			try {
//				map = new HashMap<String, Object>();
//				map.put("goods_code", goods_code);
//				map.put("goods_name", goods_name);
//				map.put("cuname", cuname);
				PageBean<goods> pageBean= new PageBean<goods>();
				
				pageBean.setCuname(cuname);
				int totalCount = gd.getTotalCount(goods_code, goods_name);
				// 总行数
				pageBean.setTotalCount(totalCount);

				// 每页条目数
				String tempPageSize = req.getParameter("pageSize");
				int pageSize = 12;

				if (tempPageSize != null) {
					pageSize = Integer.parseInt(tempPageSize);
				}
				// 设置总页数
				pageBean.setPageSize(pageSize);

				int currentPage = 1;
				String tempCurrentPage = req.getParameter("cutPage");
				if (tempCurrentPage != null) {
					currentPage = Integer.parseInt(tempCurrentPage);
				}
				// 防止变为负数
				if (currentPage < 1) {
					currentPage = 1;
				}
				// 防止溢出
				if (currentPage > pageBean.getPages()) {
					currentPage = pageBean.getPages();
					if (pageBean.getPages() == 0) {
						currentPage = 1;
					}
				}
				// System.out.println("------------------------总行数"+totalCount);

				pageBean.setCurrentPage(currentPage);
				List<goods> li = gd.getAllGoods(goods_code, goods_name, pageBean);
				System.out.println("商品数据已发送");
				pageBean.setData(li);
//				System.out.println(">>>>>>>>>>>>>>pageBean"+pageBean);
				//给客户端响应
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				JSONObject js=new JSONObject(pageBean);
				
				
				out.print(js);
				out.flush();
				out.close();
				
//				req.setAttribute("queryMap", map);
//				req.setAttribute("pb", pageBean);
//				req.getRequestDispatcher("goods.jsp").forward(req, resp);

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
