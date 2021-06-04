package co.friend.view;

import java.util.ArrayList;
import java.util.Scanner;

import co.friend.access.FriendList;
import co.friend.model.Friend;
import co.friend.util.ScannerUtil;

//메뉴를 보여주는 인터페이스 화면
public class FriendCliApp {
	
	FriendList friendList = new FriendList();
	
	public void start() {
		int menunum;
		do {
			//메뉴출력
			menuTitle();
			
			//메뉴선택
			menunum = ScannerUtil.readInt("입력");
			
			//실행
			switch(menunum) {
			case 1:
				insert();	//등록
				break;
			case 2:
				update();	//수정
				break;
			case 3:
				delete();	//삭제
				break;
			case 4:
				selectAll();//전체조회
				break;
			case 5:
				findName(); //단건조회
				break;
			case 6:
				findTel();
				break;
			}
		} while(menunum != 0);
	}
	
	
	public void findTel() {
		//전화번호로 검색
		String tel = ScannerUtil.readStr("검색할 전화번호");
		Friend friend = friendList.findTel(tel);
		System.out.println(friend);
		
	}


	public void menuTitle() {
		System.out.println("-----친구관리-----");
		System.out.println("|   1.친구추가   |");
		System.out.println("|   2.친구수정   |");
		System.out.println("|   3.친구삭제   |");
		System.out.println("|   4.전체조회   |");
		System.out.println("| 5.이름으로 조회 |");
		System.out.println("| 6.전화번호 조회 |");
		System.out.println("|     0.종료    |");		
		System.out.println("----------------");
	}
	
	
	//등록
	public void insert() {
		String gubun = ScannerUtil.readStr("구분");
		String name =  ScannerUtil.readStr("이름");
		String tel =  ScannerUtil.readStr("전화번호");
		Friend friend = new Friend(gubun,name,tel);
		friendList.insert(friend);
		
	}

	//이름으로 검색해서 전화번호 수정
	public void update() {
		Friend friend = new Friend();
		friend.setName(ScannerUtil.readStr("검색할 이름"));
		friend.setTel(ScannerUtil.readStr("변경할 전화번호"));
		friendList.update(friend);
		
	}

	//이름으로 검색해서 삭제
	public void delete() {
		String name = ScannerUtil.readStr("삭제할 이름");
		friendList.delete(name);
		
	}

	
	//전체조회
	public void selectAll() {
		ArrayList<Friend> list = friendList.selectAll();
		for(Friend friend : list) {
			System.out.println(friend);
		}
		
	}

	//이름검색
	public void findName() {
		String name = ScannerUtil.readStr("검색할 이름");
		Friend friend = friendList.selectOne(name);
		System.out.println(friend);
		
	}

	
	
	
}
