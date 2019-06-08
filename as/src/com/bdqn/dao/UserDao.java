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
	//��¼,��ѯ
	public int addF(User user);
	//�û���һ��ע��
	public int add(UserBase userBase);
	//�û��ڶ���ע��
	public int a(String a);
	//������
	public User queryUid(String uidcard);
	//ͨ�����֤������֤�û���Ϣ��������user���������е���Ϣ���Ա����ע��
	public int queryDid(String dname);
	//��������ע��ʱӦƸ��������Ӧ�Ĳ��ű���
	public int queryPid(String pname);
	//��������ע��ʱӦƸְ������Ӧ��ְ�����
	public int addStaff(Staff staff);
	//�Զ�����Ա��¼����Ϣ��
	public int addDayatt(int uid , String uname , int Timeint);
	//��Ա��ǩ��ʱ���Զ�����ÿ��ǩ����
	public int querySign(int uid,String uname);
	//��ѯԱ��ǩ��ʱ���Ƿ���ǩ�����ж�ǩ��ʱ�������绹�����磻
	public UserBase queryUserBase(int uid);
	//��ѯ�û�������Ϣ
	public int addDayattAw(int uid , String uname ,int Timeint);
	//Ա��ǩ�������ǩ�˷���
	public int queryAw(int uid,String uname);
	//��ѯԱ��ǩ��ʱ���Ƿ���ǩ�ˣ��ж�ǩ��ʱ�������绹�����磻
	public Dayatt queryDayatt(int dayid,int uid);
	//��ѯdayatt�� ����һ��dayatt���� ������dayattʹ��
	public int addDayattNsign(int uid , String uname );
	//�Ӱ�ǩ������
	public int queryNSign(int uid,String uname);
	//��ѯԱ��ǩ��ʱ���Ƿ���ǩ�����ж�ǩ��ʱ���Ƿ��ڼӰ�ʱ���ڣ�
	public int addDayattNaw(int uid , String uname );
	//Ա���Ӱ������
	public int queryNaw(int uid,String uname);
	//��ѯԱ��ǩ��ʱ���Ƿ���ǩ�ˣ�
	
	//������Ϣ����
	public List<User> queryUser();
	//�����û���Ϣ�� ���������û���Ϣ�������Զ����� ����ǩ�� ���ڱ�
	public int addAtt(int uid,int title);
	//�� titleΪ1ʱ �������ڱ�Ϊ0ʱ��������
	public Att queryAtt(int uid,int aid);
	//��ѯattendance����Ϣ,����һ��att����
	public int addAss(int uid);
	//�������˱�
	public Ass queryAss(int uid,int aid);
	//��ѯassessment������һ��Ass����
	
	//ͨ����ȡԱ��¼����Ϣ��ep�� ����ѯְ����Ϣ���еĹ��ʵȼ���wid�� ����ȡ���ʱ�׼�����й��ʼƷ�������
	public String queryStaffEp(int uid);
	//��ȡԱ������Ƹְ��
	public int queryPosWid(String ep);
	//��ȡԱ�����ʵȼ�
	public Wage queryWage(int wid);
	//ͨ�����ʵȼ�ID��ȡ���ʱ�׼��Ϣ����Ϣ������һ��wage����
	public int AddWagePlan(int uid);
	//�Զ����ɹ��ʼƷ���Ϣ��
	public PerTaxes queryPerTaxes();
	//��ѯ��������˰��
	
	//�û����洦����
	public List<Att> queryAllAtt(int uid);
	//��ѯԱ�����е�ǩ����¼
	public List<WagePlan> queryAllWPlan(int uid);
	//��ѯԱ�����еĹ��ʼ�¼��
	public Staff queryStaff(int uid);
	//��ѯԱ����¼����Ϣ��
	public int addDepUser(depuser depuser);
	//��Ӳ���Ա����
	
	//Ա������ύ
	public int addTsleave(Tsleave tsleave);
	//���Ա������ύ
	public depuser queryDepUser(int uid);
	//��ѯԱ���Ĳ�����Ϣ��
	public int queryTsleave(int uid);
	//��ѯ�Ƿ��Ѿ��ύ��ٵ�����ֹ�����ύ
	public int queryTstrip(int uid);
	//��ѯ�Ƿ��ύ�������ֹ�����ύ
	public int addTstrip(Tstrip tstrip);
	//���Ա�������ύ��
	
	//��ѯԱ������
	public List<User> queryUserAll(int uid,int quid,String quname,String qdname,String qpname,int qleave,int qtrip );
	//ͨ��Ա����Ȩ�޲���Ա������
	
	//�û��ж��Ƿ������ٺͳ���
	public int addTrip(int triptableuid,int uid);
	//ͨ���û���ID����ӳ�����Ϣ�������
	public List<Tstrip> queryTsTrip(int uid);
	//ͨ��Ա��id��ѯ��Ӧ��Ȩ�������������Լ����ŵ������Ϣ
	public int delTsTrip(int uid);
	//����Ա��IDɾ��Ա���ĳ��������;
	public Tstrip queryTsTripONE(int uid);
	//��ѯĳԱ���������Ϣ
	
	//�û������Ϣ
	public List<Tsleave> queryTsLeave(int uid);
	//��ȥԱ��Ȩ�޲�ѯȨ�������������Լ����ŵ������Ϣ
	public int delTsLeave(int uid);
	//����Ա��IDɾ��Ա������������;
	public Tsleave queryTsLeaveONE(int uid);
	//��ѯĳԱ���������Ϣ
	public int addLeave(int leavetableuid,int uid);
	//ͨ���û���ID����������Ϣ�������
	
	//�鿴�û�����̱�ͳ����
	public List<Leave> queryLeave(int uid);
	//����Ա��Ȩ�޲�ѯȨ�������������Լ����ŵ������Ϣ
	public List<Trip> queryTrip(int uid);
	//����Ա����Ȩ�޲�ѯȨ�������������Լ����ŵĳ�����Ϣ
}
