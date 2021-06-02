package pkg.friend;

import java.util.List;
import java.util.Scanner;

import pkg.Friend;

public class FriendManager implements FriendAccess {
	Scanner scanner = new Scanner(System.in);
	int count = 0;
	int maxCount = 10;
	Friend[] friends = new Friend[maxCount];		//배열
	
//	public FriendManager() {
//		friends[0] = new CompanyFriend("예담전자", "순이", "010-2222-4444");
//		friends[1] = new SchoolFriend("중앙초등학교", "돌이", "010-3333-4444");
//		friends[2] = new CompanyFriend("삼성전자", "미자", "010-5555-4444");
//		friends[3] = new CompanyFriend("엘지전자", "진숙", "010-4444-4444");
//		friends[4] = new SchoolFriend("중앙고등학교", "철이", "010-6666-4444");
//	}

	@Override
	public void insert(Friend friend) {
		// 등록
		if(count > maxCount) {
			System.out.println("더 이상 추가할 수 없습니다.");
			return;
		}
		System.out.printf("구분> ");
		String gubun = scanner.next();
		System.out.printf("이름> ");
		String name = scanner.next();
		System.out.printf("전화번호> ");
		String tel = scanner.next();
		friends[count++] = new Friend(gubun, name, tel);
	}

	@Override
	public void update(Friend friend) {
		// 수정
		System.out.println("수정> ");
		//friend를 매개변수로 받는 게 무슨 의미인지 모르겠음..
		//배열을 변수로 받는다는 소리인가요..?
		
		
	}

	@Override
	public void delete(String name) {
		// 삭제
		System.out.print("삭제할 이름> ");
		name = scanner.next();
		
			
	}

	@Override
	public void selectAll() {
		// 전체조회
		System.out.println("FriendManager");
	}

	@Override
	public Friend selectOne(String name) {
		// 단건조회
		return null;
	}
	

}
