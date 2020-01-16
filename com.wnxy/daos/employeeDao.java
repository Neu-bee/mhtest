package daos;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import entitys.employee;
import tools.ConnectionManager;
import tools.MD5TOOLS;

public class employeeDao {

	public employee checkCount(String name, String psw) {
		Connection conn = null;
		employee emp = null;
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from employee where employee_name=? and employee_pwd=?");
			ps.setString(1, name);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String employee_name = rs.getString("employee_name");
				String employee_pwd = rs.getString("employee_pwd");
				String employee_role = rs.getString("employee_role");
				String employee_status = rs.getString("employee_status");
				emp = new employee(employee_id, employee_name, employee_pwd, employee_role, employee_status);
				return emp;
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

	public boolean isExitPwd(employee emp) {
		Connection conn = null;

		conn = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from employee where employee_id=? and employee_pwd=?");
			ps.setInt(1, emp.getEmployee_id());
			ps.setString(2, emp.getEmployee_pwd());

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
			PreparedStatement ps=conn.prepareStatement("update employee set employee_pwd=? where employee_id=?");
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
	
	
}
