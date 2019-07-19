package com.newlecture.web.dao;

import java.sql.SQLException;

import com.newlecture.web.dao.oracle.OracleMemberDao;
import com.newlecture.web.entity.Member;

public class TestProgram123 {

	public static void main(String[] args) {
		MemberDao memberDao = new OracleMemberDao();
		
		try {
			Member member = memberDao.get("312a");
			System.out.println(member.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
