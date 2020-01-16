package entitys;

public class types {

	int type_id;
	String type_code;
	String type_name;
	public types(int type_id, String type_code, String type_name) {
		super();
		this.type_id = type_id;
		this.type_code = type_code;
		this.type_name = type_name;
	}
	public types(String type_code, String type_name) {
		super();
		this.type_code = type_code;
		this.type_name = type_name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_code() {
		return type_code;
	}
	public void setType_code(String type_code) {
		this.type_code = type_code;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	
}
