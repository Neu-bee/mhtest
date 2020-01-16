package entitys;

import java.util.Date;

public class shoppings {
	int shopping_id;
	int goods_id;
	int cus_id;
	int shopping_count;
	Date shopping_time;
	goods goods;
	
	public shoppings(int goods_id, int cus_id) {
		super();
		this.goods_id = goods_id;
		this.cus_id = cus_id;
	}
	public shoppings(int shopping_id, int goods_id, int cus_id, int shopping_count, Date shopping_time,
			entitys.goods goods) {
		super();
		this.shopping_id = shopping_id;
		this.goods_id = goods_id;
		this.cus_id = cus_id;
		this.shopping_count = shopping_count;
		this.shopping_time = shopping_time;
		this.goods = goods;
	}
	public shoppings(int goods_id, int cus_id, int shopping_count, Date shopping_time, entitys.goods goods) {
		super();
		this.goods_id = goods_id;
		this.cus_id = cus_id;
		this.shopping_count = shopping_count;
		this.shopping_time = shopping_time;
		this.goods = goods;
	}
	public int getShopping_id() {
		return shopping_id;
	}
	public void setShopping_id(int shopping_id) {
		this.shopping_id = shopping_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public int getShopping_count() {
		return shopping_count;
	}
	public void setShopping_count(int shopping_count) {
		this.shopping_count = shopping_count;
	}
	public Date getShopping_time() {
		return shopping_time;
	}
	public void setShopping_time(Date shopping_time) {
		this.shopping_time = shopping_time;
	}
	public goods getGoods() {
		return goods;
	}
	public void setGoods(goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "shoppings [shopping_id=" + shopping_id + ", goods_id=" + goods_id + ", cus_id=" + cus_id
				+ ", shopping_count=" + shopping_count + ", shopping_time=" + shopping_time + ", goods=" + goods + "]";
	}
	
	
}
