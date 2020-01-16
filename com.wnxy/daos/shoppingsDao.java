package daos;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitys.goods;
import entitys.shoppings;
import tools.ConnectionManager;

public class shoppingsDao {

	public void addShoppings(shoppings s) throws SQLException {
		boolean tag = isExitShopping(s);
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection();
			String sql = "";
			// 如果进行修改操作，在原有数量上加1，如果没有，进行添加操作
			if (tag) {
				sql = "update shoppings  set shopping_count=shopping_count+1 where goods_id=? and cus_id=?";
			} else {
				sql = "insert into shoppings(goods_id,cus_id,shopping_count,shopping_time) values(?,?,1,now())";
			}
			PreparedStatement ins=conn.prepareStatement(sql);
			ins.setInt(1, s.getGoods_id());
			ins.setInt(2, s.getCus_id());
			ins.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	private boolean isExitShopping(shoppings shopping) throws SQLException {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from shoppings where goods_id=? and cus_id=? ");

		ps.setInt(1, shopping.getGoods_id());
		ps.setInt(2, shopping.getCus_id());

		// 发送查询语句
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	// 按ID定位
	public List<shoppings> getShoppingsByCusId(int cusId) throws InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"select shopping_id,shoppings.goods_id,shopping_count,shopping_time,"
					+ "cus_id,goods_name,goods_price,goods_img,goods_mes,goods_count from shoppings "
					+ "LEFT JOIN goods on shoppings.goods_id=goods.goods_id where cus_id=?");
			 List<shoppings> lis=new ArrayList<shoppings>();;
			ps.setInt(1,cusId);
			ResultSet rs=ps.executeQuery();
			
			 while(rs.next()){
			 int shoppings_id = rs.getInt("shopping_id");
			 int goods_id = rs.getInt("goods_id");
			 int shopping_count= rs.getInt("shopping_count");
			 Date shopping_time=rs.getDate("shopping_time");
			 int cus_id= rs.getInt("cus_id");
			 String goods_name= rs.getString("goods_name");
			 float goods_price= rs.getFloat("goods_price");
			 String goods_img= rs.getString("goods_img");
			 String goods_mes= rs.getString("goods_mes");
			 int goods_count= rs.getInt("goods_count");
			 
			 goods g=new goods(goods_name,goods_count,  goods_price, goods_img,goods_mes);
			 
			 shoppings shopping=new shoppings(shoppings_id, goods_id, cus_id, shopping_count, shopping_time, g);
			 
			 lis.add(shopping);
			 }
			return lis;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	
	public void updateShoppingsCount(int shopping_id,int shopping_count) throws SQLException {
		Connection conn = null;
		try {
			conn=ConnectionManager.getConnection();
			PreparedStatement ps=conn.prepareStatement("update shoppings set shopping_count=? where shopping_id=?");
			
			ps.setInt(1, shopping_count);
			ps.setInt(2, shopping_id);
			ps.executeUpdate();
		} 
		finally{
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	public List<shoppings> getSubShoppings(String shoppingIds) throws SQLException {
		Connection conn=null;
		
		try {
		conn=ConnectionManager.getConnection();
		String str="("+shoppingIds+")";
		PreparedStatement ps=conn.prepareStatement(
				"select shopping_id,shoppings.goods_id,shopping_count,shopping_time,"
				+ "cus_id,goods_name,goods_price,goods_img,goods_mes,goods_count from shoppings "
				+ "LEFT JOIN goods on shoppings.goods_id=goods.goods_id where shopping_id in "+str );
        List<shoppings> shList=new ArrayList<shoppings>();
		
		ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 int shoppings_id = rs.getInt("shopping_id");
			 int goods_id = rs.getInt("goods_id");
			 int shopping_count= rs.getInt("shopping_count");
			 Date shopping_time=rs.getDate("shopping_time");
			 int cus_id= rs.getInt("cus_id");
			 String goods_name= rs.getString("goods_name");
			 float goods_price= rs.getFloat("goods_price");
			 String goods_img= rs.getString("goods_img");
			 String goods_mes= rs.getString("goods_mes");
			 int goods_count= rs.getInt("goods_count");
			 
			 goods g=new goods(goods_name,goods_count,  goods_price, goods_img,goods_mes);
			 
			 shoppings shopping=new shoppings(shoppings_id, goods_id, cus_id, shopping_count, shopping_time, g);
			 
			 shList.add(shopping);
			 }
			return shList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	
}
