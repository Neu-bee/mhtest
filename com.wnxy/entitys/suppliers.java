package entitys;

public class suppliers {
	int supplier_id;
	String supplier_code;
	String supplier_name;
	String supplier_phone;
	String supplier_remark;
	
	
	public suppliers(String supplier_code, String supplier_name, String supplier_phone, String supplier_remark) {
		super();
		this.supplier_code = supplier_code;
		this.supplier_name = supplier_name;
		this.supplier_phone = supplier_phone;
		this.supplier_remark = supplier_remark;
	}
	public suppliers(int supplier_id, String supplier_code, String supplier_name, String supplier_phone,
			String supplier_remark) {
		super();
		this.supplier_id = supplier_id;
		this.supplier_code = supplier_code;
		this.supplier_name = supplier_name;
		this.supplier_phone = supplier_phone;
		this.supplier_remark = supplier_remark;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_code() {
		return supplier_code;
	}
	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_phone() {
		return supplier_phone;
	}
	public void setSupplier_phone(String supplier_phone) {
		this.supplier_phone = supplier_phone;
	}
	public String getSupplier_remark() {
		return supplier_remark;
	}
	public void setSupplier_remark(String supplier_remark) {
		this.supplier_remark = supplier_remark;
	}
	
	
}
