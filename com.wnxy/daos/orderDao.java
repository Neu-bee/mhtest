package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import entitys.orders;
import tools.ConnectionManager;

public class orderDao {
	
	public String addOrder(orders order, String sids) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		String orderId=generateOrderId();
		try {
			conn=ConnectionManager.getConnection();
			//�ر��Զ��ύ�����ģʽ
			conn.setAutoCommit(false);
			//��һ�������������в�������
		
			PreparedStatement ps=conn.prepareStatement("insert into orders(orders_id,cus_id,orders_price,order_status,orders_time,orders_remark)values(?,?,?,'δ֧��',now(),?) ");
			ps.setString(1,orderId);
			ps.setInt(2, order.getCus_id());
			ps.setFloat(3, order.getOrders_price());
			ps.setString(4, order.getOrders_remark());
			ps.executeUpdate();
			//��������ϸ���������
			String sql="insert into ordersdetail(orders_id,goods_id,ordersDetail_price,ordersDetail_count)"
						+" select "+orderId+",shoppings.goods_id,goods_price,shopping_count from shoppings" 
						+" LEFT JOIN goods on shoppings.goods_id=goods.goods_id where shopping_id in ("+sids+")";
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			
			//ɾ���Ѿ�����Ĺ��ﳵ��¼
			ps=conn.prepareStatement("delete from shoppings where shopping_id in("+sids+")");
			
			ps.executeUpdate();
			
			conn.commit();//�ύ����
			return orderId;
			
		} 
		finally{
			
			ConnectionManager.closeConnection(conn);
		}
		
	}

	
	
	
	private String generateOrderId() {
		// TODO Auto-generated method stub
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		String orderIdTime=sdf.format(now);
		Random random=new Random();
		int randomNumer=random.nextInt(100000);
		return orderIdTime+randomNumer;
	}
}
