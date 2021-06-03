package pkg.friend;

import java.util.Scanner;

import pkg.Friend;

public class FriendAppMain {
	public static void main(String[] args) {
		
		FriendList list = new FriendList();
		
		
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		int selectNum = 0;
		while(run) {	
			System.out.println("=========================== 친구 =============================");
			System.out.println(" 1.등록 | 2.변경 | 3.검색 | 4.삭제 | 5.전체조회 | 6.단건조회 | 7.종료");
			System.out.println("=============================================================");
			System.out.print("선택> ");
			selectNum = scanner.nextInt();
			
			if(selectNum == 1) {
				//등록
				Friend f = new CompanyFriend("예담물산", "홍길동", "010-1111-2222");
				list.insert(f);
				f = new SchoolFriend("예담대학교", "김유신", "010-2222-3333");
				list.insert(f);
			}
			
			if(selectNum == 2) {
				//수정
				Friend f = new SchoolFriend("예담대학교", "김유신", "010-1234-5678");
				//list.update(f.getName().equals("김유신"));		//이름을 찾아서 값을 변경
			}
			
			if(selectNum == 3) {
				//검색
				System.out.println(list.selectOne("김길동"));				
			}
			if(selectNum == 4) {
				//삭제
				list.delete("홍길동");				
			}
			if(selectNum == 5) {
				//전체조회
				list.selectAll();				
			}
			if(selectNum == 6) {
				//단건조회
				list.selectOne("김유신");
			}
			if(selectNum == 7) {
				run = false;
				System.out.println("프로그램 종료");
			}
		
		}
	}
}
