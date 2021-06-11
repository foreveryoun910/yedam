package co.memo.view;

import java.util.ArrayList;
import java.util.Scanner;

import co.memo.access.MemoAccess;
import co.memo.access.MemoDAO;
import co.memo.model.Memo;

public class MemoCliApp {

	MemoAccess access = new MemoDAO(); // 데이터베이스 입출력 처리하세요.
	Scanner scanner = new Scanner(System.in);

	public void start() {
		int menuNum;

		do {
			menuTitle();
			System.out.print("입력> ");
			menuNum = scanner.nextInt();
			scanner.nextLine();
			
			switch (menuNum) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				findAll();
				break;
			case 5:
				findByDate();
				break;
			case 6:
				findByContent();
				break;
			}
		} while (menuNum != 0);
		System.out.println("프로그램 종료.");
	}

	private void insert() {
		System.out.print("날짜를 입력하세요> ");
		String date = scanner.nextLine();
		System.out.print("제목을 입력하세요> ");
		String title = scanner.nextLine();
		System.out.print("내용을 입력하세요> ");
		String content = scanner.nextLine();
		
		Memo memo = new Memo(date, title, content);
		access.insert(date, title, content);
	}

	private void update() {
		Memo memo = new Memo();
		System.out.print("조회할 제목을 입력하세요> ");
		memo.setTitle(scanner.nextLine());
		System.out.print("변경할 내용을 입력하세요> ");
		memo.setContent(scanner.nextLine());
		
		access.update(memo);

	}

	private void delete() {
		System.out.print("삭제할 메모의 제목을 입력하세요> ");
		String title = scanner.nextLine();
		
		access.delete(title);
	}

	private void findAll() {
		ArrayList<Memo> memoList = access.findAll();
		for(Memo m : memoList) {
			System.out.println(m);
		}
	}

	private void findByDate() {
		Memo memo = new Memo();
		System.out.print("조회할 메모의 날짜를 입력하세요> ");
		String date = scanner.nextLine();
		memo.setDate(date);
		memo.setTitle(memo.getTitle());
		memo.setContent(memo.getContent());
		
		ArrayList<Memo> memoList = access.findByDate(date);
		for(Memo m : memoList) {
			System.out.println(m);
		}
	}

	private void findByContent() {
		Memo memo = new Memo();
		System.out.print("조회할 메모에 포함된 내용을 입력하세요> ");
		String content = scanner.nextLine();
		memo.setContent(content);
		memo.setTitle(memo.getTitle());
		memo.setDate(memo.getDate());
		
		ArrayList<Memo> memoList = access.findByContent(content);
		for(Memo m : memoList) {
			System.out.println(m);
		}
	}

	private void menuTitle() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("1.메모추가 | 2.메모수정 | 3.메모삭제 | 4.전체조회 | 5.날짜로 조회 | 6.내용으로 조회 | 0.종료");
		System.out.println("--------------------------------------------------------------------------------");

	}

}
