package com.bdqn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.bean.Att;
import com.bdqn.bean.Leave;
import com.bdqn.bean.Staff;
import com.bdqn.bean.Trip;
import com.bdqn.bean.Tsleave;
import com.bdqn.bean.Tstrip;
import com.bdqn.bean.User;
import com.bdqn.bean.UserBase;
import com.bdqn.bean.WagePlan;
import com.bdqn.bean.depuser;
import com.bdqn.dao.LimitDao;
import com.bdqn.dao.UserDao;
import com.bdqn.dao.impl.LimitDaoImpl;
import com.bdqn.dao.impl.UserDaoImpl;

import jdk.nashorn.api.scripting.JSObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class userservlet
 */
@WebServlet("/userservlet")
public class userservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		doGet(request, response);
		request.setCharacterEncoding("utf-8");//���������ַ���
		response.setCharacterEncoding("utf-8");//������Ӧ�ַ���
		UserDao dao=new UserDaoImpl();
		String xinxi=request.getParameter("xinxi");

		if(xinxi.equals("1")){
			//�û���¼
			int uid=Integer.valueOf(request.getParameter("uid"));
			String upwd=request.getParameter("upwd");
			User user=dao.query(uid);
			if(user.getUpwd().equals(upwd)){
				session.setAttribute("uid", uid);
				session.setAttribute("user", user);
				request.getRequestDispatcher("hello.jsp").forward(request,response);
			}else{
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
		}else if(xinxi.equals("2")){
			String uidcard= request.getParameter("uidcard");
			String phone=request.getParameter("phone");
			LimitDao limitDao = new LimitDaoImpl();
			if(limitDao.LimitUidcard(uidcard)!=true){
				if(limitDao.LimitPhone(phone)!=true){
					//�û���һ��ע��
					User user = new User();
					user.setUname(request.getParameter("uname"));
					user.setUtype(request.getParameter("utupe"));
					user.setUpwd(request.getParameter("upwd"));
					user.setUper(1);
					user.setUidcard(uidcard);
					user.setAdd(request.getParameter("add"));
					user.setPhone(phone);
					user.setEmail(request.getParameter("email"));
					int i=dao.addF(user);
					if(i==1){
						session.setAttribute("uidcard", user.getUidcard());
						request.getRequestDispatcher("registered.jsp").forward(request, response);
					}else{
						session.setAttribute("error", "���ʧ��");
						request.getRequestDispatcher("Firstregistered.jsp").forward(request, response);
						//���ش�����Ϣerror 0.���ʧ��
					}
				}else{
					session.setAttribute("error", "�ֻ������Ѵ���");
					request.getRequestDispatcher("Firstregistered.jsp").forward(request, response);
					//���ش�����Ϣerror 2.�ֻ������Ѵ���
				}
			}else{
				session.setAttribute("error", "���֤���Ѵ���");
				request.getRequestDispatcher("Firstregistered.jsp").forward(request, response);
				//���ش�����Ϣerror 1.���֤���Ѵ���
			}
		}else if(xinxi.equals("3")){
			//�û��ڶ���ע��

			String uidcard=(String) session.getAttribute("uidcard");
			User user=dao.queryUid(uidcard);
			UserBase userBase=new UserBase();

			//��ȡ��������
			String YYYY=request.getParameter("YYYY");
			String MM = request.getParameter("MM");
			String DD = request.getParameter("DD");
			String ubornDate = YYYY+"-"+MM+"-"+DD;

			//��ȡ��ǰʱ��Σ�����Ϊ���벿��ʱ��
			Date date = new Date();
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

			//��ȡӦƸ����
			String dep= request.getParameter("dep");

			//��ȡӦƸְλ
			String pos=dep+ request.getParameter("pos");

			userBase.setUid(user.getUid());
			userBase.setUname(user.getUname());
			userBase.setUgen(request.getParameter("ugen"));
			userBase.setUborndate(ubornDate);
			userBase.setUnplace(request.getParameter("unplace"));
			userBase.setUnational(request.getParameter("unational"));
			userBase.setUidcard(user.getUidcard());
			userBase.setUpl(request.getParameter("upl"));
			userBase.setDid(dao.queryDid(dep));
			userBase.setSdate(nowTime);
			userBase.setPid(dao.queryPid(pos));
			userBase.setTitle(request.getParameter("title"));
			userBase.setStartdate(nowTime);
			userBase.setUnito(request.getParameter("unito"));
			userBase.setUnitt(request.getParameter("unitt"));
			userBase.setUnitp(request.getParameter("unitp"));
			userBase.setGschool(request.getParameter("gschool"));
			userBase.setGdate("2018-01-20");//���
			userBase.setEdu(request.getParameter("edu"));
			userBase.setPro(request.getParameter("pro"));
			userBase.setLan(request.getParameter("lan"));
			userBase.setAdd(user.getAdd());
			userBase.setPhone(user.getPhone());
			userBase.setEmail(user.getEmail());
			userBase.setState("�ڸ�");

			//ע������ɣ��Զ�����Ա��¼����Ϣ�����Ա����Ϣ��ļ�¼
			Staff staff = new Staff();
			staff.setUid(userBase.getUid());
			staff.setUname(userBase.getUname());
			staff.setSdate(nowTime);
			staff.setSedate("2020-12-31");
			staff.setStype("ǩԼע��");
			staff.setEd(dep);
			staff.setEp(pos);
			staff.setEm("��ȡ������ְ��ID" + dao.queryPid(pos));
			staff.setStext("");
			dao.addStaff(staff);

			//���Ʋ���Ա����
			depuser depuser = new depuser();
			depuser.setUid(userBase.getUid());
			depuser.setUname(userBase.getUname());
			depuser.setDid(dao.queryDid(dep));
			depuser.setDname(dep);
			depuser.setPid(dao.queryPid(pos));
			depuser.setPname(pos);
			dao.addDepUser(depuser);

			int i = 0;
			i=dao.add(userBase);
			if(i==1){
				session.setAttribute("user", user);
				session.setAttribute("uname", user.getUname());
				session.setAttribute("uid", user.getUid());
				request.getRequestDispatcher("hello.jsp").forward(request, response);
			}
		}else if(xinxi.equals("sign")){ //��ǰ�˵��ǩ��ʱ���ύǩ����Ϣ
			//�ж�ǩ����Ϣ
			int uid=(int) session.getAttribute("uid");
			User user=dao.query(uid);

			int i=dao.querySign(user.getUid(), user.getUname());

			Date date = new Date();
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			String nowTime2 = new SimpleDateFormat("HH").format(date);
			int Time=Integer.valueOf(nowTime2.toString());
			int Timeint=0;
			PrintWriter out = response.getWriter();
			String result="ǩ���ɹ�,ǩ��ʱ��"+nowTime;

			if(i==0){  //i=0 ��û��ǩ����Ϣ
				if(Time<=12){ //ʱ��С��12�� �������ǩ��ʱ�� ����ǩ����
					Timeint = 1;
					dao.addDayatt(user.getUid(), user.getUname(), Timeint);

				}else {//ʱ�����12�� ����ǩ������ǩ����Ϣ �������ǩ��ʱ��
					Timeint = 3;
					dao.addDayatt(user.getUid(), user.getUname(), Timeint);
				}
			}else if(i==1){  //����ǩ�� ����ûǩ��
				if(Time>12) {
					Timeint = 2;
					dao.addDayatt(user.getUid(), user.getUname(), Timeint);
				}else {
					result="������ǩ����";
				}
			}else if(i==2){ //ȫ��ǩ����
				result="������ǩ����";
			}else if(i==3){  //����ûǩ�� ��������ǩ��
				Timeint = 3;
				result="������ǩ����";
			}

			out.println(result);   






		}else if(xinxi.equals("aw")){

			int uid=(int) session.getAttribute("uid");
			User user=dao.query(uid);

			int i=dao.queryAw(user.getUid(), user.getUname());

			Date date = new Date();
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			String nowTime2 = new SimpleDateFormat("HH").format(date);
			int Time=Integer.valueOf(nowTime2.toString());
			int Timeint=0;

			PrintWriter out = response.getWriter();
			String result="ǩ�˳ɹ���ǩ��ʱ��"+nowTime;

			if(i==0){  //i=0 ��û��ǩ����Ϣ
				if(Time<=12){ //ʱ��С��12�� �������ǩ��ʱ�� ����ǩ����
					Timeint = 1;
					dao.addDayattAw( user.getUid(), user.getUname(), Timeint);

				}else {//ʱ�����12�� ����ǩ������ǩ����Ϣ �������ǩ��ʱ��
					Timeint = 2;
					dao.addDayattAw(user.getUid(), user.getUname(), Timeint);
				}
			}else if(i==1){
				if(Time<=12){ //ʱ��С��12�� �������ǩ��ʱ�� ����ǩ����
					result="������ǩ��";

				}else {//ʱ�����12�� ����ǩ������ǩ����Ϣ �������ǩ��ʱ��
					Timeint = 2;
					dao.addDayattAw(user.getUid(), user.getUname(), Timeint);
				}
			}else if(i==2){
				result="������ǩ��";
			}else if(i==3){
				result="������ǩ��";
			}

			out.println(result);   



		}else if(xinxi.equals("nsign")){ //���ϼӰ�ǩ����

			int uid=(int) session.getAttribute("uid");
			User user=dao.query(uid);

			int i=dao.queryNSign(user.getUid(), user.getUname());
			Date date = new Date();
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			String nowTime2 = new SimpleDateFormat("HH").format(date);
			int Time=Integer.valueOf(nowTime2.toString());

			PrintWriter out = response.getWriter();
			String result="�Ӱ�ǩ���ɹ���ǩ��ʱ��"+nowTime;

			if(i==0){  //δǩ��
				if(Time>=20){  //����������ʱ�䳬��20ʱ �������ϼӰ�ǩ��
					int u = dao.addDayattNsign(user.getUid(), user.getUname());
					System.out.println(u);
					System.out.println(111);
				}else{
					result = "δ��ǩ��ʱ��";
				}
			}else{
				result="������ǩ��";
			}
			out.write(result);
			out.flush();
			out.close();

		}else if(xinxi.equals("naw")){//���ϼӰ����
			int uid=(int) session.getAttribute("uid");
			User user=dao.query(uid);

			int i=dao.queryNaw(user.getUid(), user.getUname());

			Date date = new Date();
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			String nowTime2 = new SimpleDateFormat("HH").format(date);
			int Time=Integer.valueOf(nowTime2.toString());

			PrintWriter out = response.getWriter();
			String result="�Ӱ�ǩ�˳ɹ���ǩ��ʱ��"+nowTime;

			if(i==0){  //δǩ��
				if(Time>=20){  //����������ʱ�䳬��20ʱ �������ϼӰ�ǩ��
					dao.addDayattNaw(user.getUid(), user.getUname());
				}else{
					result = "δ��ǩ��ʱ��";
				}
			}else{
				result="������ǩ��";
			}
			out.write(result);
			out.flush();
			out.close();


		}else if(xinxi.equals("queryUser")){
			int uid=(int) session.getAttribute("uid");
			UserBase userBase= new UserBase();
			userBase = dao.queryUserBase(uid);  //����uesrbase���������Ϣ

			PrintWriter out = response.getWriter();  //��Ӧǰ���ַ�������

			JSONObject jsObject=JSONObject.fromObject(userBase);  
			//����JSONObject����  ��userbase�����������
			String jo=jsObject.toString();
			//��JSONObject����ת��Ϊ�ַ���������jo��  ��������

			out.write(jo);
			//ͨ��write���������ַ�����ʽ���ݵ�ǰ̨

			out.flush();
			out.close();
		}else if(xinxi.equals("queryAtt")){
			int uid=(int) session.getAttribute("uid");
			PrintWriter out = response.getWriter();  //��Ӧǰ���ַ�������
			List<Att> list = new ArrayList<>();
			list = dao.queryAllAtt(uid);
			JSONArray jsObject=JSONArray.fromObject(list);  
			//����JSONObject����  ��list�����������
			String jo=jsObject.toString();
			//��JSONObject����ת��Ϊ�ַ���������jo��  ��������
			out.write(jo);
			//ͨ��write���������ַ�����ʽ���ݵ�ǰ̨
			out.flush();
			out.close();
		}else if(xinxi.equals("queryWPlan")) {
			int uid=(int) session.getAttribute("uid");
			PrintWriter out = response.getWriter();  //��Ӧǰ���ַ�������
			List<WagePlan> list = new ArrayList<>();
			list = dao.queryAllWPlan(uid);
			JSONArray jsObject=JSONArray.fromObject(list);  
			//����JSONObject����  ��list�����������
			String jo=jsObject.toString();
			//��JSONObject����ת��Ϊ�ַ���������jo��  ��������
			out.write(jo);
			//ͨ��write���������ַ�����ʽ���ݵ�ǰ̨
			out.flush();
			out.close();
		}else if(xinxi.equals("queryStaff")) {
			int uid=(int) session.getAttribute("uid");
			Staff staff = new Staff();
			staff = dao.queryStaff(uid);
			PrintWriter out = response.getWriter();  //��Ӧǰ���ַ�������

			JSONObject jsObject=JSONObject.fromObject(staff);  
			//����JSONObject����  ��userbase�����������

			String jo=jsObject.toString();
			//��JSONObject����ת��Ϊ�ַ���������jo��  ��������

			out.write(jo);
			//ͨ��write���������ַ�����ʽ���ݵ�ǰ̨
			out.flush();
			out.close();
		}
		else if(xinxi.equals("getleave")) {
			
			PrintWriter out=response.getWriter();
			
			//����uid ��ѯ��������
			String uidS=session.getAttribute("uid").toString();
			int uid=Integer.valueOf(uidS);
			User user=dao.query(uid);
			String uname = user.getUname();
			
			String result =null;
			if(dao.queryTsleave(uid)==0) {
				depuser depuser = new depuser();
				depuser = dao.queryDepUser(uid);
				String dep=depuser.getDname();
				String pos=depuser.getPname();
				
				//���ID���������
				Date date = new Date();
				String lday = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				String lidS = new SimpleDateFormat("yyyyMMdd").format(date);
				int lid = Integer.valueOf(lidS);
				
				//�������������תΪINT����
				String lnumS=request.getParameter("lnum");
				int lnum = Integer.valueOf(lnumS);
				
				//������ٿ�ʼʱ��ͽ���ʱ��
				String YYYY = request.getParameter("YYYY");
				String MM = request.getParameter("MM");
				String DD = request.getParameter("DD");
				String lstart =YYYY+"-"+MM+"-"+DD;
				
				String YYYYY = request.getParameter("YYYY");
				String MMM = request.getParameter("MM");
				String DDD = request.getParameter("DD");
				String lend =YYYY+"-"+MM+"-"+DD;
				
				//�������ԭ��
				String lreason = request.getParameter("lreason");
				
				Tsleave tsleave = new Tsleave();
				tsleave.setLid(lid);
				tsleave.setUid(uid);
				tsleave.setUname(uname);
				tsleave.setDep(dep);
				tsleave.setPos(pos);
				tsleave.setLnum(lnum);
				tsleave.setLreason(lreason);
				tsleave.setLstart(lstart);
				tsleave.setLend(lend);
				tsleave.setLday(lday);
				//��ӵ���ʱԱ����ٱ�
				dao.addTsleave(tsleave);
				result ="1";
				
			}else {
				result ="2";
				
			}
			
			out.write(result);
			
			out.flush();
			out.close();
		}else if(xinxi.equals("gettrip")) {
			PrintWriter out=response.getWriter();
			String result = "";
			//����uid ��ѯ��������
			String uidS=session.getAttribute("uid").toString();
			int uid=Integer.valueOf(uidS);
			User user=dao.query(uid);
			String uname = user.getUname();
			
			if(dao.queryTstrip(uid)==0) {
				
				depuser depuser = new depuser();
				depuser = dao.queryDepUser(uid);
				String dep=depuser.getDname();
				String pos=depuser.getPname();
				
				//���ID���������
				Date date = new Date();
				String tday = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				String tidS = new SimpleDateFormat("yyyyMMdd").format(date);
				int tid = Integer.valueOf(tidS);
				
				//�������������תΪINT����
				String tnumS=request.getParameter("tnum");
				int tnum = Integer.valueOf(tnumS);
				//�������ԭ��
				String treason = request.getParameter("treason");
				//���ճ����
				String tplace = request.getParameter("tplace");
				//���տ�ʼ�����ʱ��
				String tstart = request.getParameter("tstart");
				String tend = request.getParameter("tend");
				
				Tstrip tstrip = new Tstrip();
				tstrip.setTid(tid);
				tstrip.setUid(uid);
				tstrip.setUname(uname);
				tstrip.setDep(dep);
				tstrip.setPos(pos);
				tstrip.setTnum(tnum);
				tstrip.setTreason(treason);
				tstrip.setTplace(tplace);
				tstrip.setTstart(tstart);
				tstrip.setTend(tend);
				tstrip.setTday(tday);
				
				dao.addTstrip(tstrip);
				result ="1";
				
			}else {
				result ="2";
				
			}
			
			out.write(result);
			
			out.flush();
			out.close();
		}else if(xinxi.equals("queryUserDP")) {
			
			PrintWriter out=response.getWriter();
			
			int uid = (int) session.getAttribute("uid");
			String quidS=request.getParameter("quid");
			String quname=request.getParameter("quname");
			String qpname=request.getParameter("qpname");
			String qdname=request.getParameter("qdname");
			String qtripS=request.getParameter("qtrip");
			String qleaveS=request.getParameter("qleave");
			
			//�޸�������ѯ����������
			int quid=0;
			if(quidS!=null&&!quidS.equals("")) {
				quid=Integer.valueOf(quidS);
			}
			
			int qtrip=0;//0��ʾ����
			int qleave=0;//0��ʾ����ѯ
			if(qtripS.equals("������")) {
				qtrip=0;
			}else if(qtripS.equals("��")) {
				qtrip=1;		//1λ�ڳ������
			}else {
				qtrip=2;		//2Ϊ���ڳ������
			}
			
			if(qleaveS.equals("������")) {
				qleave=0;
			}else if(qleaveS.equals("��")) {
				qleave=1;
			}else {
				qleave=2;
			}
			
			List<User> list=dao.queryUserAll(uid, quid, quname, qdname, qpname, qleave, qtrip);
			JSONArray jsonArray = JSONArray.fromObject(list);
			//����JSONObject����  ��list�����������
			String jo=jsonArray.toString();
			//��JSONObject����ת��Ϊ�ַ���������jo��  ��������
			out.write(jo);
			out.flush();
			out.close();
			
		}else if(xinxi.equals("trip")) {
			PrintWriter out=response.getWriter();
			String uidS = request.getParameter("uid");
			int uid = Integer.valueOf(uidS);
			
			List<Tstrip> list = new ArrayList<>();
			list = dao.queryTsTrip(uid);
			JSONArray jsonArray = JSONArray.fromObject(list);
			//����JSONObject����  ��list�����������
			String jo=jsonArray.toString();
			//��JSONObject����ת��Ϊ�ַ���������jo��  ��������
			out.write(jo);
			out.flush();
			out.close();
			
		}else if(xinxi.equals("trippass")) {
			PrintWriter out=response.getWriter();
			String triptableuid=request.getParameter("triptableuid");
			String uidS = request.getParameter("uid");
			int uid = Integer.valueOf(uidS);
			int tripuid= Integer.valueOf(triptableuid);
			
			int i = 0;
			i=dao.addTrip(tripuid, uid);
			if (i==1) {
				dao.delTsTrip(tripuid);
				i=2;
			}
			
			out.println(i+"");
			out.flush();
			out.close();
			
		}else if(xinxi.equals("notrippass")) {
			PrintWriter out=response.getWriter();
			String triptableuid=request.getParameter("triptableuid");
			int tripuid= Integer.valueOf(triptableuid);
			System.out.println("111");
			int i =dao.delTsTrip(tripuid);
			
			out.println(i+"");
			out.flush();
			out.close();
		}else if(xinxi.equals("leave")) {
			PrintWriter out=response.getWriter();
			String uidS = request.getParameter("uid");
			int uid = Integer.valueOf(uidS);
			
			List<Tsleave> list = new ArrayList<>();
			list =dao.queryTsLeave(uid);
			JSONArray jsonArray = JSONArray.fromObject(list);
			//����JSONObject����  ��list�����������
			String jo=jsonArray.toString();
			//��JSONObject����ת��Ϊ�ַ���������jo��  ��������
			out.write(jo);
			out.flush();
			out.close();
			
		}else if(xinxi.equals("leavepass")) {
			PrintWriter out=response.getWriter();
			String leavetableuid=request.getParameter("leavetableuid");
			String uidS = request.getParameter("uid");
			int uid = Integer.valueOf(uidS);
			int leaveuid= Integer.valueOf(leavetableuid);
			
			int i = 0;
			i=dao.addLeave(leaveuid, uid);
			if (i==1) {
				dao.delTsLeave(leaveuid);
				i=2;
			}
			
			out.println(i+"");
			out.flush();
			out.close();
			
		}else if(xinxi.equals("noleavepass")) {
			PrintWriter out=response.getWriter();
			String leavetableuid=request.getParameter("leavetableuid");
			int leaveuid= Integer.valueOf(leavetableuid);
			int i =dao.delTsLeave(leaveuid);
			
			out.println(i+"");
			out.flush();
			out.close();
		}else if(xinxi.equals("queryleave")) {
			PrintWriter out=response.getWriter();
			String uidS = request.getParameter("uid");
			int uid = Integer.valueOf(uidS);
			List<Leave> list = new ArrayList<>();
			list = dao.queryLeave(uid);
			JSONArray jsonArray = JSONArray.fromObject(list);
			String jo = jsonArray.toString();
			out.write(jo);
			out.flush();
			out.close();
			
		}else if(xinxi.equals("querytrip")) {
			PrintWriter out=response.getWriter();
			String uidS = request.getParameter("uid");
			int uid = Integer.valueOf(uidS);
			List<Trip> list = new ArrayList<>();
			list = dao.queryTrip(uid);
			JSONArray jsonArray = JSONArray.fromObject(list);
			String jo = jsonArray.toString();
			out.write(jo);
			out.flush();
			out.close();
			
		}


	}

}
