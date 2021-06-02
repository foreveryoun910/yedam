package pkg.friend;

import pkg.Friend;

public class AppMain {
	public static void main(String[] args) {
		
		Friend f = new CompanyFriend("예담상사", "김기자", "010-1111-1111", "과장");
		f.print();
		
		Friend f1 = new SchoolFriend("예담학교", "박기자", "010-2222-2222", "0602");
		f1.print();
	
		//다형성(전제조건: 상속받고 오버라이딩)
		//1.부모타입의 참조변수가 자식객체를 참조 가능
		//2.메소드 실행하면 참조대상의 메소드가 호출되므로 결과가 다 다르다
		
		//instanceof: 타입비교, 아래 예시를 보면 fr이 CompanyFriend에 속하는지를 비교해서 조건을 만족하는 메소드 실행
		FriendManager manager = new FriendManager();//BeanFactory.getBean(FriendAccess.class);
		for(Friend fr : manager.friends) {
			if(fr instanceof CompanyFriend) {
				fr.print();				
			}
		}
		
		
	}
}
