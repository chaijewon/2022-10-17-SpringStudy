package com.sist.aop;
import java.util.*;
import java.sql.*;
public class MainClass {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		
		String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
		String user = "root";
		String password = "happy";
		String driverName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			String sql="SELECT * FROM member";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "
						+rs.getString(2)+" "
						+rs.getString(3));
			}
			rs.close();
		} catch (ClassNotFoundException e) {
			// `com.mysql.cj.jdbc.Driver` 라는 클래스가 라이브러리로 추가되지 않았다면 오류발생
			System.out.println("[로드 오류]\n" + e.getStackTrace());
		} catch (SQLException e) {
			// DB접속정보가 틀렸다면 오류발생
			System.out.println("[연결 오류]\n" + e.getStackTrace());
		}
	}

}
