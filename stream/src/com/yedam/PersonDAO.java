package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDAO {

	//필드 선언
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	//전체리스트
	public ArrayList<Person> getPersonList() {
		ArrayList<Person> personList = new ArrayList<>(); // personList라는 이름의 배열 생성(아직 비었음)
		connect(); // Connection 연결객체 ( 중 요 )
		String sql = "select * from person";
		try {
			psmt = conn.prepareStatement(sql); // psmt: sql을 실행하고 결과를 담아오기 위한 기능, 연결하고나서 Connection 객체가 가지고 있는
												// PreparedStatement 쿼리를 생성해줘야 함
			rs = psmt.executeQuery(); // 쿼리의 실행결과를 가져오는 부분
			while (rs.next()) {
				// System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
				Person person = new Person(); // 데이터베이스에서 가져온 값을 Person에 담기 위해서
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));

				personList.add(person); // personList에 person의 내용을 담는 것
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return personList;
	}
	
	
	
	//연결메소드
		public static void connect() {
			String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
			try {
				conn = DriverManager.getConnection(url);
				System.out.println("연결성공!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static void close() {
			// connect 닫히는 함수
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // end of if

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // end of if
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // end of if
		}
	
}
