package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.entity.NoticeFile;

public class OracleNoticeFileDao implements NoticeFileDao {

	@Override
	public List<NoticeFile> getListByNoticeId(int noticeId) throws ClassNotFoundException, SQLException {
		List<NoticeFile> list = new ArrayList<>();
		
		String sql = "SELECT * FROM NOTICE_file WHERE notice_id=?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, noticeId);//->'%A%'
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
				NoticeFile notice = new NoticeFile(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("notice_id")
						);	
				list.add(notice);
		}
		
		rs.close();
		st.close();
		con.close();
		return list;
	}

	@Override
	public int insert(NoticeFile noticeFile) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "insert into notice_file(id,name,notice_id)"+"values(notice_file_seq.nextval,?,?)";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		
		PreparedStatement st = con.prepareStatement(sql);//sql실행해주는 애, 미리셋팅
		st.setString(1, noticeFile.getName());
		st.setInt(2, noticeFile.getNoticeId());
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int update(NoticeFile noticeFile) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "update notice_file set title=?, content=? where id =?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeFile.getName());
		st.setInt(2, noticeFile.getNoticeId());
		st.setInt(3, noticeFile.getId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "delete notice_file where id=?";
		
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

}
