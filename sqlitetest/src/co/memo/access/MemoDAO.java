package co.memo.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.memo.model.Memo;

// MemoAccess를 구현하는 클래스입니다.
// 기능을 작성하세요.
public class MemoDAO implements MemoAccess {

	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;
	String sql;
	ArrayList<Memo> memoList;
	Memo memo;
	
	
	

	@Override
	public void insert(String date, String title, String content) {
		connect();
		try {
			psmt = conn.prepareStatement("insert into memo(date, title, content) values(?, ?, ?)");
			psmt.setString(1, date);
			psmt.setString(2, title);
			psmt.setString(3, content);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 등록하였습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
	}

	
	//제목을 입력받아서 내용을 변경
	@Override
	public void update(Memo memo) {
		connect();
		try {
			psmt = conn.prepareStatement("update memo set content=? where title=?");
			psmt.setString(1, memo.getContent());
			psmt.setString(2, memo.getTitle());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경하였습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
	}

	
	//제목을 입력받아서 삭제
	@Override
	public void delete(String title) {
		connect();
		try {
			psmt = conn.prepareStatement("delete from memo where title=?");
			psmt.setString(1, title);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제하였습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
	}

	
	@Override
	public ArrayList<Memo> findAll() {
		connect();
		ArrayList<Memo> memoList = new ArrayList<Memo>();
		try {
			psmt = conn.prepareStatement("select * from memo;");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				memo = new Memo();
				memo.setTitle(rs.getString("title"));
				memo.setDate(rs.getString("date"));
				memo.setContent(rs.getString("content"));
				
				memoList.add(memo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
		return memoList;
	}

	
	//날짜를 입력받아서 메모를 검색하기
	@Override
	public ArrayList<Memo> findByDate(String date) {
		connect();
		ArrayList<Memo> memoList = new ArrayList<Memo>();
		try {
			psmt = conn.prepareStatement("select * from memo where date=?");
			psmt.setString(1, date);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Memo memo = new Memo();
				memo.setDate(rs.getString("date"));
				memo.setTitle(rs.getString("title"));
				memo.setContent(rs.getString("content"));
				
				memoList.add(memo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
		return memoList;
		
	}

	
	//해당 내용을 포함하는 메모 검색하기
	@Override
	public ArrayList<Memo> findByContent(String content) {
		connect();
		ArrayList<Memo> memoList = new ArrayList<Memo>();
		try {
			psmt = conn.prepareStatement("select * from memo where content like ?");	//'%' + ? + '%'
			psmt.setString(1, "%" + content + "%");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Memo memo = new Memo();
				memo.setDate(rs.getString("date"));
				memo.setTitle(rs.getString("title"));
				memo.setContent(rs.getString("content"));
				
				memoList.add(memo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
		return memoList;
		
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
