package com.bdqn.bean;

public class User {
	private int uid;
	private	String uname;
	private String utype;
	private	String upwd;
	private int uper;
	private String uidcard;
	private String add;
	private	String phone;
	private String email;
	
	private depuser depuser;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public int getUper() {
		return uper;
	}
	public void setUper(int uper) {
		this.uper = uper;
	}
	public String getUidcard() {
		return uidcard;
	}
	public void setUidcard(String uidcard) {
		this.uidcard = uidcard;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public depuser getDepuser() {
		return depuser;
	}
	public void setDepuser(depuser depuser) {
		this.depuser = depuser;
	}
	
}
