package co.board.view;

import java.util.ArrayList;
import java.util.Scanner;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.model.Board;
import co.board.util.ScannerUtil;

/*
 * 메뉴를 보여주는 인터페이스 화면
 */
public class BoardApp {
	BoardAccess boardList = new BoardDAO();
	Scanner scan = new Scanner(System.in);

	public void start() {
		int menunum;
		do {
			//메뉴출력
			menuTitle();
			
			//메뉴선택
			menunum = ScannerUtil.readInt("선택");
			
			//실행
			switch(menunum) {
			case 1: findAllPost(); break;
			case 2: createPost(); break;
			case 3: updatePost(); break;
			case 4: deletePost(); break;
			case 5: findPost(); break;
			case 6: inputComment(); break;
			}
			
		} while(menunum != 0);
	}
	
	
	public void menuTitle() {
		System.out.println("============================================================================");
		System.out.println(" 1.전체글 조회 | 2.글 등록 | 3.글 수정 | 4.글 삭제 | 5.글 선택조회 | 6.댓글 등록 | 0.종료");
		System.out.println("============================================================================");
	}
	
	
	//1.전체리스트	
	public void findAllPost() {
		ArrayList<Board> list = boardList.findAllPost();
		for(Board board : list) {
			System.out.println(board);
		}
		
		
		//if b_comment가 null이 아니면 b_id = b_parentId인 comment 출력하고 null이면 공백 출력
	}
	
	//2.게시글 등록
	public void createPost() {
		Board board = new Board();
		board.setB_title(ScannerUtil.readStr("제목 입력")); //String b_title = ScannerUtil.readStr("제목 입력");
		board.setB_content(ScannerUtil.readStr("내용 입력")); //String b_content = ScannerUtil.readStr("내용 입력");
		board.setB_writer(ScannerUtil.readStr("작성자 입력")); //String b_writer = ScannerUtil.readStr("작성자 입력");
		//Board board = new Board(b_title, b_content, b_writer);
		boardList.createPost(board);
	}
	
	//3.게시글 수정: 글번호->수정
	public void updatePost() {
		ArrayList<Board> list = boardList.findAllPost();
		Board board = new Board();
		System.out.print("조회할 글의 번호> ");
		int b_id = scan.nextInt();
		scan.nextLine();
		
//		if(! list.contains(b_id)) {
//			System.out.println("해당 번호는 존재하지 않습니다");
//		}
		
		board.setB_id(b_id);
//		board.setB_id(ScannerUtil.readInt("조회할 글의 번호"));
		board.setB_title(ScannerUtil.readStr("변경할 제목"));
		board.setB_content(ScannerUtil.readStr("변경할 내용"));
		System.out.println("게시글이 등록되었습니다.");
		boardList.updatePost(board);
		
	}
	
	//4.게시글 삭제: 글번호->삭제
	public void deletePost() {
		int b_id = ScannerUtil.readInt("삭제할 글의 번호");
		boardList.deletePost(b_id);
	}
	
	//5.게시글 조회(상세보기)->작성자 이름으로 게시글 조회하기
	public void findPost() {
		String b_writer = ScannerUtil.readStr("작성자 검색");
		ArrayList<Board> boards = boardList.findPost(b_writer);
		System.out.println(boards);
	}
	

	//6.댓글달기: parent_id를 조회해서???나오는 댓글들을 다 출력???
	//가닥 잡히면 Access랑 DAO에 추가하는 것 까먹지 말기
	public void inputComment() {
		Board board = new Board();
		board.setB_parent_id(ScannerUtil.readInt("댓글 달 글번호"));
		//int b_id = ScannerUtil.readInt("댓글 달 글번호");
		board.setB_comment(ScannerUtil.readStr("댓글 입력")); //String b_comment = ScannerUtil.readStr("댓글 입력");
		//board.setB_parent_id(b_id);
		//System.out.println(board + "\n" + "└─댓글: " + board.getB_comment());
		boardList.inputComment(board);
		System.out.println("입력한 댓글: " + board.getB_comment());
		
		
	}
	
	
	
}
