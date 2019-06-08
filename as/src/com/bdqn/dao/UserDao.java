package com.bdqn.dao;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.bean.Ass;
import com.bdqn.bean.Att;
import com.bdqn.bean.Dayatt;
import com.bdqn.bean.Leave;
import com.bdqn.bean.PerTaxes;
import com.bdqn.bean.Staff;
import com.bdqn.bean.Trip;
import com.bdqn.bean.Tsleave;
import com.bdqn.bean.Tstrip;
import com.bdqn.bean.User;
import com.bdqn.bean.UserBase;
import com.bdqn.bean.Wage;
import com.bdqn.bean.WagePlan;
import com.bdqn.bean.depuser;

public interface UserDao {
	public int dl(int uid,String upwd);
	
	public User query(int uid);
	//登录,查询
	public int addF(User user);
	//用户第一次注册
	public int add(UserBase userBase);
	//用户第二次注册
	public int a(String a);
	//测试类
	public User queryUid(String uidcard);
	//通过身份证号码验证用户信息，并返回user表中所含有的信息，以便二次注册
	public int queryDid(String dname);
	//检索二次注册时应聘部门所对应的部门编码
	public int queryPid(String pname);
	//检索二次注册时应聘职务所对应的职务编码
	public int addStaff(Staff staff);
	//自动生成员工录用信息表
	public int addDayatt(int uid , String uname , int Timeint);
	//当员工签到时，自动生成每日签到表
	public int querySign(int uid,String uname);
	//查询员工签到时，是否已签到，判断签到时间是上午还是下午；
	public UserBase queryUserBase(int uid);
	//查询用户基本信息
	public int addDayattAw(int uid , String uname ,int Timeint);
	//员工签退是添加签退方法
	public int queryAw(int uid,String uname);
	//查询员工签退时，是否已签退，判断签退时间是上午还是下午；
	public Dayatt queryDayatt(int dayid,int uid);
	//查询dayatt表 返回一个dayatt对象 给生成dayatt使用
	public int addDayattNsign(int uid , String uname );
	//加班签到大打表
	public int queryNSign(int uid,String uname);
	//查询员工签到时，是否已签到，判断签到时间是否在加班时间内；
	public int addDayattNaw(int uid , String uname );
	//员工加班结束打卡
	public int queryNaw(int uid,String uname);
	//查询员工签退时，是否已签退；
	
	//考勤信息生成
	public List<User> queryUser();
	//便利用户信息表 返回所有用户信息，方便自动生成 更新签到 考勤表
	public int addAtt(int uid,int title);
	//当 title为1时 创建考勤表，为0时更新数据
	public Att queryAtt(int uid,int aid);
	//查询attendance表信息,返回一个att对象
	public int addAss(int uid);
	//创建考核表
	public Ass queryAss(int uid,int aid);
	//查询assessment表，返回一个Ass对象
	
	//通过获取员工录用信息表（ep） ，查询职务信息表中的工资等级（wid） ，获取工资标准表，进行工资计发的运算
	public String queryStaffEp(int uid);
	//获取员工的受聘职务
	public int queryPosWid(String ep);
	//获取员工工资等级
	public Wage queryWage(int wid);
	//通过工资等级ID获取工资标准信息表信息，返回一个wage对象
	public int AddWagePlan(int uid);
	//自动生成工资计发信息表
	public PerTaxes queryPerTaxes();
	//查询个人所得税表
	
	//用户界面处理方法
	public List<Att> queryAllAtt(int uid);
	//查询员工所有的签到记录
	public List<WagePlan> queryAllWPlan(int uid);
	//查询员工所有的工资记录表
	public Staff queryStaff(int uid);
	//查询员工的录用信息表
	public int addDepUser(depuser depuser);
	//添加部门员工表
	
	//员工请假提交
	public int addTsleave(Tsleave tsleave);
	//添加员工请假提交
	public depuser queryDepUser(int uid);
	//查询员工的部门信息表
	public int queryTsleave(int uid);
	//查询是否已经提交请假单，防止二次提交
	public int queryTstrip(int uid);
	//查询是否提交出差单，防止二次提交
	public int addTstrip(Tstrip tstrip);
	//添加员工出差提交表
	
	//查询员工数据
	public List<User> queryUserAll(int uid,int quid,String quname,String qdname,String qpname,int qleave,int qtrip );
	//通过员工的权限查找员工数据
	
	//用户判断是否给予请假和出差
	public int addTrip(int triptableuid,int uid);
	//通过用户的ID来添加出差信息到出差表
	public List<Tstrip> queryTsTrip(int uid);
	//通过员工id查询相应的权限以下且属于自己部门的请假信息
	public int delTsTrip(int uid);
	//根据员工ID删除员工的出差申请表;
	public Tstrip queryTsTripONE(int uid);
	//查询某员工的请假信息
	
	//用户请假信息
	public List<Tsleave> queryTsLeave(int uid);
	//跟去员工权限查询权限以下且属于自己部门的请假信息
	public int delTsLeave(int uid);
	//根据员工ID删除员工的请假申请表;
	public Tsleave queryTsLeaveONE(int uid);
	//查询某员工的请假信息
	public int addLeave(int leavetableuid,int uid);
	//通过用户的ID来添加请假信息到出差表
	
	//查看用户的请教表和出差表
	public List<Leave> queryLeave(int uid);
	//根据员工权限查询权限以下且属于自己部门的请假信息
	public List<Trip> queryTrip(int uid);
	//根据员工的权限查询权限以下且属于自己部门的出差信息
}
