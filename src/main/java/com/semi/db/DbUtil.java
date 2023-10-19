package com.semi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//드라이버 로딩과 db연결을 하는 클래스
public class DbUtil {
	/* static 초기화 블럭 - 해당 클래스가 메모리에 로딩될 때 static변수가 초기화되고, 
	   static초기화 블럭이 딱 한번 호출된다. */
	static {
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}//static초기화 블럭
	
	//오버로딩 메서드 활용(중복안되게끔)
	public static Connection getConnection(String url, String user, String upwd)
			throws SQLException {
		//2. db연결
		Connection con=DriverManager.getConnection(url, user, upwd);
		System.out.println("db연결, con="+con);
		return con;
	}
	
	public static Connection getConnection(String user, String upwd)
			throws SQLException {
		String url="jdbc:oracle:thin:@59.6.102.18:1521:xe";
		Connection con=getConnection(url, user, upwd); //25번째줄의 getConnection 메서드 호출
		return con;
	}
	
	public static Connection getConnection() throws SQLException {
		String url="jdbc:oracle:thin:@59.6.102.18:1521:xe";
		String user="semi", upwd="semi123";
		Connection con=getConnection(url, user, upwd);
		return con;
	}
		
	//5. 자원반납
	public static void dbClose(ResultSet rs, PreparedStatement ps, Connection con) 
			throws SQLException {
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(con!=null) con.close();
	}
	
	public static void dbClose(PreparedStatement ps, Connection con)
			throws SQLException {
		if(ps!=null) ps.close();
		if(con!=null) con.close();
	}
	//preparedStatement 이 CallableStatement 의 부모기 때문에 다형성 이용하여 메서드 사용가능
	
}
