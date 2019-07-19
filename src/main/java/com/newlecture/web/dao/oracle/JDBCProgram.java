package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

public class JDBCProgram {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		 DriverManager;
//		 Connection;
//		 Statement;
//		 ResultSet;
/*		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		String sc;
		Scanner scan = new Scanner(System.in);
		System.out.print("idÀÔ·Â>");
		sc = scan.nextLine();
		String sql = "SELECT * FROM MEMBER WHERE ID LIKE\'%"+sc+"%\'";

		Class.forName("oracle.jdbc.driver.OracleDriver"); // DriverManager
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");// Connection
		Statement st = con.createStatement();// Statement
		ResultSet rs = st.executeQuery(sql);// ResultSet

		while (rs.next()) {
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");

				System.out.printf("ID:%s PWD:%s NAME:%s\n", id, pwd, name);
		}

		rs.close();
		st.close();
		con.close();
*/
		NoticeDao a = new OracleNoticeDao(); 
		
		
		System.out.println(a.getLastId());
	}

}
