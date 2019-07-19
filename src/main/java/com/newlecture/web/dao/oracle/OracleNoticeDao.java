package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

//@Repository
public class OracleNoticeDao implements NoticeDao{

	@Override
	public List<NoticeView> getList() throws ClassNotFoundException, SQLException {
		return getList(1,"title","");
	}

	@Override
	public List<NoticeView> getList(int page) throws ClassNotFoundException, SQLException {
		return getList(page,"title","");
	}

	@Override
	public List<NoticeView> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<NoticeView> list = new ArrayList<>();
		
		int start =1+(page-1)*10;//1,11,21,31,41
		int end = page*10;//10,20,30,40,50
		
		String sql = "SELECT * FROM NOTICE_VIEW" + 
				" WHERE "+field+ " LIKE ? AND NUM BETWEEN ? AND ?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");//->'%A%'
		st.setInt(2, start);
		st.setInt(3, end);
		
		//con.setAutoCommit(false);
		
		ResultSet rs = st.executeQuery();
		
		//con.commit();
		
		while (rs.next()) {
				NoticeView notice = new NoticeView(
						rs.getInt("id"),
						rs.getString("title"),
						"",
						rs.getString("writer_id"),
						rs.getDate("regdate"),
						rs.getInt("hit"),
						rs.getInt("comment_Count")
						);
				
				list.add(notice);
		}
		

		
		
		
		rs.close();
		st.close();
		con.close();
		return list;
	}

	@Override
	public Notice get(int id) {
		// TODO Auto-generated method stub
		Notice notice = null;
		//String sql = String.format("select * from notice where id= %d", id);
		String sql = "select * from notice where id="+id;
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");// Connection
			Statement st = con.createStatement();// Statement
			ResultSet rs = st.executeQuery(sql);// ResultSet
			
			if (rs.next()) {
				notice = new Notice(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getString("writer_id"),rs.getDate("regdate"),rs.getInt("hit"));
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // DriverManager
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	@Override
	public Notice getPrev(int id) {
		// TODO Auto-generated method stub
		Notice notice = null;
		//SELECT * FROM (SELECT*FROM NOTICE_VIEW ORDER BY REGDATE DESC)WHERE REGDATE<(SELECT REGDATE FROM NOTICE WHERE ID=14)AND ROWNUM=1;
		String sql="SELECT * FROM NOTICE_VIEW WHERE REGDATE<(SELECT REGDATE FROM NOTICE WHERE ID="+id+")AND ROWNUM =1";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");// Connection
			Statement st = con.createStatement();// Statement
			ResultSet rs = st.executeQuery(sql);// ResultSet
			
			if (rs.next()) {
				notice = new Notice(rs.getInt("id"), rs.getString("title"),"",
						rs.getString("writer_id"),rs.getDate("regdate"),rs.getInt("hit"));
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // DriverManager
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}
	

	@Override
	public Notice getNext(int id) {
		// TODO Auto-generated method stub
		Notice notice = null;
		
		String sql="SELECT * FROM(SELECT * FROM NOTICE_VIEW ORDER BY REGDATE) WHERE REGDATE>(SELECT REGDATE FROM NOTICE WHERE ID="+id+") AND ROWNUM =1";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");// Connection
			Statement st = con.createStatement();// Statement
			ResultSet rs = st.executeQuery(sql);// ResultSet
			
			if (rs.next()) {
				notice = new Notice(rs.getInt("id"), rs.getString("title"),"",
						rs.getString("writer_id"),rs.getDate("regdate"),rs.getInt("hit"));
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // DriverManager
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}
	

	@Override
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "insert into notice(id,title,content,writer_id)"+"values(notice_seq.nextval,?,?,'jjh')";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		
		PreparedStatement st = con.prepareStatement(sql);//sql실행해주는 애, 미리셋팅
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "delete notice where id=?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		
		PreparedStatement st = con.prepareStatement(sql);//sql실행해주는 애, 미리셋팅
		st.setInt(1, id);
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		int id = notice.getId();
		String sql = "update notice set title=?, content=? where id ="+id;
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		//st.setInt(3, notice.getId());
		
		result = st.executeUpdate();

		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int getLastId() throws ClassNotFoundException, SQLException {
		int id = -1;
		String sql ="select * from (select * from notice order by regdate desc) where rownum = 1";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");// Connection
		Statement st = con.createStatement();// Statement
		ResultSet rs = st.executeQuery(sql);// ResultSet
		if(rs.next())
			id = rs.getInt("id");
		
		rs.close();
		st.close();
		con.close();
		
		return id;
	}

	@Override
	public int getCount() throws ClassNotFoundException, SQLException {
		
		return getCount("title","");
	}

	@Override
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException {
		String sql = "SELECT count(*) count FROM NOTICE_VIEW" + 
				" WHERE "+field+ " LIKE ?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");//->'%A%'
	
		ResultSet rs = st.executeQuery();
		int count = 0;
		
		if(rs.next())
			count = rs.getInt("count");
		
		return count;
	}

}
