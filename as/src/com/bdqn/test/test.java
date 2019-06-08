package com.bdqn.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bdqn.bean.Att;
import com.bdqn.bean.Dayatt;
import com.bdqn.bean.Leave;
import com.bdqn.bean.Tsleave;
import com.bdqn.bean.User;
import com.bdqn.dao.LimitDao;
import com.bdqn.dao.UserDao;
import com.bdqn.dao.impl.LimitDaoImpl;
import com.bdqn.dao.impl.UserDaoImpl;
import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager.Limit;

public class test {
	public static void main(String[] args) throws ParseException {
	//	int title=1;
		UserDao dao = new UserDaoImpl();
	//	List<User> userList = new ArrayList<>();
	//	userList =	dao.queryUser();
		Date date=new Date();
		String nowtime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//生成签到时间
		int i = 0;
		
		List<Leave> list = dao.queryLeave(161164272);
		
		System.out.println(list.get(0).getApprovalpos());
		
		//System.out.println(dao.queryWage(dao.queryPosWid(dao.queryStaffEp(161164272))).getBase());
	}
}