package daos;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitys.instock;
import servlets.BaseClassDao;
import servlets.BaseDao;
import entitys.goods;
import tools.ConnectionManager;

public class instockDao {

	public void addinstock(instock in) {
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement ins = conn.prepareStatement(
					"insert into instock(goods_id,employee_id,inStock_code,inStock_time,inStock_status,inStock_remark,inStock_count) "
					+ "values(?,?,?,now(),'未确认',?,?)");
			
			//ins.setInt(1, in.getinStock_id());
			ins.setInt(1, in.getGoods_id());
			ins.setInt(2, in.getEmployee_id());
			ins.setString(3, in.getInStock_code());
			//Date inStock_time;
			//ins.setString(1, in.getInStock_status());
			ins.setString(4, in.getInStock_remark());
			ins.setInt(5, in.getInStock_count());
			ins.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

	}

//	public void outinstock(instock in) {
//		Connection conn = null;
//		conn = ConnectionManager.getConnection();
//		goodsDao pd = new goodsDao();
//		goods p1 = pd.getgoodsById(in.getgoods_id());
//		try {
//			if (p1.getgoods_count() - in.getgoods_count() > 0) {
//				conn = ConnectionManager.getConnection();
//				PreparedStatement ins1 = conn.prepareStatement(
//						"update instock set goods_date=now(),inStock_status='已确认出库' where inStock_id=?");
//
//				ins1.setInt(1, in.getinStock_id());
//
//				ins1.executeUpdate();
//
//				PreparedStatement ins2 = conn
//						.prepareStatement("update goods set goods_count=? where goods_id=?");
//				ins2.setInt(1, p1.getgoods_count() - in.getgoods_count());
//				ins2.setInt(2, p1.getgoods_id());
//				ins2.executeUpdate();
//			} else {
//				System.out.println("失败");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			ConnectionManager.closeConnection(conn);
//		}
//	}

	public void doinstock(instock in) {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		
		goodsDao pd = new goodsDao();
		goods p1 = pd.getGoodsById(in.getGoods_id());
		try {//修改状态
			conn = ConnectionManager.getConnection();
			PreparedStatement ins1 = conn.prepareStatement(
					"update instock set inStock_time=now(),inStock_status='已确认' where inStock_id=?");
			ins1.setInt(1, in.getInStock_id());
			ins1.executeUpdate();
			//修改货物数量
			PreparedStatement ins2 = conn.prepareStatement("update goods set goods_count=? where goods_id=?");
			ins2.setInt(1, p1.getGoods_count() + in.getInStock_count());
			ins2.setInt(2, p1.getGoods_id());
			ins2.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	
	public void updateinstock(instock in) {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement ins1 = conn.prepareStatement(
					"update instock set goods_id=?,employee_id=?,inStock_code=?,"
					+ "inStock_remark=?,inStock_count=? where inStock_id=?");

			ins1.setInt(1, in.getGoods_id());
			ins1.setInt(2, in.getEmployee_id());
			ins1.setString(3, in.getInStock_code());
			ins1.setString(4, in.getInStock_remark());
			ins1.setInt(5, in.getInStock_count());
			ins1.setInt(6, in.getInStock_id());
			
			ins1.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	
	public void deleteinstock(int inId) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from instock where inStock_id=?");
			ps.setInt(1, inId);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	public List<instock> getAllinstock(String inStock_code) {
		//List<instock> li = new ArrayList<instock>();
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			String sql="select * from instock where 1=1";
			if(inStock_code !=null && !inStock_code.equals("")){
				sql=sql+" and inStock_code like ? ";
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			int count=0;
			if(inStock_code !=null && !inStock_code.equals("")){
				count++;
				ps.setString(count, "%"+inStock_code+"%");
			}
			
			ResultSet rs = ps.executeQuery();
			
			BaseDao<instock> baseDao=new BaseDao<instock>();
			List<instock> li=baseDao.getList(rs,instock.class);
			return li;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	public instock getinstockById(int param) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		instock in = null;
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from instock where inStock_id=?");
			ps.setInt(1, param);
			ResultSet rs = ps.executeQuery();

//			if (rs.next()) {
//				int inStock_id=rs.getInt("inStock_id");
//				int goods_id=rs.getInt("goods_id");
//				int employee_id=rs.getInt("employee_id");
//				String inStock_code=rs.getString("inStock_code");
//				Date inStock_time=rs.getDate("inStock_time");
//				String inStock_status=rs.getString("inStock_status");
//				String inStock_remark=rs.getString("inStock_remark");
//				int inStock_count=rs.getInt("inStock_count");
//
//				in = new instock(inStock_id, goods_id, user_Id, goods_count, goods_date, inStock_status);
//
//			}
			
			BaseClassDao bcd=new BaseClassDao();
			in=(instock) bcd.getObj(rs,instock.class);
			return in;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

}
