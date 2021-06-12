package co.board.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.board.model.Board;
import co.board.model.Member;

/*
 * 구현클래스
 */
public class BoardDAO implements BoardAccess {

	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;
	String sql;
	ArrayList<Board> boardList;
	Board board;
	int count = 0;		//로그인 확인용 카운트
	
	
	//1.전체리스트	
	@Override
	public ArrayList<Board> findAllPost() {
		connect();
		boardList = new ArrayList<Board>();
		
		try {
			psmt = conn.prepareStatement("select * from board where b_parent_id is null");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setB_id(rs.getInt("b_id"));
				board.setB_title(rs.getString("b_title"));
//				board.setB_content(rs.getString("b_content"));
				board.setB_writer(rs.getString("b_writer"));
				
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
	
		return boardList;
	}
	
	
	//2.게시글 등록
	@Override
	public void createPost(Board board) {
		connect();
		
		try {
			psmt = conn.prepareStatement("insert into board(b_title, b_content, b_writer) values(?, ?, ?)");
			psmt.setString(1, board.getB_title());
			psmt.setString(2, board.getB_content());
			psmt.setString(3, board.getB_writer());
			int r = psmt.executeUpdate();
			System.out.println("게시글 " + r + "건이 등록되었습니다.");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
	}
	
	
	//3.게시글 수정: 글번호->수정
	@Override
	public void updatePost(Board board) {
		connect();
		
		try {
			psmt = conn.prepareStatement("update board set b_title=?, b_content=? where b_id=?");
			psmt.setString(1, board.getB_title());
			psmt.setString(2, board.getB_content());
			psmt.setInt(3, board.getB_id());
			int r = psmt.executeUpdate();
			System.out.println("게시글 " + r + "건이 수정되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
		
	}
	
	
	//4.게시글 삭제: 글번호->삭제
	@Override
	public void deletePost(int b_id) {
		connect();
		try {
			psmt = conn.prepareStatement("delete from board where b_id=?");
			psmt.setInt(1, b_id);
			int r = psmt.executeUpdate();
			System.out.println("게시글 " + r + "건이 삭제되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
		
	}
	
	
	//5.게시글 조회(상세보기)->작성자 이름으로 게시글 조회하기
	@Override
	public ArrayList<Board> findPost(String b_writer) {
		connect();
		boardList = new ArrayList<Board>();
		
		try {
			psmt = conn.prepareStatement("select * from board where b_writer=?");
			psmt.setString(1, b_writer);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setB_id(rs.getInt("b_id"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setB_writer(rs.getString("b_writer"));
				
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
	
		return boardList;
	}
	
	
	//5-1.게시글 조회(글번호로 게시글 조회)
	@Override
	public ArrayList<Board> findIdPost(int b_id) {
		connect();
		boardList = new ArrayList<Board>();
		
		try {
			psmt = conn.prepareStatement("select * from board where b_id=?");
			psmt.setInt(1, b_id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setB_id(rs.getInt("b_id"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setB_writer(rs.getString("b_writer"));
				
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
	
		return boardList;
	}
	
	
	
	
	
	//댓글등록
	
	//insert into board(b_title, b_content, b_writer, b_parent_id) values('제목', '댓글을달아보자', '작성자', (select b_id from board where b_id=?));
	public Board inputComment(Board board) {
		connect();
		try {
			psmt = conn.prepareStatement("insert into board(b_title, b_content, b_writer, b_parent_id) values('제목', ?, '작성자', (select b_id from board where b_id=?))");
			psmt.setString(1, board.getB_content());
			psmt.setInt(2, board.getB_parent_id());
			int r = psmt.executeUpdate();
			System.out.println(r + "건의 댓글이 작성되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
		return board;
	}
	

	//댓글출력
	public ArrayList<Board> printComment(int b_parent_id) {
		
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		boardList = new ArrayList<Board>();
		try {
			psmt = conn.prepareStatement("select * from board where b_parent_id=?");
			psmt.setInt(1, b_parent_id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setB_parent_id(rs.getInt("b_parent_id"));
				board.setB_content(rs.getString("b_content"));
				board.setB_id(rs.getInt("b_id"));
				board.setB_title(rs.getString("b_title"));
				board.setB_writer(rs.getString("b_writer"));
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		
		return boardList;	
	}
	
	
	
	
	//로그인
	@Override
	public void login(Member member) {
		connect();

		try {
			psmt = conn.prepareStatement("select * from member where u_id=? and u_pass=?");
			psmt.setString(1, member.getU_id());
			psmt.setString(2, member.getU_pass());
			rs = psmt.executeQuery();
			
				if(rs.next()) {
					count = count++;
				}				
			
		} catch (SQLException e) {
			
			//
			e.printStackTrace();
		} finally {close();}
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
