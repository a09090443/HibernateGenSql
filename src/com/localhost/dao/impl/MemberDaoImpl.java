package com.localhost.dao.impl;

import com.localhost.base.dao.impl.BaseDaoImpl;
import com.localhost.dao.IMemberDao;
import com.localhost.model.Member;

public class MemberDaoImpl extends BaseDaoImpl<Member> implements IMemberDao {

	public MemberDaoImpl() {
		this.setClazz(Member.class);
	}

}
