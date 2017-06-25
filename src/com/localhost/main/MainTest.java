package com.localhost.main;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.Table;

import com.localhost.VO.OptionsVO;
import com.localhost.dao.IMemberDao;
import com.localhost.dao.impl.MemberDaoImpl;
import com.localhost.model.Member;
import com.localhost.utils.OptionsUtil;

public class MainTest {

	public static void main(String[] args) throws Exception {
		OptionsUtil util = new OptionsUtil();
		OptionsVO optionsVO = util.converToObject(args);
		
		IMemberDao menberDao = new MemberDaoImpl();
		List<Member> memberList = menberDao.findAll();
		for(Member member:memberList){
		}
		System.out.println(memberList.size());
	}
}