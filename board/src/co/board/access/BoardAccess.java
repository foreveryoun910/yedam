package co.board.access;

import java.util.ArrayList;

import co.board.model.Board;

public interface BoardAccess {

	//1.전체리스트	
	public ArrayList<Board> findAllPost();
	
	//2.게시글 등록
	public void createPost(Board board);
	
	//3.게시글 수정: 글번호->수정
	public void updatePost(Board board);
	
	//4.게시글 삭제: 글번호->삭제
	public void deletePost(int b_id);
	
	//5.게시글 조회(상세보기)->작성자 이름으로 게시글 조회하기
	public ArrayList<Board> findPost(String b_writer);
	
	public Board findIdPost(int b_id);
	
}
