package pkg.friend;

import pkg.Friend;

public class SchoolFriend extends Friend {
	String birth;
	public SchoolFriend() {
		super();
	}

	public SchoolFriend(String gubun, String name, String tel) {
		super(gubun, name, tel);
	}	
	
	public SchoolFriend(String gubun, String name, String tel, String birth) {
		super(gubun, name, tel);
		this.birth = birth;
	}

	@Override		//오버라이딩 == 재정의	class 앞에 final 붙으면 오버라이딩 불가
	public void print() {
		System.out.printf("학교친구: %20s %20s %20s %20s\n", gubun, name, tel, birth);
		//super.print();
	}

	
}
