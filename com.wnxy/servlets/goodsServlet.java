package servlets;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.goodsDao;
import entitys.goods;

/**
 * Servlet implementation class goodsServlet
 */
@WebServlet({ "/goods/list.do", "/goods/goodsSave.do" })
public class goodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public goodsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");

		if (path.equals("/goods/list.do")) {
			String goods_code = req.getParameter("goods_code");
			String goods_name = req.getParameter("goods_name");
			Map<String, Object> map;
			goodsDao gd = new goodsDao();
			// ��ҳ
			PageBean<goods> pageBean;
			try {
				map = new HashMap<String, Object>();
				map.put("goods_code", goods_code);
				map.put("goods_name", goods_name);

				pageBean = new PageBean<goods>();

				int totalCount = gd.getTotalCount(goods_code, goods_name);
				// ������
				pageBean.setTotalCount(totalCount);

				// ÿҳ��Ŀ��
				String tempPageSize = req.getParameter("pageSize");
				int pageSize = 2;

				if (tempPageSize != null) {
					pageSize = Integer.parseInt(tempPageSize);
				}
				// ������ҳ��
				pageBean.setPageSize(pageSize);

				int currentPage = 1;
				String tempCurrentPage = req.getParameter("cutPage");
				if (tempCurrentPage != null) {
					currentPage = Integer.parseInt(tempCurrentPage);
				}
				// ��ֹ��Ϊ����
				if (currentPage < 1) {
					currentPage = 1;
				}
				// ��ֹ���
				if (currentPage > pageBean.getPages()) {
					currentPage = pageBean.getPages();
					if (pageBean.getPages() == 0) {
						currentPage = 1;
					}
				}
				// System.out.println("------------------------������"+totalCount);

				pageBean.setCurrentPage(currentPage);
				List<goods> li = gd.getAllGoods(goods_code, goods_name, pageBean);

				pageBean.setData(li);

				req.setAttribute("queryMap", map);
				req.setAttribute("pb", pageBean);
				req.getRequestDispatcher("goods.jsp").forward(req, resp);

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(path.equals("/goods/goodsSave.do")){
			String realPath=req.getServletContext().getRealPath("/");
			String dirPath=realPath+File.separator+"front"+File.separator+"upload";
			File f=new File(dirPath);
			if(!f.exists()){
        		
        		f.mkdirs();
        	}
        	//�����ļ��ϴ����������  ���·��  �ļ���С ����
        	MultipartRequest mreq=new MultipartRequest(req, dirPath,5*1024*1024,"utf-8");
        	//������ʹ��ԭ�����������õ��������������ʹ��mreq
			
			String type_id = mreq.getParameter("type_id");
			String supplier_id = mreq.getParameter("supplier_id");
			String goods_code = mreq.getParameter("goods_code");
			String goods_name = mreq.getParameter("goods_name");
			String goods_count = mreq.getParameter("goods_count");
			String goods_price = mreq.getParameter("goods_price");
			String goods_img = mreq.getParameter("goods_img");
			String goods_mes = mreq.getParameter("goods_mes");
			//����д�ļ��������
			String oldFileName=mreq.getFilesystemName("goods_img");
			
			//�õ��ļ���������
			Date d=new Date();
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        	String dateStr=sdf.format(d);
        	Random random=new Random();
        	int rn=random.nextInt(10000);
        	//�õ�Դ�ļ��ĺ�׺
        	String ext=oldFileName.substring(oldFileName.indexOf("."));
        	//�õ����ļ�����
        	String newFileName=dateStr+rn+ext;
        	//����һ�����ԭ�ļ����ļ�����
        	File oldFile=new File(dirPath+File.separator+oldFileName);
        	//�����ļ�����
        	oldFile.renameTo(new File(dirPath+File.separator+newFileName));
			
			String goodsImg="front"+File.separator+"upload"+File.separator+newFileName;
			goodsDao goodsDao=new goodsDao();
        	goods g=new goods(Integer.parseInt(type_id), Integer.parseInt(supplier_id), goods_code,goods_name,Integer.parseInt(goods_count),Float.parseFloat(goods_price), goodsImg,goods_mes);
        	goodsDao.addgoods(g);;
        	resp.sendRedirect("list.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
