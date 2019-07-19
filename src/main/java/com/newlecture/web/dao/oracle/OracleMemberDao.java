package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

public class OracleMemberDao implements MemberDao {

	@Override
	public Member get(String id) throws ClassNotFoundException, SQLException {
		
		Member member = null;
		String sql = "select * from MEMBER where id =?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		
		
		if(rs.next()) {
			member = new Member();
			member.setId(rs.getString("id"));
			member.setPwd(rs.getString("pwd"));
			member.setName(rs.getString("name"));
		}
		
		return member;
	}
	
}
