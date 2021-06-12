package co.board.view;

import java.util.ArrayList;
import java.util.Scanner;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.model.Board;
import co.board.model.Member;
import co.board.util.ScannerUtil;

/*
 * 메뉴를 보여주는 인터페이스 화면
 */
public class BoardApp {
	BoardAccess boardList = new BoardDAO();
	Scanner scan = new Scanner(System.in);
	Board board;

	public void start() {
		
//		login();
		
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
			case 6: findIdPost(); break;
			case 7: inputComment(); break;
			}
			
		} while(menunum != 0);
	}
	
	
	public void menuTitle() {
		System.out.println("==================================================================================================");
		System.out.println("1.전체글 조회 | 2.글 등록 | 3.글 수정 | 4.글 삭제 | 5.작성자로 글 찾기 | 6.글번호로 글 찾기 | 7.댓글 등록 | 0.종료");
		System.out.println("==================================================================================================");
	}
	
	
	//1.전체리스트	
	public void findAllPost() {
		ArrayList<Board> list = boardList.findAllPost();
		System.out.println("==================================================================");
		System.out.println("글번호" + "\t" + "\t" + "제목" + "\t" + "\t" + "\t" + "\t" + "작성자");
		System.out.println("------------------------------------------------------------------");
		for(Board b : list) {
			System.out.println(b);
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
		System.out.println("==================================================================");
		System.out.println("글번호" + "\t" + "\t" + "제목" + "\t" + "\t" + "\t" + "\t" + "작성자");
		System.out.println("------------------------------------------------------------------");
		for(Board b : boards) {
			System.out.printf(" %-15d %-30s %-10s\n\n\n %-10s\n\n\n", b.getB_id(), b.getB_title(), b.getB_writer(), b.getB_content());
		}
		//System.out.println(boards);
	}
	
	
	//5-1.글 번호로 게시글 조회하기
	public void findIdPost() {
		int b_id = ScannerUtil.readInt("글번호 검색");
		int b_parent_id = b_id;
		ArrayList<Board> boards = boardList.findIdPost(b_id);
		System.out.println("==================================================================");
		System.out.println("글번호" + "\t" + "\t" + "제목" + "\t" + "\t" + "\t" + "\t" + "작성자");
		System.out.println("------------------------------------------------------------------");
		for(Board b : boards) {
			System.out.printf(" %-15d %-30s -10%s\n\n\n %-10s\n\n\n", b.getB_id(), b.getB_title(), b.getB_writer(), b.getB_content());
		}
		System.out.println("------------------------------------------------------------------");
		ArrayList<Board> bList = boardList.printComment(b_parent_id);
		for(Board b : bList) {
			System.out.printf("    └─ %s\n\n", b.getB_content());
		}
		//System.out.println(boards);
	}
	

	//6.댓글달기: parent_id를 조회해서???나오는 댓글들을 다 출력???
	//가닥 잡히면 Access랑 DAO에 추가하는 것 까먹지 말기
	public void inputComment() {
		Board board = new Board();
		board.setB_parent_id(ScannerUtil.readInt("댓글 달 글번호"));
		//int b_id = ScannerUtil.readInt("댓글 달 글번호");
		board.setB_content(ScannerUtil.readStr("댓글 입력")); //String b_comment = ScannerUtil.readStr("댓글 입력");
		//board.setB_parent_id(b_id);
		//System.out.println(board + "\n" + "└─댓글: " + board.getB_comment());
		boardList.inputComment(board);
		System.out.println("입력한 댓글: " + board.getB_content());
		
	}
	
	//댓글출력
	public void printComment() {
		int b_parent_id = ScannerUtil.readInt("글번호 검색");
		ArrayList<Board> boards = boardList.printComment(b_parent_id);
		for(Board b : boards) {
			System.out.printf("댓글단 글번호: %d\n댓글내용: %s\n\n", b.getB_parent_id(), b.getB_content());
		}
		
	}
	

}
