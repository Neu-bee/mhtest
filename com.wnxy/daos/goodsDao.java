package daos;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entitys.goods;
import entitys.instock;
import servlets.BaseClassDao;
import servlets.BaseDao;
import servlets.PageBean;
import tools.ConnectionManager;

public class goodsDao {
	//显示所有商品
	public List<goods> getAllGoods(String goods_code, String goods_name,PageBean<goods> pageBean) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		List<goods> li = new ArrayList<goods>();
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			String sql = "select * from goods where 1=1 ";
			if (goods_code != null && !goods_code.equals("") ) {
				sql = sql + "and goods_code like ? ";
			}
			if (goods_name != null && !goods_name.equals("")) {
				sql = sql + "and goods_name like ? ";
			}
			sql=sql+" limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			int count = 0;
			if (goods_code != null && !goods_code.equals("") ) {
				count++;
				ps.setString(count, "%" + goods_code + "%");
			}
			if (goods_name != null && !goods_name.equals("")) {
				count++;
				ps.setString(count, "%" + goods_name + "%");
			}
			ps.setInt(count+1, (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
			ps.setInt(count+2, pageBean.getPageSize());
			ResultSet rs = ps.executeQuery();
			
//			BaseDao<goods> baseDao=new BaseDao<goods>();
//			List<goods> li=baseDao.getList(rs,goods.class);
			
			while (rs.next()) {
				int ggoods_id = rs.getInt("goods_id");
				int gtype_id= rs.getInt("type_id");
				int gsupplier_id= rs.getInt("supplier_id");
				String ggoods_code= rs.getString("goods_code");
				String ggoods_name= rs.getString("goods_name");
				int ggoods_count= rs.getInt("goods_count");
				float ggoods_price= rs.getFloat("goods_price");
				String ggoods_img= rs.getString("goods_img");
				String ggoods_mes=rs.getString("goods_mes");

				goods g = new goods(ggoods_id, gtype_id, gsupplier_id,ggoods_code,ggoods_name,ggoods_count,ggoods_price,ggoods_img,ggoods_mes);
				li.add(g);
			}
			return li;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	//按ID修改
	public void updateGoodsById(goods p) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"update goods set type_id=?,supplier_id=?,"
					+ "goods_code=?, goods_name=?,goods_count=?, goods_price=?," 
					+"goods_img=?, goods_mes=? where goods_id=?");
			ps.setInt(1,p.getType_id());
			ps.setInt(2,p.getSupplier_id());
			ps.setString(3,p.getGoods_code());
			ps.setString(4,p.getGoods_name());
			ps.setInt(5,p.getGoods_count());
			ps.setFloat(6,p.getGoods_price());
			ps.setString(7,p.getGoods_img());
			ps.setString(8,p.getGoods_mes());
			ps.setInt(9,p.getGoods_id());
			
			ResultSet rs = ps.executeQuery();
			
			BaseClassDao<goods> BaseClassDao=new BaseClassDao<goods>();
			p=BaseClassDao.getObj(rs,goods.class);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	public void addgoods(goods p) {
		Connection conn=null;
		
		try {
			conn=ConnectionManager.getConnection();
			PreparedStatement ps= conn.prepareStatement(
					"insert into goods(type_id,supplier_id ,"
					+ "goods_code, goods_name,goods_count, goods_price ," 
					+"goods_img, goods_mes) values(?,?,?,?,?,?,?,?)");

			ps.setInt(1,p.getType_id());
			ps.setInt(2,p.getSupplier_id());
			ps.setString(3,p.getGoods_code());
			ps.setString(4,p.getGoods_name());
			ps.setInt(5,p.getGoods_count());
			ps.setFloat(6,p.getGoods_price());
			ps.setString(7,p.getGoods_img());
			ps.setString(8,p.getGoods_mes());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		
	}
	
	
	public int getTotalCount(String goods_code, String goods_name) throws SQLException {
		Connection conn=null;
		
		try {
			conn=ConnectionManager.getConnection();
			String sql="select count(goods_id) as 'gc' from goods where 1=1 ";
			if(goods_code!=null&&!goods_code.equals("")){
				sql=sql+" and goods_code like ?";
			}
			if(goods_name!=null&&!goods_name.equals("")){
				sql=sql+" and goods_name like ?";
			}
			
			PreparedStatement ps=conn.prepareStatement(sql);
			int count =0;
			if(goods_code!=null&&!goods_code.equals("")){
				count++;
				ps.setString(count,"%"+goods_code+"%" );
			}
			if(goods_name!=null&&!goods_name.equals("")){
				count++;
				ps.setString(count,"%"+goods_name+"%" );
			}
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				return rs.getInt("gc");
			}
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection(conn);
		}
		return 0;
		
	}
	
	
	//按ID查找
	
	public goods getGoodsById(int id) {
		goods g = null;
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"select * from goods where goods_id=?");
			
			ResultSet rs = ps.executeQuery();
			
			BaseClassDao<goods> BaseClassDao=new BaseClassDao<goods>();
			g=BaseClassDao.getObj(rs, goods.class);
			
			if (rs.next()) {
				int ggoods_id = rs.getInt("goods_id");
				int gtype_id= rs.getInt("type_id");
				int gsupplier_id= rs.getInt("supplier_id");
				String ggoods_code= rs.getString("goods_code");
				String ggoods_name= rs.getString("goods_name");
				int ggoods_count= rs.getInt("goods_count");
				float ggoods_price= rs.getFloat("goods_price");
				String ggoods_img= rs.getString("goods_img");
				String ggoods_mes=rs.getString("goods_mes");

				g = new goods(ggoods_id, gtype_id, gsupplier_id,ggoods_code,ggoods_name,ggoods_count,ggoods_price,ggoods_img,ggoods_mes);
			}
			return g;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	
	
	
	
	
}
