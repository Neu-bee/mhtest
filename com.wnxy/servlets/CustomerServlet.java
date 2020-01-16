package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.customerDao;
import entitys.customer;
import tools.MD5TOOLS;



/**
 * Servlet implementation class login2
 */
@WebServlet({"/front/frontLogin.do","/frontExit.do","/frontCheckPwd.do","/frontChangePsw.do","/customer/list.do",})
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		HttpSession session=request.getSession();
		//注意此处不设置编码则为乱码，过滤器不在这里起作用
		request.setCharacterEncoding("UTF-8");
		customerDao cs=new customerDao();
		PrintWriter out=response.getWriter();
		if(path.equals("/front/frontLogin.do")){
			String checkCode=(String) request.getParameter("checkCode");
			String name=(String) request.getParameter("userName");
			String psw=(String) request.getParameter("userPwd");
			System.out.println("已接收员工用户："+name+"\t和密码："+psw);
			
			try {
				psw=MD5TOOLS.getMD5String(psw);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customer cus=cs.checkCount(name, psw);
			
			if(cus!=null){
				session.setAttribute("cuname", name);
//				Cookie cookieName=new Cookie("customerName",URLEncoder.encode(name,"UTF-8"));
//				cookieName.setMaxAge(3600);
//				response.addCookie(cookieName);
				session.setAttribute("uid", cus.getCus_id());
				
				
//				ServletContext context=request.getServletContext();
//				int count=0;
//				if(context.getAttribute("online")!=null){
//					count=(Integer)context.getAttribute("online");
//				}
//				count++;
//				context.setAttribute("online", count);
				
				
				String sessionCheckCode=(String)session.getAttribute("checkCode");
				response.setContentType("text/html;charset=UTF-8");
				
				if(!checkCode.equalsIgnoreCase(sessionCheckCode)){
					//弹出对话框，跳转到登录页面
					out.print(false);
				}
				out.print(true);
			}else{
				out.print(false);
			}
			out.flush();
			out.close();
		}
		
		
		else if(path.equals("/frontExit.do")){
			session.setAttribute("cuname", null);
			session.removeAttribute("cuname");
			response.sendRedirect("login.jsp");
		}
		
		
		else if(path.equals("/frontCheckPwd.do")){
//			System.out.println("密码修改servlet开始执行");
			String pwd=request.getParameter("oldPwd");
			int userId=(int) session.getAttribute("eid");
//			System.out.println("userId======"+userId);
			try {
				customer cus=new customer(userId,MD5TOOLS.getMD5String(pwd));
				customerDao ed=new customerDao();
				boolean tag=ed.isExitPwd(cus);
			
				response.setContentType("text/html;charset=utf-8");
				out.print(tag);
				out.flush();
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(path.equals("/frontChangePsw.do")){
			String pwd=(String)request.getParameter("userNewPwd");
			int eid=(int) session.getAttribute("eid");
			customerDao ed=new customerDao();
			ed.changePsw(eid, pwd);
			out.print("login.jsp");
			out.flush();
			out.close();
		}
		else if(path.equals("/customer/list.do")){
			customerDao ed=new customerDao();
			List<customer> li=ed.getAllcustomers();
			request.setAttribute("list", li);
			request.getRequestDispatcher("instock.jsp").forward(request, response);
		}
		
	}
}
