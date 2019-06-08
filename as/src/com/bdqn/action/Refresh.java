package com.bdqn.action;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

import com.sun.glass.ui.Timer;

/**
 * Application Lifecycle Listener implementation class Refresh
 *
 */
@WebListener
public class Refresh implements ServletContextListener {
	
	
	
	private java.util.Timer timer = null;
	
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		/*
		 * ����һ����ʱ��
		 */
		timer =new java.util.Timer(true);
		arg0.getServletContext().log("��ʱ��������");
		/*
		 * ��ʱ����ָ����ʱ��ʱ��ִ���Զ���ӻ��޸�Att��Ĳ���
		 */
		
		//����ִ��ʱ��
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(calendar.MONTH);
		int day = calendar.get(calendar.DAY_OF_MONTH);
		
		//����ÿ���23��00��00ִ��
		
		calendar.set(year, month,day,23,00,00);
		Date date = calendar.getTime();
		
		int period =  24*60*60*1000;
		//ÿ���dateʱ��ִ��task ÿ��persion ʱ���ظ�ִ��
		timer.schedule(new Refservlet(arg0.getServletContext()), date, period);
		
		arg0.getServletContext().log("�Ѿ����������ȱ�");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		timer.cancel();
		arg0.getServletContext().log("��ʱ��������");
		
	}

  
	
}
