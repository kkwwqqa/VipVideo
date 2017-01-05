package com.video.Bean;

public class Admin {
	
	private String adminname ;
	private String adminpwd ;
	
	public Admin(){
		//由于后台账号密码只有2个字段，并且使用次数不是很多，就封装起来
		this.adminname= "admin";//自己定义后台账号
		this.adminpwd= "admin";//自己定义后台密码
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpwd() {
		return adminpwd;
	}
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	

}
