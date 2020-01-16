package entitys;

public class ordersdetail {
	
	int ordersDetail_id;
	String orders_id;
	int goods_id;
	float ordersDetail_price;
	int ordersDetail_count;
	
	public ordersdetail(String orders_id, int goods_id, float ordersDetail_price, int ordersDetail_count) {
		super();
		this.orders_id = orders_id;
		this.goods_id = goods_id;
		this.ordersDetail_price = ordersDetail_price;
		this.ordersDetail_count = ordersDetail_count;
	}
	public ordersdetail(int ordersDetail_id, String orders_id, int goods_id, float ordersDetail_price,
			int ordersDetail_count) {
		super();
		this.ordersDetail_id = ordersDetail_id;
		this.orders_id = orders_id;
		this.goods_id = goods_id;
		this.ordersDetail_price = ordersDetail_price;
		this.ordersDetail_count = ordersDetail_count;
	}
	public int getOrdersDetail_id() {
		return ordersDetail_id;
	}
	public void setOrdersDetail_id(int ordersDetail_id) {
		this.ordersDetail_id = ordersDetail_id;
	}
	public String getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(String orders_id) {
		this.orders_id = orders_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public float getOrdersDetail_price() {
		return ordersDetail_price;
	}
	public void setOrdersDetail_price(float ordersDetail_price) {
		this.ordersDetail_price = ordersDetail_price;
	}
	public int getOrdersDetail_count() {
		return ordersDetail_count;
	}
	public void setOrdersDetail_count(int ordersDetail_count) {
		this.ordersDetail_count = ordersDetail_count;
	}
	
	
	
}
