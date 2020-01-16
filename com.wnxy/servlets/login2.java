package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.employeeDao;
import entitys.employee;
import tools.MD5TOOLS;



/**
 * Servlet implementation class login2
 */
@WebServlet({"/login2","/exit.do","/checkPwd.do","/changePsw.do"})
public class login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login2() {
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
		employeeDao us=new employeeDao();
		
		if(path.equals("/login2")){
			String checkCode=(String) request.getParameter("checkCode");
			String name=(String) request.getParameter("name");
			String psw=(String) request.getParameter("psw");
			System.out.println("已接收员工用户："+name+"\t和密码："+psw);
			
			
			MD5TOOLS md5=new MD5TOOLS();
			try {
				psw=md5.getMD5String(psw);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			employee emp=us.checkCount(name, psw);
			
			if(emp!=null){
				session.setAttribute("uname", name);
				Cookie cookieName=new Cookie("username",URLEncoder.encode(name,"UTF-8"));
				cookieName.setMaxAge(3600);
				response.addCookie(cookieName);
				session.setAttribute("eid", emp.getEmployee_id());
				
				
//				ServletContext context=request.getServletContext();
//				int count=0;
//				if(context.getAttribute("online")!=null){
//					count=(Integer)context.getAttribute("online");
//				}
//				count++;
//				context.setAttribute("online", count);
				
				
				String sessionCheckCode=(String)session.getAttribute("checkCode");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				if(!checkCode.equalsIgnoreCase(sessionCheckCode)){
					//弹出对话框，跳转到登录页面
					out.print("<script>alert('验证码不正确');location.href='login.jsp'</script>");
					out.flush();
					out.close();
					return;
				}
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("fail.jsp");
			}
		}
		else if(path.equals("/exit.do")){
			session.setAttribute("uname", null);
			session.removeAttribute("uname");
			response.sendRedirect("login.jsp");
		}
		else if(path.equals("/checkPwd.do")){
//			System.out.println("密码修改servlet开始执行");
			String pwd=request.getParameter("oldPwd");
			int userId=(int) session.getAttribute("eid");
//			System.out.println("userId======"+userId);
			try {
				employee emp=new employee(userId,MD5TOOLS.getMD5String(pwd));
				employeeDao ed=new employeeDao();
				boolean tag=ed.isExitPwd(emp);
			
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print(tag);
				out.flush();
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(path.equals("/changePsw.do")){
			String pwd=(String)request.getParameter("userNewPwd");
			int eid=(int) session.getAttribute("eid");
			employeeDao ed=new employeeDao();
			ed.changePsw(eid, pwd);
			PrintWriter out=response.getWriter();
			out.print("login.jsp");
			out.flush();
			out.close();
		}
		
		
	}
}
