package com.bdqn.dao;

public interface LimitDao {
	public boolean LimitUidcard(String uidcard);
	//1.���Ƶ�һ�ε�½ʱ�����֤��飬�����֤��Ϣ�Ѵ����򷵻ش�����Ϣ��
	public boolean LimitPhone(String phone);
	//2.���Ƶ�һ�ε�½ʱ���ֻ��ż�飬���ֻ���Ϣ�Ѵ����򷵻ش�����Ϣ��
}
