package entitys;

public class customer {
	int cus_id;
	String cus_name;
	String cus_pwd;
	String cus_phone;
	String cus_add;
	String cus_status;
	
	
	public customer(int cus_id, String cus_pwd) {
		super();
		this.cus_id = cus_id;
		this.cus_pwd = cus_pwd;
	}
	public customer(String cus_name, String cus_pwd) {
		super();
		this.cus_name = cus_name;
		this.cus_pwd = cus_pwd;
	}
	public customer(String cus_name, String cus_pwd, String cus_phone, String cus_add, String cus_status) {
		super();
		this.cus_name = cus_name;
		this.cus_pwd = cus_pwd;
		this.cus_phone = cus_phone;
		this.cus_add = cus_add;
		this.cus_status = cus_status;
	}
	public customer(int cus_id, String cus_name, String cus_pwd, String cus_phone, String cus_add, String cus_status) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.cus_pwd = cus_pwd;
		this.cus_phone = cus_phone;
		this.cus_add = cus_add;
		this.cus_status = cus_status;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getCus_pwd() {
		return cus_pwd;
	}
	public void setCus_pwd(String cus_pwd) {
		this.cus_pwd = cus_pwd;
	}
	public String getCus_phone() {
		return cus_phone;
	}
	public void setCus_phone(String cus_phone) {
		this.cus_phone = cus_phone;
	}
	public String getCus_add() {
		return cus_add;
	}
	public void setCus_add(String cus_add) {
		this.cus_add = cus_add;
	}
	public String getCus_status() {
		return cus_status;
	}
	public void setCus_status(String cus_status) {
		this.cus_status = cus_status;
	}
	
	
}
