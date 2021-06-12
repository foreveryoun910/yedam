package co.board.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
	

	//id확인 메소드
	public boolean idEqual(String id) {
		connect();
		boolean result = false;
		try {
			//입력한 u_id와 동일한 u_id가 있으면 조회
			psmt = conn.prepareStatement("select u_id from member where u_id=?");
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = true;
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return false;
	}
	
	//password확인 메소드
	public boolean passEqual(String password) {
		connect();
		boolean result = false;
		try {
			psmt = conn.prepareStatement("select u_pass from member where u_pass=?");
			psmt.setString(1, password);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = true;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return result;
	}
	
	
	//login 메소드: idEqual && passEqual == 로그인 성공
	public boolean login(String id, String password) {
		boolean result;
		
		if(idEqual(id)) {
			if(passEqual(password)) {
				System.out.println("로그인 성공!");
				result = true;
			}
			else {
				System.out.println("비밀번호가 틀렸습니다.");
				result = false;
			}
		}
		else {
			System.out.println("존재하지 않는 아이디입니다.");
			result = false;
		}
		
		return result;
	}
	

	//연결메소드
	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
//			System.out.println("연결성공!");
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
