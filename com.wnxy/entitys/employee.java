package entitys;

public class employee {
	int employee_id;
	String employee_name;
	String employee_pwd;
	String employee_role;
	String employee_status;
	
	public employee(String employee_name, String employee_pwd, String employee_role, String employee_status) {
		super();
		this.employee_name = employee_name;
		this.employee_pwd = employee_pwd;
		this.employee_role = employee_role;
		this.employee_status = employee_status;
	}
	public employee(int employee_id, String employee_name, String employee_pwd, String employee_role,
			String employee_status) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_pwd = employee_pwd;
		this.employee_role = employee_role;
		this.employee_status = employee_status;
	}
	
	public employee(int employee_id, String employee_pwd) {
		super();
		this.employee_id = employee_id;
		this.employee_pwd = employee_pwd;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_pwd() {
		return employee_pwd;
	}
	public void setEmployee_pwd(String employee_pwd) {
		this.employee_pwd = employee_pwd;
	}
	public String getEmployee_role() {
		return employee_role;
	}
	public void setEmployee_role(String employee_role) {
		this.employee_role = employee_role;
	}
	public String getEmployee_status() {
		return employee_status;
	}
	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}
	@Override
	public String toString() {
		return "employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_pwd="
				+ employee_pwd + ", employee_role=" + employee_role + ", employee_status=" + employee_status + "]";
	}
	
} 
