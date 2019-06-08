package com.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bdqn.dao.LimitDao;
import com.bdqn.dao.UserDao;
import com.bdqn.util.Todb;


public class LimitDaoImpl implements LimitDao {
	Todb t = new Todb();
	Connection con = t.getConnection();
	UserDao dao=new  UserDaoImpl();
	@Override
	public boolean LimitUidcard(String uidcard) {
		//限制第一次登陆时的身份证检查，如身份证信息已存在则返回错误信息；
		String sql="select * from user where uidcard=?";
		boolean in= false;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uidcard);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				if(rs.getString(1) != null){
					in= true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
	@Override
	public boolean LimitPhone(String phone) {
		//限制第一次登陆时的手机号检查，如手机信息已存在则返回错误信息；
		String sql="select * from user where phone=?";
		boolean in= false;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, phone);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				if(rs.getString(1) != null){
					in= true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
	
	
}
