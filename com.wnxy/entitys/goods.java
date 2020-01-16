package entitys;

public class goods {
	int goods_id;
	int type_id;
	int supplier_id;
	String goods_code;
	String goods_name;
	int goods_count;
	float goods_price;
	String goods_img;
	String goods_mes;
	
	public goods() {
		super();
	}
	
	public goods(int type_id, int supplier_id, String goods_code, String goods_name, int goods_count, float goods_price,
			String goods_img, String goods_mes) {
		super();
		this.type_id = type_id;
		this.supplier_id = supplier_id;
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.goods_count = goods_count;
		this.goods_price = goods_price;
		this.goods_img = goods_img;
		this.goods_mes = goods_mes;
	}

	public goods(int goods_id, int type_id, int supplier_id, String goods_code, String goods_name, int goods_count,
			float goods_price, String goods_img, String goods_mes) {
		super();
		this.goods_id = goods_id;
		this.type_id = type_id;
		this.supplier_id = supplier_id;
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.goods_count = goods_count;
		this.goods_price = goods_price;
		this.goods_img = goods_img;
		this.goods_mes = goods_mes;
	}
	

	public goods(String goods_name, int goods_count, float goods_price, String goods_img, String goods_mes) {
		super();
		this.goods_name = goods_name;
		this.goods_count = goods_count;
		this.goods_price = goods_price;
		this.goods_img = goods_img;
		this.goods_mes = goods_mes;
	}

	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}
	public float getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public String getGoods_mes() {
		return goods_mes;
	}
	public void setGoods_mes(String goods_mes) {
		this.goods_mes = goods_mes;
	}
	@Override
	public String toString() {
		return "goods [goods_id=" + goods_id + ", type_id=" + type_id + ", supplier_id=" + supplier_id + ", goods_code="
				+ goods_code + ", goods_name=" + goods_name + ", goods_count=" + goods_count + ", goods_price="
				+ goods_price + ", goods_img=" + goods_img + ", goods_mes=" + goods_mes + "]";
	}
	
	
}
