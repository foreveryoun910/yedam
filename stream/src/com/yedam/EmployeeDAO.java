package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {

	//필드 선언
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;
	String sql;
	
	
	//전체리스트 조회
	public ArrayList<Employee> getEmployeeList() {
		connect();
		ArrayList<Employee> employeeList = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement("select employeeId, lastName, firstName, title, birthDate from employees");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employeeId"));
				emp.setLastName(rs.getString("lastName"));
				emp.setFirstName(rs.getString("firstName"));
				emp.setTitle(rs.getString("title"));
				emp.setBirthDate(rs.getString("birthDate"));
				
				employeeList.add(emp);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return employeeList;
	}
	
	
	
	//연결메소드
	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	//닫는메소드
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
