package pkg.friend;

import pkg.Friend;

public class FriendAppMain {
	public static void main(String[] args) {
		
		FriendList list = new FriendList();
		
		//등록
		Friend f = new CompanyFriend("예담물산", "홍길동", "010-");
		list.insert(f);
		f = new SchoolFriend("예담대학교", "김유신", "010-");
		list.insert(f);
		
		
		//수정
		f = new SchoolFriend("예담대학교", "김유신", "010-1234");
		list.update(f);		//이름을 찾아서 값을 변경
		
		
		//검색
		System.out.println(list.selectOne("김길동"));
		
		//삭제
		list.delete("김길동");
		
		
		//전체조회
		list.selectAll();
	}
	
}
