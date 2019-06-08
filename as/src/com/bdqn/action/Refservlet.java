package com.bdqn.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.bdqn.bean.Att;
import com.bdqn.bean.User;
import com.bdqn.dao.UserDao;
import com.bdqn.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class Refservlet
 */
@WebServlet("/Refservlet")
public class Refservlet extends TimerTask  {

	private static boolean isRunning=false;
	
	private ServletContext context=null;
	
	UserDao dao=new UserDaoImpl();
	
	
	public Refservlet(){
		super();
	}
	
	public Refservlet(ServletContext context){
		this.context = context;
	}
	
	@Override
	public void run() {
		if(!isRunning){
			context.log("��ʼִ���Զ�����Ա�����ڱ�");
			
			List<User> userList = dao.queryUser();
			
			Date date = new Date();
			String day = new SimpleDateFormat("yyyyMM").format(date);
			int aid=Integer.valueOf(day);  //����dayid
			
			
			int title=0;
			
			for(int i=0;i<userList.size();i++){
				User user = userList.get(i);
				
				Att att = new Att();
				
				att = dao.queryAtt(user.getUid(),aid);
				if(att.getAid()==0){
					title = 1;
					dao.addAtt(user.getUid(), title);
				}else{
					dao.addAtt(user.getUid(), title);
				}
				
				
			}
		}
		
	}
       
    /**
     * @see TimerTask#TimerTask()
     */
   
}
