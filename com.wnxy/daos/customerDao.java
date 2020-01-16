package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entitys.customer;
import servlets.BaseDao;
import tools.ConnectionManager;
import tools.MD5TOOLS;

public class customerDao {

	public customer checkCount(String name, String psw) {
		Connection conn = null;
		customer cus = null;
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from customer where cus_name=? and cus_pwd=?");
			ps.setString(1, name);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int cus_id = rs.getInt("cus_id");
				String cus_name = rs.getString("cus_name");
				String cus_pwd = rs.getString("cus_pwd");
				String cus_phone = rs.getString("cus_phone");
				String cus_add = rs.getString("cus_add");
				String cus_status = rs.getString("cus_status");
				cus = new customer(cus_id, cus_name, cus_pwd, cus_phone,cus_add,cus_status);
				return cus;
			} else {
				return null;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	public boolean isExitPwd(customer cus) {
		Connection conn = null;

		conn = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from customer where cus_id=? and cus_pwd=?");
			ps.setInt(1, cus.getCus_id());
			ps.setString(2, cus.getCus_pwd());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		return false;
	}

	public void changePsw(int eid,String psw){
		Connection conn=null;
		conn=ConnectionManager.getConnection();
		try {
			String password=MD5TOOLS.getMD5String(psw);
			PreparedStatement ps=conn.prepareStatement("update customer set cus_pwd=? where cus_id=?");
			ps.setString(1, password);
			ps.setInt(2, eid);
			ps.executeUpdate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	public List<customer> getAllcustomers(){
		Connection conn=ConnectionManager.getConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select * from customer");
			
			ResultSet rs=ps.executeQuery();
			BaseDao<customer> basedao=new BaseDao<customer>();
			List<customer> li=basedao.getList(rs, customer.class);
			
			return li;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		return null;
		
	}
	
}
