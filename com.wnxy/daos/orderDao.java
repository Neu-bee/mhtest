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
			//关闭自动提交事务的模式
			conn.setAutoCommit(false);
			//第一步：给订单表中插入数据
		
			PreparedStatement ps=conn.prepareStatement("insert into orders(orders_id,cus_id,orders_price,order_status,orders_time,orders_remark)values(?,?,?,'未支付',now(),?) ");
			ps.setString(1,orderId);
			ps.setInt(2, order.getCus_id());
			ps.setFloat(3, order.getOrders_price());
			ps.setString(4, order.getOrders_remark());
			ps.executeUpdate();
			//给订单明细表插入数据
			String sql="insert into ordersdetail(orders_id,goods_id,ordersDetail_price,ordersDetail_count)"
						+" select "+orderId+",shoppings.goods_id,goods_price,shopping_count from shoppings" 
						+" LEFT JOIN goods on shoppings.goods_id=goods.goods_id where shopping_id in ("+sids+")";
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			
			//删除已经结算的购物车记录
			ps=conn.prepareStatement("delete from shoppings where shopping_id in("+sids+")");
			
			ps.executeUpdate();
			
			conn.commit();//提交事务
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
