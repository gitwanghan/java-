package com.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bdqn.bean.Ass;
import com.bdqn.bean.Att;
import com.bdqn.bean.Dayatt;
import com.bdqn.bean.Dep;
import com.bdqn.bean.Leave;
import com.bdqn.bean.PerTaxes;
import com.bdqn.bean.Pos;
import com.bdqn.bean.Staff;
import com.bdqn.bean.Trip;
import com.bdqn.bean.Tsleave;
import com.bdqn.bean.Tstrip;
import com.bdqn.bean.User;
import com.bdqn.bean.UserBase;
import com.bdqn.bean.Wage;
import com.bdqn.bean.WagePlan;
import com.bdqn.bean.depuser;
import com.bdqn.dao.UserDao;
import com.bdqn.util.Todb;
import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.bcel.internal.generic.DALOAD;
import com.sun.prism.Presentable;

public class UserDaoImpl implements UserDao {
	Todb t= new Todb();
	Connection con=t.getConnection();
	private ArrayList<Dayatt> arrayList;
	@Override
	public int dl(int uid, String upwd) {
		String sql="select * from user where uid="+uid;
		User user = new User();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					user.setUpwd(rs.getString("upwd"));
					if(user.getUpwd()==upwd){
						i=1;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public User query(int uid) {
		//��ѯ�û���Ϣ
		String sql="select * from user where uid="+uid;
		User user = new User();
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					user.setUid(rs.getInt("uid"));
					user.setUpwd(rs.getString("upwd"));
					user.setUname(rs.getString("uname"));
					user.setUtype(rs.getString("utype"));
					user.setUidcard(rs.getString("uidcard"));
					user.setAdd(rs.getString("add"));
					user.setPhone(rs.getString("phone"));
					user.setEmail(rs.getString("email"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public int add(UserBase userBase) {
		//�û��ڶ���ע��
		String sql2="insert into userbase values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement ps= con.prepareStatement(sql2);
			ps.setInt(1, userBase.getUid());
			ps.setString(2, userBase.getUname());
			ps.setString(3, userBase.getUgen());
			ps.setString(4, userBase.getUborndate());
			ps.setString(5, userBase.getUnplace());
			ps.setString(6, userBase.getUnational());
			ps.setString(7, userBase.getUidcard());
			ps.setString(8, userBase.getUpl());
			ps.setInt(9, userBase.getDid());
			ps.setString(10, userBase.getSdate());
			ps.setInt(11, userBase.getPid());
			ps.setString(12, userBase.getTitle());
			ps.setString(13, userBase.getStartdate());
			ps.setString(14, userBase.getUnito());
			ps.setString(15, userBase.getUnitt());
			ps.setString(16, userBase.getUnitp());
			ps.setString(17, userBase.getGschool());
			ps.setString(18, userBase.getSdate());
			ps.setString(19, userBase.getEdu());
			ps.setString(20, userBase.getPro());
			ps.setString(21, userBase.getLan());
			ps.setString(22, userBase.getAdd());
			ps.setString(23, userBase.getPhone());
			ps.setString(24, userBase.getEmail());
			ps.setString(25, userBase.getState());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int addF(User user) {
		//�û���һ��ע��
		int i = 0;
		String sql = "insert into user(uname,utype,upwd,uper,uidcard,`add`,`phone`,`email`) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, "��ͨ�û�");
			ps.setString(3, user.getUpwd());
			ps.setInt(4, user.getUper());
			ps.setString(5, user.getUidcard());
			ps.setString(6, user.getAdd());
			ps.setString(7, user.getPhone());
			ps.setString(8, user.getEmail());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int a(String a) {
		//������
		String sql = "insert into a(uname) values(?)";
		int i=0;
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, "uname");
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	@Override
	public User queryUid(String uidcard) {
		// ͨ�����֤��user���л�ȡ������ע������Ҫ����Ϣ
		String sql="select * from user where uidcard="+uidcard;
		User user = new User();
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					user.setUid(rs.getInt("uid"));
					user.setUpwd(rs.getString("upwd"));
					user.setUname(rs.getString("uname"));
					user.setUtype(rs.getString("utype"));
					user.setUidcard(rs.getString("uidcard"));
					user.setAdd(rs.getString("add"));
					user.setPhone(rs.getString("phone"));
					user.setEmail(rs.getString("email"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	@Override
	public int queryDid(String dname) {
		//��������ע��ʱӦƸ��������Ӧ�Ĳ��ű���
		Dep dep = new Dep();
		String sql = "select * from department where dname=?";
		int did = 0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dname);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				dep.setDid(rs.getInt("did"));
				did=dep.getDid();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return did;
	}
	@Override
	public int queryPid(String pname) {
		//��������ע��ʱӦƸְ������Ӧ��ְ�����
		Pos pos= new Pos();
		String sql = "select * from position where pname=?";
		int pid=0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pname);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				pos.setPid(rs.getInt("pid"));
				pid=pos.getPid();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pid;
	}
	@Override
	public int addStaff(Staff staff) {
		//�Զ�����Ա��¼����Ϣ��
		String sql = "insert into staff(uid,uname,sdate,sedate,stype,ed,ep,em,stext) values(?,?,?,?,?,?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,staff.getUid());
			ps.setString(2, staff.getUname());
			ps.setString(3, staff.getSdate());
			ps.setString(4, staff.getSedate());
			ps.setString(5, staff.getStype());
			ps.setString(6, staff.getEd());
			ps.setString(7, staff.getEp());
			ps.setString(8, staff.getEm());
			ps.setString(9, staff.getStext());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	@Override
	public int addDayatt(int uid , String uname , int Timeint) {
		//��Ա��ǩ��ʱ���Զ�����ÿ��ǩ����
		int i=0;
		Date date =new Date();
		String nowday =new SimpleDateFormat("yyyy-MM-dd").format(date); //����nowday
		String nowtime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//����ǩ��ʱ��
		String late =new SimpleDateFormat("HH").format(date);
		int lateTime=Integer.valueOf(late);  //�ж��Ƿ񳬹���ǩ��ʱ�� ���� �ٵ���Ϣ
		
		String day = new SimpleDateFormat("yyyyMMdd").format(date);
		int dayid=Integer.valueOf(day);  //����dayid
		
		if(Timeint ==1){//����δǩ ����ǩ��������ǩ����
			String sql = "insert into dayatt(dayid,uid,msign,nowday,late,uname) values(?,?,?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, dayid);
				ps.setInt(2, uid);
				ps.setString(3, nowtime);
				ps.setString(4, nowday);
				if(lateTime>8){
					ps.setString(5, "�ٵ�");
				}else{
					ps.setString(5, "");
				}
				ps.setString(6, uname);
				i=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(Timeint ==2){ //�����Ѿ�ǩ��������ǩ��
			Dayatt dayatt = queryDayatt(dayid, uid);  //��ѯdayatt���� �����Ժ���Ϣ���� ��������
			
			String sql = "update dayatt set dayid=? , msign=? , maw=? , asign=? , aaw=? , nsign=? , naw=? , nowday=? , `leave`=? , `late`=? where uid=? and uname=? ";
			try {
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setInt(1,dayid );
				ps.setString(2, dayatt.getMsign());
				ps.setString(3, dayatt.getMaw());
				ps.setString(4, nowtime);
				ps.setString(5, dayatt.getAaw());
				ps.setString(6, dayatt.getNsign());
				ps.setString(7, dayatt.getNaw());
				ps.setString(8, dayatt.getNowday());
				ps.setString(9, dayatt.getLeave());
				
				if(lateTime>14){
					ps.setString(10, "�ٵ�");
				}else{
					ps.setString(10, dayatt.getLate());
				}
				
				ps.setInt(11, uid);
				ps.setString(12, uname);
				
				i=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(Timeint ==3){   //����ûǩ�� δ����ǩ���� ����ǩ��
			String sql = "insert into dayatt(dayid,uid,asign,nowday,late,uname) values(?,?,?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, dayid);
				ps.setInt(2, uid);
				ps.setString(3, nowtime);
				ps.setString(4, nowday);
				if(lateTime>14){
					ps.setString(5, "�ٵ�");
				}else{
					ps.setString(5, "");
				}
				ps.setString(6, uname);
				i=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}
	@Override
	public int querySign(int uid,String uname) {
		//��ѯԱ��ǩ��ʱ���Ƿ���ǩ�����ж�ǩ��ʱ�������绹�����磻
		Date date = new Date();
		String nowTime = new SimpleDateFormat("yyyyMMdd").format(date);
		int Time=Integer.valueOf(nowTime.toString());
		String sql="select * from dayatt where uid=? and uname=? and dayid=?";
		int i=0;  //0Ϊδǩ��
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, uname);
			ps.setInt(3, Time);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				if((rs.getString("msign")!=null&&rs.getString("msign")!="")&&(rs.getString("asign")!=null&&rs.getString("asign")!="")){
					i=2;   //������Ϻ����綼ǩ���� �򷵻�2
				}else if((rs.getString("msign")!=null&&rs.getString("msign")!="")&&(rs.getString("asign")==null||rs.getString("asign")=="")){
					i=1;   //�������ǩ�� ����ûǩ �򷵻�1
				}else if((rs.getString("msign")==null||rs.getString("msign")=="")&&(rs.getString("asign")!=null&&rs.getString("asign")!="")){
					i=3; //����ûǩ ����ǩ�� ����3
				}else{
					i=0; //ȫδǩ
				}
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public UserBase queryUserBase(int uid) {
		//��ѯ�û�������Ϣ
		String sql = "select * from userbase where uid="+uid;
		UserBase userBase = new UserBase();
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				userBase.setUid(rs.getInt("uid"));
				userBase.setUname(rs.getString("uname"));
				userBase.setUgen(rs.getString("ugen"));
				userBase.setUborndate(rs.getString("uborndate"));
				userBase.setUnplace(rs.getString("unplace"));
				userBase.setUnational(rs.getString("unational"));
				userBase.setUidcard(rs.getString("uidcard"));
				userBase.setUpl(rs.getString("upl"));
				userBase.setDid(rs.getInt("did"));
				userBase.setSdate(rs.getString("sdate"));
				userBase.setPid(rs.getInt("pid"));
				userBase.setTitle(rs.getString("title"));
				userBase.setStartdate(rs.getString("startdate"));
				userBase.setUnito(rs.getString("unito"));
				userBase.setUnitt(rs.getString("unitt"));
				userBase.setUnitp(rs.getString("unitp"));
				userBase.setGschool(rs.getString("gschool"));
				userBase.setGdate(rs.getString("gdate"));
				userBase.setEdu(rs.getString("edu"));
				userBase.setPro(rs.getString("pro"));
				userBase.setLan(rs.getString("lan"));
				userBase.setAdd(rs.getString("add"));
				userBase.setPhone(rs.getString("phone"));
				userBase.setEmail(rs.getString("email"));
				userBase.setState(rs.getString("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userBase;
	}
	@Override
	public int addDayattAw(int uid , String uname ,int Timeint) {
		//Ա��ǩ�������ǩ�˷���
		//��Ա��ǩ��ʱ���Զ�����ÿ��ǩ����
				int i=0;
				Date date = new Date();
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				String nowTime2 = new SimpleDateFormat("yyyyMMdd").format(date);
				int dayid=Integer.valueOf(nowTime2.toString());
				String nowday = new SimpleDateFormat("yyyy-MM-dd").format(date);
				
				Dayatt d=queryDayatt(dayid, uid);
				
				if(Timeint ==1){  //����δǩ�� ����ǩ����Ϣ�� 
					String sql="update dayatt set  msign=? , maw=? , asign=? , aaw=? , nsign=? , naw=? , nowday=? , `leave`=? , `late`=? where uid=? and uname=? and dayid=?  ";
					try {
						PreparedStatement ps= con.prepareStatement(sql);
						ps.setString(1, d.getMsign());
						ps.setString(2, nowTime);
						ps.setString(3, d.getAsign());
						ps.setString(4, d.getAaw());
						ps.setString(5, d.getNsign());
						ps.setString(6, d.getNaw());
						ps.setString(7, d.getNowday());
						ps.setString(8, d.getLeave());
						
						ps.setString(9, d.getLate());
						ps.setInt(10, uid);
						ps.setString(11, uname);
						ps.setInt(12,dayid );
						i=ps.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
		
					
					String sql="update dayatt set  msign=? , maw=? , asign=? , aaw=? , nsign=? , naw=? , nowday=? , `leave`=? , `late`=? where uid=? and uname=? and dayid=?  ";
					try {
						PreparedStatement ps= con.prepareStatement(sql);
						ps.setString(1, d.getMsign());
						ps.setString(2, d.getMaw());
						ps.setString(3, d.getAsign());
						ps.setString(4, nowTime);
						ps.setString(5, d.getNsign());
						ps.setString(6, d.getNaw());
						ps.setString(7, d.getNowday());
						ps.setString(8, d.getLeave());
						
						ps.setString(9, d.getLate());
						ps.setInt(10, uid);
						ps.setString(11, uname);
						ps.setInt(12,dayid );
						i=ps.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				
				}
				return i;
	}
	@Override
	public int queryAw(int uid, String uname) {
		//��ѯԱ��ǩ��ʱ���Ƿ���ǩ�ˣ��ж�ǩ��ʱ�������绹�����磻
		String sql="select * from dayatt where uid=? and uname=?";
		int i=0;  //0Ϊδǩ��
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, uname);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				if((rs.getString("maw")!=null&&rs.getString("maw")!="")&&(rs.getString("aaw")!=null&&rs.getString("aaw")!="")){
					i=2;   //������Ϻ����綼ǩ���� �򷵻�2
				}else if((rs.getString("maw")!=null&&rs.getString("maw")!="")&&(rs.getString("aaw")==null||rs.getString("aaw")=="")){
					i=1;   //�������ǩ�� ����ûǩ �򷵻�1
				}else if((rs.getString("maw")==null||rs.getString("maw")=="")&&(rs.getString("aaw")!=null&&rs.getString("aaw")!="")){
					i=3;
				}else{
					i=0;
				}
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	@Override
	public Dayatt queryDayatt(int dayid, int uid) {
		//��ѯdayatt�� ����һ��dayatt���� ������dayattʹ��
		String sql = "select * from dayatt where dayid=? and uid=?";
		Dayatt d = new Dayatt();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dayid);
			ps.setInt(2, uid);
			ResultSet rs=ps.executeQuery();
			
			
			
			while(rs.next()){
				d.setDayid(dayid);
				d.setUid(uid);
				d.setMsign(rs.getString("msign"));
				d.setMaw(rs.getString("maw"));
				d.setAsign(rs.getString("asign"));
				d.setAaw(rs.getString("aaw"));
				d.setNsign(rs.getString("nsign"));
				d.setNaw(rs.getString("naw"));
				d.setNowday(rs.getString("nowday"));
				d.setLeave(rs.getString("leave"));
				d.setLate(rs.getString("late"));
				d.setUname(rs.getString("uname"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	@Override
	public int addDayattNsign(int uid, String uname) {
		//�Ӱ�ǩ������
		
		int i=0;
		Date date =new Date();
		String nowtime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//����ǩ��ʱ��
		
		String day = new SimpleDateFormat("yyyyMMdd").format(date);
		int dayid=Integer.valueOf(day);  //����dayid
		
		Dayatt dayatt = queryDayatt(dayid, uid);  //��ѯdayatt���� �����Ժ���Ϣ���� ��������
		
		String sql = "update dayatt set  msign=? , maw=? , asign=? , aaw=? , nsign=? , naw=? , nowday=? , `leave`=? , `late`=? where uid=? and uname=? and dayid=? ";
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			
			ps.setString(1, dayatt.getMsign());
			ps.setString(2, dayatt.getMaw());
			ps.setString(3, dayatt.getAsign());
			ps.setString(4, dayatt.getAaw());
			ps.setString(5, nowtime);
			ps.setString(6, dayatt.getNaw());
			ps.setString(7, dayatt.getNowday());
			ps.setString(8, dayatt.getLeave());
			ps.setString(9, dayatt.getLate());
			ps.setInt(10, uid);
			ps.setString(11, uname);
			ps.setInt(12,dayid );
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}
	@Override
	public int queryNSign(int uid, String uname) {
		//��ѯԱ��ǩ��ʱ���Ƿ���ǩ�����ж�ǩ��ʱ���Ƿ��ڼӰ�ʱ���ڣ�
		String sql="select * from dayatt where uid=? and uname=?";
		int i=0;  //0Ϊδδǩ��
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, uname);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				if(rs.getString("nsign")!=null&&rs.getString("nsign")!=""){
					i=1;  //i����1  ��ʾ��ǩ��
				}else{
					i=0;
				}
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
		
	}
	@Override
	public int addDayattNaw(int uid, String uname) {
		//Ա���Ӱ������
		int i=0;
		Date date =new Date();
		String nowtime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//����ǩ��ʱ��
		
		String day = new SimpleDateFormat("yyyyMMdd").format(date);
		int dayid=Integer.valueOf(day);  //����dayid
		
		Dayatt dayatt = queryDayatt(dayid, uid);  //��ѯdayatt���� �����Ժ���Ϣ���� ��������
		
		String sql = "update dayatt set  msign=? , maw=? , asign=? , aaw=? , nsign=? , naw=? , nowday=? , `leave`=? , `late`=? where uid=? and uname=? and dayid=? ";
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			
			ps.setString(1, dayatt.getMsign());
			ps.setString(2, dayatt.getMaw());
			ps.setString(3, dayatt.getAsign());
			ps.setString(4, dayatt.getAaw());
			ps.setString(5, dayatt.getNsign());
			ps.setString(6, nowtime);
			ps.setString(7, dayatt.getNowday());
			ps.setString(8, dayatt.getLeave());
			ps.setString(9, dayatt.getLate());
			ps.setInt(10, uid);
			ps.setString(11, uname);
			ps.setInt(12,dayid );
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
		
	}
	@Override
	public int queryNaw(int uid, String uname) {
		//��ѯԱ��ǩ��ʱ���Ƿ���ǩ�ˣ�
		String sql="select * from dayatt where uid=? and uname=?";
		int i=0;  //0Ϊδδǩ��
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, uname);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				if(rs.getString("naw")!=null&&rs.getString("naw")!=""){
					i=1;  //i����1  ��ʾ��ǩ��
				}else{
					i=0;
				}
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public List<User> queryUser() {
		//�����û���Ϣ�� ���������û���Ϣ�������Զ����� ����ǩ�� ���ڱ�
		List<User> list = new ArrayList<>();
		String sql = "select * from user";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					User user = new User();
					
					user.setUid(rs.getInt("uid"));
					user.setUpwd(rs.getString("upwd"));
					user.setUname(rs.getString("uname"));
					user.setUtype(rs.getString("utype"));
					user.setUidcard(rs.getString("uidcard"));
					user.setAdd(rs.getString("add"));
					user.setPhone(rs.getString("phone"));
					user.setEmail(rs.getString("email"));
					
					list.add(user);
					
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int addAtt(int uid,int title) {
		//�� titleΪ1ʱ �������ڱ�Ϊ0ʱ��������
		int i = 0;
		
		Date date=new Date();
	
		String nowtime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//����ǩ��ʱ��
		
		String day = new SimpleDateFormat("yyyyMMdd").format(date);
		int aid=Integer.valueOf(day);  //����dayid
		String day2 = new SimpleDateFormat("yyyyMM").format(date);
		int aid2=Integer.valueOf(day2);  //����dayid
		
		Dayatt dayatt=queryDayatt(aid, uid);
		
		if(title ==1){
			String sql = "insert into attendance(aid,uid,adate,atype,signday,workday,absday,lateday,leaveday,uname) values(?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, aid2);
				ps.setInt(2, uid);
				ps.setString(3, nowtime);
				ps.setString(4, "ǩ��");
				
				if((dayatt.getMsign()==null||dayatt.getMsign()=="")&&(dayatt.getAsign()==null||dayatt.getAsign()=="")){
					ps.setInt(5, 0);
				}else{
					ps.setInt(5, 1);
				}
				if(dayatt.getNsign()==null||dayatt.getNsign()==""){
					ps.setInt(6, 0);
				}else{
					ps.setInt(6, 1);
				}
				
				if((dayatt.getMsign()==null&&dayatt.getMsign()=="")&&(dayatt.getAsign()==null&&dayatt.getAsign()=="")){
					ps.setInt(7, 1);
				}else{
					ps.setInt(7, 0);
				}
				if(dayatt.getLate()==""||dayatt.getLate()==null){
					ps.setInt(8, 0);
				}else{
					ps.setInt(8, 1);
				}
				if(dayatt.getLeave()==""||dayatt.getLeave()==null){
					ps.setInt(9, 0);
				}else{
					ps.setInt(9, 1);
				}
				ps.setString(10, dayatt.getUname());
				i=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			Att att=queryAtt(uid,aid2);
			String sql = "update attendance set aid=?,adate=?,atype=?,signday=?,workday=?,absday=?,lateday=?,leaveday=?,atext=?,uname=? where uid=?";
			try {
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setInt(1, att.getAid());
				ps.setString(2, nowtime);
				ps.setString(3, att.getAtype());
				
				if((dayatt.getMsign()==null||dayatt.getMsign()=="")&&(dayatt.getAsign()==null||dayatt.getAsign()=="")){
					ps.setInt(4, att.getSignday());
				}else{
					ps.setInt(4, att.getSignday()+1);
				}
				if(dayatt.getNsign()==null||dayatt.getNsign()==""){
					ps.setInt(5, att.getWorkday());
				}else{
					ps.setInt(5, att.getWorkday()+1);
				}
				if((dayatt.getMsign()==null&&dayatt.getMsign()=="")&&(dayatt.getAsign()==null&&dayatt.getAsign()=="")){
					ps.setInt(6, att.getAbsday()+1);
				}else{
					ps.setInt(6, att.getAbsday());
				}
				if(dayatt.getLate()==""||dayatt.getLate()==null){
					ps.setInt(7, att.getLateday());
				}else{
					ps.setInt(7, att.getLateday()+1);
				}
				if(dayatt.getLeave()==""||dayatt.getLeave()==null){
					ps.setInt(8, att.getLeaveday());
				}else{
					ps.setInt(8, att.getLeaveday()+1);
				}
				ps.setString(9, att.getAtext());
				ps.setString(10, att.getUname());
				ps.setInt(11,uid );
				i=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}
	@Override
	public Att queryAtt(int uid,int aid) {
		Att att=new Att();
		String sql ="select * from attendance where uid="+uid;
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				att.setAid(aid);
				att.setUid(rs.getInt("uid"));
				att.setAdate(rs.getString("adate"));
				att.setAtype(rs.getString("atype"));
				att.setSignday(rs.getInt("signday"));
				att.setAbsday(rs.getInt("absday"));
				att.setLateday(rs.getInt("lateday"));
				att.setLeaveday(rs.getInt("leaveday"));
				att.setAtext(rs.getString("atext"));
				att.setUname(rs.getString("uname"));
				att.setWorkday(rs.getInt("workday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return att;
	}
	@Override
	public int addAss(int uid) {
		//��titleΪ1ʱ���������˱�Ϊ0��������
		
		int i = 0;
		
		Date date=new Date();
	
		String nowtime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//����ǩ��ʱ��
		String nowtime2 =new SimpleDateFormat("yyyy-MM-dd").format(date);//����ǩ��ʱ��

		String day2 = new SimpleDateFormat("yyyyMM").format(date);
		int aid2=Integer.valueOf(day2);  //����dayid
		
		Wage wage = queryWage(queryPosWid(queryStaffEp(uid))); //��ѯԱ���Ĺ��ʱ�׼
		
		Att att = queryAtt(uid,aid2); //��ѯԱ���Ŀ��ڱ�
		
		float work = att.getWorkday()*wage.getWorknum();
		float assbluckle = att.getAbsday()*wage.getAbsnum()+att.getLateday()*wage.getLatenum();
		
		String sql = "insert into assessment(aid,uid,assdate,work,assbluckle,assuid) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, aid2);
			ps.setInt(2, uid);
			ps.setString(3, nowtime2);
			ps.setFloat(4, work);
			ps.setFloat(5, assbluckle);
			ps.setInt(6, 1111111);
			i=ps.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
		return i;
	}
	@Override
	public Ass queryAss(int uid,int aid) {
		//��ѯassessment������һ��Ass����
		Ass ass = new Ass();
		String sql = "select * from assessment where aid=? and uid=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, aid);
			ps.setInt(2, uid);
			ResultSet rs=ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					ass.setAid(rs.getInt("aid"));
					ass.setUid(rs.getInt("uid"));
					ass.setAssdate(rs.getString("assdate"));
					ass.setWork(rs.getFloat("work"));
					ass.setAssbluckle(rs.getFloat("assbluckle"));
					ass.setAssuid(rs.getInt("assuid"));
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ass;
	}
	@Override
	public String queryStaffEp(int uid) {
		//��ȡԱ������Ƹְ��
		String sql = "select * from staff where uid=" + uid;
		String ep= null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					ep=rs.getString("ep");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ep;
	}
	@Override
	public int queryPosWid(String ep) {
		//��ȡԱ�����ʵȼ�
		String sql = "select * from position where pname=?";
		int wid = 0;
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, ep);
			ResultSet rs= ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					wid = rs.getInt("wid");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return wid;
	}
	@Override
	public Wage queryWage(int wid) {
		//ͨ�����ʵȼ�ID��ȡ���ʱ�׼��Ϣ����Ϣ������һ��wage����
		String sql = "select * from wage where wid="+wid;
		Wage wage = new Wage();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					wage.setWid(wid);
					wage.setWname(rs.getString("wname"));
					wage.setBase(rs.getFloat("base"));
					wage.setSub(rs.getFloat("sub"));
					wage.setBonus(rs.getFloat("bonus"));
					wage.setCar(rs.getFloat("car"));
					wage.setHouse(rs.getFloat("house"));
					wage.setPension(rs.getFloat("pension"));
					wage.setMedical(rs.getFloat("medical"));
					wage.setHousing(rs.getFloat("housing"));
					wage.setWorknum(rs.getFloat("worknum"));
					wage.setAbsnum(rs.getFloat("absnum"));
					wage.setLatenum(rs.getFloat("latenum"));
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wage;
	}
	@Override
	public int AddWagePlan(int uid) {
		//�Զ����ɹ��ʼƷ���Ϣ��
		int i=0;
		Date date=new Date();
		
		String nowtime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//����ǩ��ʱ��
		
		String day = new SimpleDateFormat("yyyyMMdd").format(date);
		int aid=Integer.valueOf(day);  //����dayid
		String day2 = new SimpleDateFormat("yyyyMM").format(date);
		int aid2=Integer.valueOf(day2);  //����dayid
		
		Wage wage = queryWage(queryPosWid(queryStaffEp(uid))); //��ѯԱ���Ĺ��ʱ�׼
		Ass ass = queryAss(uid,aid2);//�鿴Ա�����ڿ��˱�
		PerTaxes perTaxes =queryPerTaxes();
		Att att = queryAtt(uid,aid2);
		
		
		float All = 0;
		if(att.getAbsday()==0&&att.getLateday()==0&&att.getLeaveday()<3){
			All = wage.getBase()+wage.getSub()+wage.getBonus()+wage.getCar()+wage.getHouse()-ass.getAssbluckle()+ass.getWork()-wage.getPension()-wage.getMedical()-wage.getHousing();
		}else{
			All = wage.getBase()+wage.getSub()+wage.getCar()+wage.getHouse()-ass.getAssbluckle()+ass.getWork()-wage.getPension()-wage.getMedical()-wage.getHousing();
			
		}
		
		float perTax=0;
		float Allnum=0;
		if(All - perTaxes.getMax6()>0){//�������ù��ʴ���7����׼
			perTax=perTaxes.getRate7()*(All-perTaxes.getMax6())+perTaxes.getRate6()*(perTaxes.getMax6()-perTaxes.getMax5())+perTaxes.getRate5()*(perTaxes.getMax5()-perTaxes.getMax4())+perTaxes.getRate4()*(perTaxes.getMax4()-perTaxes.getMax3())+perTaxes.getRate3()*(perTaxes.getMax3()-perTaxes.getMax2())+perTaxes.getRate2()*(perTaxes.getMax2()-perTaxes.getMax1())+perTaxes.getRate1()*(perTaxes.getMax1()-perTaxes.getMin1());
		}else if(All - perTaxes.getMax5()>0){//��������˰�ȼ�����6��
			perTax=perTaxes.getRate6()*(perTaxes.getMax6()-perTaxes.getMax5())+perTaxes.getRate5()*(perTaxes.getMax5()-perTaxes.getMax4())+perTaxes.getRate4()*(perTaxes.getMax4()-perTaxes.getMax3())+perTaxes.getRate3()*(perTaxes.getMax3()-perTaxes.getMax2())+perTaxes.getRate2()*(perTaxes.getMax2()-perTaxes.getMax1())+perTaxes.getRate1()*(perTaxes.getMax1()-perTaxes.getMin1());
		}else if(All - perTaxes.getMax4()>0){//��������˰�ȼ�����5��
			perTax=perTaxes.getRate5()*(perTaxes.getMax5()-perTaxes.getMax4())+perTaxes.getRate4()*(perTaxes.getMax4()-perTaxes.getMax3())+perTaxes.getRate3()*(perTaxes.getMax3()-perTaxes.getMax2())+perTaxes.getRate2()*(perTaxes.getMax2()-perTaxes.getMax1())+perTaxes.getRate1()*(perTaxes.getMax1()-perTaxes.getMin1());
		
		}else if(All - perTaxes.getMax3()>0){//��������˰˰�ʴ���4��
			perTax=perTaxes.getRate4()*(perTaxes.getMax4()-perTaxes.getMax3())+perTaxes.getRate3()*(perTaxes.getMax3()-perTaxes.getMax2())+perTaxes.getRate2()*(perTaxes.getMax2()-perTaxes.getMax1())+perTaxes.getRate1()*(perTaxes.getMax1()-perTaxes.getMin1());
	
		}else if(All - perTaxes.getMax2()>0){//��������˰�ȼ�����3��
			perTax=perTaxes.getRate3()*(perTaxes.getMax3()-perTaxes.getMax2())+perTaxes.getRate2()*(perTaxes.getMax2()-perTaxes.getMax1())+perTaxes.getRate1()*(perTaxes.getMax1()-perTaxes.getMin1());
	
		}else if(All - perTaxes.getMax1()>0){//��������˰�ȼ�����2��
			perTax=perTaxes.getRate2()*(perTaxes.getMax2()-perTaxes.getMax1())+perTaxes.getRate1()*(perTaxes.getMax1()-perTaxes.getMin1());

		}else if(All - perTaxes.getMin1()>0){//��������˰�ȼ�����1��
			perTax=perTaxes.getRate1()*(perTaxes.getMax1()-perTaxes.getMin1());

		}else{
			perTax=0;
		}
		
		
		String sql = "insert into wageplan(wpid,uid,wid,base,sub,bonus,car,house,assbluckle,work,pbluckle,mbluckle,hbluckle,`all`,income,wage,wdate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, aid2);
			ps.setInt(2, uid);
			ps.setInt(3, wage.getWid());
			ps.setFloat(4, wage.getBase());
			ps.setFloat(5, wage.getSub());
			if(att.getAbsday()==0&&att.getLateday()==0&&att.getLeaveday()<3){
				ps.setFloat(6, wage.getBonus());
			}else{
				ps.setFloat(6, 0);
			}
			ps.setFloat(7, wage.getCar());
			ps.setFloat(8, wage.getHouse());
			ps.setFloat(9, ass.getAssbluckle());
			ps.setFloat(10, ass.getWork());
			ps.setFloat(11, wage.getPension());
			ps.setFloat(12, wage.getMedical());
			ps.setFloat(13, wage.getHousing());
			ps.setFloat(14,All );
			ps.setFloat(15, perTax);
			ps.setFloat(16, All-perTax);
			ps.setString(17, nowtime);
			i=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	@Override
	public PerTaxes queryPerTaxes() {
		//��ѯ��������˰��
		String sql = "select * from pertaxes";
		PerTaxes perTaxes = new PerTaxes();
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					perTaxes.setRate1(rs.getFloat("rate1"));
					perTaxes.setMin1(rs.getFloat("min1"));
					perTaxes.setMax1(rs.getFloat("max1"));
					perTaxes.setRate2(rs.getFloat("rate2"));
					perTaxes.setMin2(rs.getFloat("min2"));
					perTaxes.setMax2(rs.getFloat("max2"));
					perTaxes.setRate3(rs.getFloat("rate3"));
					perTaxes.setMin3(rs.getFloat("min3"));
					perTaxes.setMax3(rs.getFloat("max3"));
					perTaxes.setRate4(rs.getFloat("rate4"));
					perTaxes.setMin4(rs.getFloat("min4"));
					perTaxes.setMax4(rs.getFloat("max4"));
					perTaxes.setRate5(rs.getFloat("rate5"));
					perTaxes.setMin5(rs.getFloat("min5"));
					perTaxes.setMax5(rs.getFloat("max5"));
					perTaxes.setRate6(rs.getFloat("rate6"));
					perTaxes.setMin6(rs.getFloat("min6"));
					perTaxes.setMax6(rs.getFloat("max6"));
					perTaxes.setRate7(rs.getFloat("rate7"));
					perTaxes.setMin7(rs.getFloat("min7"));
					perTaxes.setMax7(rs.getFloat("max7"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return perTaxes;
	}
	@Override
	public List<Att> queryAllAtt(int uid) {
		//��ѯԱ�����е�ǩ����¼
		List<Att> list = new ArrayList<>();
		String sql = "select * from attendance where uid="+uid;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Att att= new Att();
					att.setAid(rs.getInt("aid"));
					att.setUid(rs.getInt("uid"));
					att.setAdate(rs.getString("adate"));
					att.setAtype(rs.getString("atype"));
					att.setSignday(rs.getInt("signday"));
					att.setWorkday(rs.getInt("workday"));
					att.setAbsday(rs.getInt("absday"));
					att.setLateday(rs.getInt("lateday"));
					att.setLeaveday(rs.getInt("leaveday"));
					att.setAtext(rs.getString("atext"));
					att.setUname(rs.getString("uname"));
					list.add(att);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<WagePlan> queryAllWPlan(int uid) {
		//��ѯԱ�����еĹ��ʼ�¼��
		List<WagePlan> list = new ArrayList<>();
		String sql ="select * from wageplan where uid="+uid;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					WagePlan wagePlan = new WagePlan();
					wagePlan.setWpid(rs.getInt("wpid"));
					wagePlan.setUid(rs.getInt("uid"));
					wagePlan.setWid(rs.getInt("wid"));
					wagePlan.setBase(rs.getFloat("base"));
					wagePlan.setSub(rs.getFloat("sub"));
					wagePlan.setBonus(rs.getFloat("bonus"));
					wagePlan.setCar(rs.getFloat("car"));
					wagePlan.setHouse(rs.getFloat("house"));
					wagePlan.setAssbluckle(rs.getFloat("assbluckle"));
					wagePlan.setWork(rs.getFloat("work"));
					wagePlan.setPbluckle(rs.getFloat("pbluckle"));
					wagePlan.setMbluckle(rs.getFloat("mbluckle"));
					wagePlan.setHbluckle(rs.getFloat("hbluckle"));
					wagePlan.setAll(rs.getFloat("all"));
					wagePlan.setIncome(rs.getFloat("income"));
					wagePlan.setWage(rs.getFloat("wage"));
					wagePlan.setWdate(rs.getString("wdate"));
					list.add(wagePlan);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Staff queryStaff(int uid) {
		//��ѯԱ����¼����Ϣ��
		Staff staff = new Staff();
		String sql = "select * from staff where uid="+uid;
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					staff.setSid(rs.getInt("sid"));
					staff.setUid(rs.getInt("uid"));
					staff.setUname(rs.getString("uname"));
					staff.setSdate(rs.getString("sdate"));
					staff.setSedate(rs.getString("sedate"));
					staff.setStype(rs.getString("stype"));
					staff.setEd(rs.getString("ed"));
					staff.setEp(rs.getString("ep"));
					staff.setEm(rs.getString("em"));
					staff.setStext(rs.getString("stext"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return staff;
	}
	@Override
	public int addDepUser(depuser depuser) {
		// ��Ӳ���Ա����
		int i=0;
		String sql ="insert into depuser values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, depuser.getUid());
			ps.setString(2, depuser.getUname());
			ps.setInt(3, depuser.getDid());
			ps.setString(4, depuser.getDname());
			ps.setInt(5, depuser.getPid());
			ps.setString(6, depuser.getPname());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int addTsleave(Tsleave tsleave) {
		//���Ա������ύ
		int i = 0;
		String sql = "insert into tsleave values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tsleave.getLid());
			ps.setInt(2, tsleave.getUid());
			ps.setString(3, tsleave.getUname());
			ps.setString(4, tsleave.getDep());
			ps.setString(5, tsleave.getPos());
			ps.setInt(6, tsleave.getLnum());
			ps.setString(7, tsleave.getLreason());
			ps.setString(8, tsleave.getLstart());
			ps.setString(9, tsleave.getLend());
			ps.setString(10, tsleave.getLday());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public depuser queryDepUser(int uid) {
		//��ѯԱ���Ĳ�����Ϣ��
		depuser depuser = new depuser();
		String sql = "select * from depuser where uid="+uid;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					depuser.setUid(rs.getInt("uid"));
					depuser.setUname(rs.getString("uname"));
					depuser.setDid(rs.getInt("did"));
					depuser.setDname(rs.getString("dname"));
					depuser.setPid(rs.getInt("pid"));
					depuser.setPname(rs.getString("pname"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depuser;
	}
	@Override
	public int queryTsleave(int uid) {
		//��ѯ�Ƿ��Ѿ��ύ��ٵ�����ֹ�����ύ
		int row=0;
		String sql = "select count(*) from tsleave where uid="+uid;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				row = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	@Override
	public int addTstrip(Tstrip tstrip) {
		//���Ա�������ύ��
		int i = 0;
		String sql = "insert into tstrip values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tstrip.getTid());
			ps.setInt(2, tstrip.getUid());
			ps.setString(3, tstrip.getUname());
			ps.setString(4, tstrip.getDep());
			ps.setString(5, tstrip.getPos());
			ps.setInt(6, tstrip.getTnum());
			ps.setString(7, tstrip.getTreason());
			ps.setString(8, tstrip.getTplace());
			ps.setString(9, tstrip.getTstart());
			ps.setString(10, tstrip.getTend());
			ps.setString(11, tstrip.getTday());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int queryTstrip(int uid) {
		//��ѯ�Ƿ��ύ�������ֹ�����ύ
		int row=0;
		String sql = "select count(*) from tstrip where uid="+uid;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				row = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	@Override
	public List<User> queryUserAll(int uid ,int quid,String quname,String qdname,String qpname,int qleave,int qtrip ) {
		//ͨ��Ա����Ȩ�޲���Ա������
		//��һ�� ͨ��Ա����uid ��ѯ������Ӧ��uper(�û�Ȩ��)
		int uper=0;
		String sql1="select * from user where uid="+uid;
		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1!=null) {
				while(rs1.next()) {
					uper=rs1.getInt("uper");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ڶ��� �ж�Ա��Ȩ�ޣ���ѯ��Ӧ���û���Ϣ
		List<User> list = new ArrayList<>();
		String sql2="select * from user where uper<="+uper+" ";
		
		if (quid!=0) {
			sql2 = sql2 +" and uid="+ quid+" ";
		}
		if (quname!=null&&!quname.equals("")) {
			sql2 = sql2 +" and uname like '%"+quname+"%' ";
		}
		
		try {
			PreparedStatement ps2 = con.prepareStatement(sql2);
			//������ѯ
			
			ResultSet rs2 = ps2.executeQuery();
			if(rs2!=null) {
				while(rs2.next()) {
					User user = new User();
					user.setUid(rs2.getInt("uid"));
					user.setUname(rs2.getString("uname"));
					user.setUtype(rs2.getString("utype"));
					user.setUper(rs2.getInt("uper"));
					user.setAdd(rs2.getString("add"));
					user.setPhone(rs2.getString("phone"));
					user.setEmail(rs2.getString("email"));
					if(qtrip == 1) {
						if(queryTstrip(user.getUid())!=1) {
							continue;
						}
					}else if(qtrip ==2){
						if(queryTstrip(user.getUid())==1) {
							continue;
						}
					}else {
						
					}
					
					if(qleave == 1) {
						if(queryTsleave(user.getUid())!=1) {
							continue;
						}
					}else if(qleave ==2){
						if(queryTsleave(user.getUid())==1) {
							continue;
						}
					}else {
						
					}
					
					//������ ��ѯԱ�����ű�
					String sql3 = "select * from depuser where uid="+user.getUid()+" ";
					if(!qdname.equals("������")) {
						sql3 = sql3+" and dname like '"+qdname+"'";
					}
					if(!qpname.equals("������")) {
						sql3 = sql3+" and pname like '"+qpname+"'";
					}
					
					PreparedStatement ps3 = con.prepareStatement(sql3);
					ResultSet rs3 = ps3.executeQuery();
					if(rs3!=null) {
						while(rs3.next()) {
							depuser depuser = new depuser();
							depuser.setDname(rs3.getString("dname"));
							depuser.setPname(rs3.getString("pname"));
							user.setDepuser(depuser);
							list.add(user);
						}
					}
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int addTrip(int triptableuid,int uid) {
		//ͨ���û���ID����ӳ�����Ϣ�������
		Date date=new Date();
		String nowtime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		
		User user = new User();
		user = query(uid);//��ѯ������Ա������
		
		Tstrip tstrip = new Tstrip();
		tstrip = queryTsTripONE(triptableuid);
		int i=0;
		String sql = "insert into trip values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tstrip.getTid());
			ps.setInt(2, tstrip.getUid());
			ps.setString(3, tstrip.getUname());
			ps.setString(4, tstrip.getDep());
			ps.setString(5, tstrip.getPos());
			ps.setInt(6, tstrip.getTnum());
			ps.setString(7, tstrip.getTreason());
			ps.setString(8, tstrip.getTplace());
			ps.setString(9, tstrip.getTstart());
			ps.setString(10, tstrip.getTend());
			ps.setString(11, nowtime);
			ps.setString(12, user.getUname());
			ps.setString(13, tstrip.getTday());
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	@Override
	public List<Tstrip> queryTsTrip(int uid) {
		//ͨ��Ա��id��ѯ��Ӧ��Ȩ�������������Լ����ŵĳ�����Ϣ
		//��ѯ�û���Ȩ��
		String sql1="select * from user where uid="+uid;
		int uper=0;
		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1!=null) {
				while(rs1.next()) {
					uper=rs1.getInt("uper");
				}
			}
		} catch (SQLException e) {
			 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ж�Ȩ�����Լ����µ��û� ��ѯ���ĳ����
		List<Tstrip> list = new ArrayList<>();
		String sql2 ="select * from user where uper<="+uper+" ";
		try {
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			User user = new User();
			if(rs2!=null) {
				while(rs2.next()) {
					user.setUid(rs2.getInt("uid"));
					
					
					
					//��ѯԱ����ts���Ƿ����
					String sql3 = "select * from tstrip where uid="+user.getUid();
					PreparedStatement ps3 = con.prepareStatement(sql3);
					ResultSet rs3 = ps3.executeQuery();
					if(rs3!=null) {
						while(rs3.next()) {
							Tstrip tstrip = new Tstrip();
							tstrip.setTid(rs3.getInt("tid"));
							tstrip.setUid(rs3.getInt("uid"));
							tstrip.setUname(rs3.getString("uname"));
							tstrip.setDep(rs3.getString("dep"));
							tstrip.setPos(rs3.getString("pos"));
							tstrip.setTnum(rs3.getInt("tnum"));
							tstrip.setTreason(rs3.getString("treason"));
							tstrip.setTplace(rs3.getString("tplace"));
							tstrip.setTstart(rs3.getString("tstart"));
							tstrip.setTend(rs3.getString("tend"));
							tstrip.setTday(rs3.getString("tday"));
							
							list.add(tstrip);
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int delTsTrip(int uid) {
		//����Ա��IDɾ��Ա���ĳ��������;
		String sql = "delete from tstrip where uid="+uid;
		int i=0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 1;
	}
	@Override
	public Tstrip queryTsTripONE(int uid) {
		//��ѯĳԱ���������Ϣ
		String sql = "select * from tstrip where uid="+uid;
		Tstrip tstrip = new Tstrip();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					tstrip.setTid(rs.getInt("tid"));
					tstrip.setUid(rs.getInt("uid"));
					tstrip.setUname(rs.getString("uname"));
					tstrip.setDep(rs.getString("dep"));
					tstrip.setPos(rs.getString("pos"));
					tstrip.setTnum(rs.getInt("tnum"));
					tstrip.setTreason(rs.getString("treason"));
					tstrip.setTplace(rs.getString("tplace"));
					tstrip.setTstart(rs.getString("tstart"));
					tstrip.setTend(rs.getString("tend"));
					tstrip.setTday(rs.getString("tday"));
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tstrip;
	}
	@Override
	public List<Tsleave> queryTsLeave(int uid) {
		//��ȥԱ��Ȩ�޲�ѯȨ�������������Լ����ŵ������Ϣ
		//��ѯ�û�Ȩ��
		String sql1 = "select * from user where uid="+uid;
		int uper=0;
		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs1= ps1.executeQuery();
			if(rs1!=null) {
				while(rs1.next()) {
					uper=rs1.getInt("uper");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ж�Ȩ�����������µ��û�����ѯ������ٱ�
		List<Tsleave> list = new ArrayList<>();
		String sql2 = "select * from user where uper<="+uper+" ";
		try {
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			User user = new User();
			if(rs2!=null) {
				while(rs2.next()) {
					user.setUid(rs2.getInt("uid"));
					
					//��ѯԱ����tsleave���Ƿ����
					String sql3 = "select * from tsleave where uid="+user.getUid();
					PreparedStatement ps3= con.prepareStatement(sql3);
					ResultSet rs3 = ps3.executeQuery();
					if(rs3!=null) {
						while(rs3.next()) {
							Tsleave tsleave = new Tsleave();
							
							tsleave.setLid(rs3.getInt("lid"));
							tsleave.setUid(rs3.getInt("uid"));
							tsleave.setUname(rs3.getString("uname"));
							tsleave.setDep(rs3.getString("dep"));
							tsleave.setPos(rs3.getString("pos"));
							tsleave.setLnum(rs3.getInt("lnum"));
							tsleave.setLreason(rs3.getString("lreason"));
							tsleave.setLstart(rs3.getString("lstart"));
							tsleave.setLend(rs3.getString("lend"));
							tsleave.setLday(rs3.getString("lday"));
							
							list.add(tsleave);
							
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int delTsLeave(int uid) {
		//����Ա��IDɾ��Ա������������;
		String sql = "delete from tsleave where uid="+uid;
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public Tsleave queryTsLeaveONE(int uid) {
		//��ѯĳԱ���������Ϣ
		String sql =  "select * from tsleave where uid="+uid;
		Tsleave tsleave = new Tsleave();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					tsleave.setLid(rs.getInt("lid"));
					tsleave.setUid(rs.getInt("uid"));
					tsleave.setUname(rs.getString("uname"));
					tsleave.setDep(rs.getString("dep"));
					tsleave.setPos(rs.getString("pos"));
					tsleave.setLnum(rs.getInt("lnum"));
					tsleave.setLreason(rs.getString("lreason"));
					tsleave.setLstart(rs.getString("lstart"));
					tsleave.setLend(rs.getString("lend"));
					tsleave.setLday(rs.getString("lday"));
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tsleave;
	}
	@Override
	public int addLeave(int leavetableuid, int uid) {
		//ͨ���û���ID����������Ϣ�������
		Date date=new Date();
		String nowtime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		
		User user = new User();
		user = query(uid);//��ѯ������Ա������
		
		Tsleave tsleave = new Tsleave();
		tsleave = queryTsLeaveONE(leavetableuid);
		int i=0;
		String sql = "insert into `leave` values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tsleave.getLid());
			ps.setInt(2, tsleave.getUid());
			ps.setString(3, tsleave.getUname());
			ps.setString(4, tsleave.getDep());
			ps.setString(5, tsleave.getPos());
			ps.setInt(6, tsleave.getLnum());
			ps.setString(7, tsleave.getLreason());
			ps.setString(8, tsleave.getLstart());
			ps.setString(9, tsleave.getLend());
			ps.setString(10, nowtime);
			ps.setString(11, user.getUname());
			ps.setString(12, tsleave.getLday());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	@Override
	public List<Leave> queryLeave(int uid) {
		//��ȥԱ��Ȩ�޲�ѯȨ�������������Լ����ŵ������Ϣ
		String sql1 = "select * from user where uid="+uid;
		int uper=0;
		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs1= ps1.executeQuery();
			if(rs1!=null) {
				while(rs1.next()) {
					uper=rs1.getInt("uper");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ж�Ȩ�����������µ��û�����ѯ������ٱ�
		List<Leave> list = new ArrayList<>();
		String sql2 = "select * from user where uper<="+uper+" ";
		try {
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			User user = new User();
			if(rs2!=null) {
				while(rs2.next()) {
					user.setUid(rs2.getInt("uid"));
					
					//��ѯԱ����tsleave���Ƿ����
					String sql3 = "select * from `leave` where uid="+user.getUid();
					PreparedStatement ps3= con.prepareStatement(sql3);
					ResultSet rs3 = ps3.executeQuery();
					if(rs3!=null) {
						while(rs3.next()) {
							Leave leave = new Leave();
							
							leave.setLid(rs3.getInt("lid"));
							leave.setUid(rs3.getInt("uid"));
							leave.setUname(rs3.getString("uname"));
							leave.setDep(rs3.getString("dep"));
							leave.setPos(rs3.getString("pos"));
							leave.setLnum(rs3.getInt("lnum"));
							leave.setLreason(rs3.getString("lreason"));
							leave.setApprovalday(rs3.getString("approvalday"));
							leave.setApprovalpos(rs3.getString("approvalpos"));
							leave.setLstart(rs3.getString("lstart"));
							leave.setLend(rs3.getString("lend"));
							leave.setLday(rs3.getString("lday"));
							
							list.add(leave);
							
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<Trip> queryTrip(int uid) {
		//����Ա����Ȩ�޲�ѯȨ�������������Լ����ŵĳ�����Ϣ
		String sql1 = "select * from user where uid="+uid;
		int uper=0;
		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs1= ps1.executeQuery();
			if(rs1!=null) {
				while(rs1.next()) {
					uper=rs1.getInt("uper");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ж�Ȩ�����������µ��û�����ѯ������ٱ�
		List<Trip> list = new ArrayList<>();
		String sql2 = "select * from user where uper<="+uper+" ";
		try {
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			User user = new User();
			if(rs2!=null) {
				while(rs2.next()) {
					user.setUid(rs2.getInt("uid"));
					
					//��ѯԱ����tsleave���Ƿ����
					String sql3 = "select * from trip where uid="+user.getUid();
					PreparedStatement ps3= con.prepareStatement(sql3);
					ResultSet rs3 = ps3.executeQuery();
					if(rs3!=null) {
						while(rs3.next()) {
							Trip trip = new Trip();
							
							trip.setTid(rs3.getInt("tid"));
							trip.setUid(rs3.getInt("uid"));
							trip.setUname(rs3.getString("uname"));
							trip.setDep(rs3.getString("dep"));
							trip.setPos(rs3.getString("pos"));
							trip.setTnum(rs3.getInt("tnum"));
							trip.setTplace(rs3.getString("tplace"));
							trip.setTreason(rs3.getString("treason"));
							trip.setApprovalday(rs3.getString("approvalday"));
							trip.setApprovalpos(rs3.getString("approvalpos"));
							trip.setTstart(rs3.getString("tstart"));
							trip.setTend(rs3.getString("tend"));
							trip.setTday(rs3.getString("tday"));
							
							list.add(trip);
							
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}