package cn.edu.zucc.takeout.model;

public class BeanManager {
	public static BeanManager currentLoginUser=null;
	private int manager_id;
	private String manager_name;
	private String manager_password;
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public static BeanManager getCurrentLoginUser() {
		return currentLoginUser;
	}
	public static void setCurrentLoginUser(BeanManager currentLoginUser) {
		BeanManager.currentLoginUser = currentLoginUser;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_password() {
		return manager_password;
	}
	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}
}
