package entitys;

import java.util.Date;

public class outstock {
	int outStock_id;
	int goods_id;
	int employee_id;
	String outStockCode;
	Date outStockTime;
	String outStockStatus;
	String outStock_remark;
	int outStock_count;
	
	
	
	public outstock(int goods_id, int employee_id, String outStockCode, Date outStockTime, String outStockStatus,
			String outStock_remark, int outStock_count) {
		super();
		this.goods_id = goods_id;
		this.employee_id = employee_id;
		this.outStockCode = outStockCode;
		this.outStockTime = outStockTime;
		this.outStockStatus = outStockStatus;
		this.outStock_remark = outStock_remark;
		this.outStock_count = outStock_count;
	}
	public outstock(int outStock_id, int goods_id, int employee_id, String outStockCode, Date outStockTime,
			String outStockStatus, String outStock_remark, int outStock_count) {
		super();
		this.outStock_id = outStock_id;
		this.goods_id = goods_id;
		this.employee_id = employee_id;
		this.outStockCode = outStockCode;
		this.outStockTime = outStockTime;
		this.outStockStatus = outStockStatus;
		this.outStock_remark = outStock_remark;
		this.outStock_count = outStock_count;
	}
	public int getOutStock_id() {
		return outStock_id;
	}
	public void setOutStock_id(int outStock_id) {
		this.outStock_id = outStock_id;
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
	public String getOutStockCode() {
		return outStockCode;
	}
	public void setOutStockCode(String outStockCode) {
		this.outStockCode = outStockCode;
	}
	public Date getOutStockTime() {
		return outStockTime;
	}
	public void setOutStockTime(Date outStockTime) {
		this.outStockTime = outStockTime;
	}
	public String getOutStockStatus() {
		return outStockStatus;
	}
	public void setOutStockStatus(String outStockStatus) {
		this.outStockStatus = outStockStatus;
	}
	public String getOutStock_remark() {
		return outStock_remark;
	}
	public void setOutStock_remark(String outStock_remark) {
		this.outStock_remark = outStock_remark;
	}
	public int getOutStock_count() {
		return outStock_count;
	}
	public void setOutStock_count(int outStock_count) {
		this.outStock_count = outStock_count;
	}
	
	
}
