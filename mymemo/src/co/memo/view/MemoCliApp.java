package co.memo.view;

import java.util.ArrayList;

import co.memo.access.MemoList;
import co.memo.model.Memo;
import co.memo.util.ScannerUtil;

public class MemoCliApp {

	MemoList memoList = new MemoList();

	public void start() {
		int menunum;
		
		do {
		// 메뉴출력
			menuTitle();

		// 메뉴선택
			menunum = ScannerUtil.readInt("입력");

		// 실행
			switch(menunum) {
			case 1:
				input();	//등록
				break;
			case 2:
				update();	//수정
				break;
			case 3:
				delete();	//삭제
				break;
			case 4:
				selectAll();
				break;
			case 5:
				selectDate();
				break;
			case 6:
				selectContent();
				break;
			}
			
		} while(menunum != 0);

	}

	
	public void menuTitle() {
		System.out.println("-----메모관리-----");
		System.out.println("|   1.메모등록   |");
		System.out.println("|   2.메모수정   |");
		System.out.println("|   3.메모삭제   |");
		System.out.println("|   4.전체조회   |");
		System.out.println("|   5.날짜검색   |");
		System.out.println("|   6.내용검색   |");
		System.out.println("|     0.종료    |");		
		System.out.println("----------------");	
	}
	
	
	// 등록, 추가
	public void input() {
		String date = ScannerUtil.readStr("날짜");
		String content = ScannerUtil.readStr("내용");
		Memo memo = new Memo(date, content);
		memoList.input(memo);

	}

	// 수정
	public void update() {
		Memo memo = new Memo();
		memo.setDate(ScannerUtil.readStr("수정할 날짜"));
		memo.setContent(ScannerUtil.readStr("변경할 내용"));
		memoList.update(memo);

	}

	// 삭제
	public void delete() {
		String date = ScannerUtil.readStr("날짜");
		memoList.delete(date);

	}

	// 전체조회
	public void selectAll() {
		ArrayList<Memo> list = memoList.selectAll();
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}

	// 날짜검색
	public void selectDate() {
		String date = ScannerUtil.readStr("검색할 날짜");
		Memo memo = memoList.selectDate(date);
		System.out.println(date);
	}

	// 내용검색
	public void selectContent() {
		String content = ScannerUtil.readStr("검색할 내용");
		Memo memo = memoList.selectContent(content);
		System.out.println(memo);
	}

}
