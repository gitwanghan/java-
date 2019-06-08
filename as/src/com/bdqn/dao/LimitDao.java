package com.bdqn.dao;

public interface LimitDao {
	public boolean LimitUidcard(String uidcard);
	//1.限制第一次登陆时的身份证检查，如身份证信息已存在则返回错误信息；
	public boolean LimitPhone(String phone);
	//2.限制第一次登陆时的手机号检查，如手机信息已存在则返回错误信息；
}
