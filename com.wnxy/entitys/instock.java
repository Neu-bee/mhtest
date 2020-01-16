package entitys;

import java.util.Date;

public class instock {

	int inStock_id;
	int goods_id;
	int employee_id;
	String inStock_code;
	Date inStock_time;
	String inStock_status;
	String inStock_remark;
	int inStock_count;
	
	
	public instock() {
		super();
	}
	public instock(int goods_id, int employee_id, String inStock_code, Date inStock_time, String inStock_status,
			String inStock_remark, int inStock_count) {
		super();
		this.goods_id = goods_id;
		this.employee_id = employee_id;
		this.inStock_code = inStock_code;
		this.inStock_time = inStock_time;
		this.inStock_status = inStock_status;
		this.inStock_remark = inStock_remark;
		this.inStock_count = inStock_count;
	}
	public instock(int inStock_id, int goods_id, int employee_id, String inStock_code, Date inStock_time,
			String inStock_status, String inStock_remark, int inStock_count) {
		super();
		this.inStock_id = inStock_id;
		this.goods_id = goods_id;
		this.employee_id = employee_id;
		this.inStock_code = inStock_code;
		this.inStock_time = inStock_time;
		this.inStock_status = inStock_status;
		this.inStock_remark = inStock_remark;
		this.inStock_count = inStock_count;
	}
	public int getInStock_id() {
		return inStock_id;
	}
	public void setInStock_id(int inStock_id) {
		this.inStock_id = inStock_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getInStock_code() {
		return inStock_code;
	}
	public void setInStock_code(String inStock_code) {
		this.inStock_code = inStock_code;
	}
	public java.util.Date getInStock_time() {
		return inStock_time;
	}
	public void setInStock_time(Date inStock_time) {
		this.inStock_time = inStock_time;
	}
	public String getInStock_status() {
		return inStock_status;
	}
	public void setInStock_status(String inStock_status) {
		this.inStock_status = inStock_status;
	}
	public String getInStock_remark() {
		return inStock_remark;
	}
	public void setInStock_remark(String inStock_remark) {
		this.inStock_remark = inStock_remark;
	}
	public int getInStock_count() {
		return inStock_count;
	}
	public void setInStock_count(int inStock_count) {
		this.inStock_count = inStock_count;
	}
	
	
}
