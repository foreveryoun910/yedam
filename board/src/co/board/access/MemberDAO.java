package co.board.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.board.model.Member;


/*
 * MemberDAO 클래스를 만들고
 * id, password가 동일한지 확인하는 메소드 만들고
 * 확인메소드를 활용해서 둘 다 동일하면 로그인 성공
 */
public class MemberDAO {

	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;
	String sql;
	

	
	

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
	
	//connect닫는메소드
	public static void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //end of if

		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //end of if
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}// end of if
	} //end of close
	
	
}
