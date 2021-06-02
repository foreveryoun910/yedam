package pkg.friend;

import pkg.Friend;

public class CompanyFriend extends Friend {
	String duty;
	public CompanyFriend() {
		super();
	}

	public CompanyFriend(String gubun, String name, String tel) {
		super(gubun, name, tel);
	}
	
	public CompanyFriend(String gubun, String name, String tel, String duty) {
		super(gubun, name, tel);
		this.duty = duty;
	}

	@Override	//오버라이딩 == 재정의
	public void print() {
		System.out.printf("회사친구: %20s %20s %20s %20s\n", gubun, name, tel, duty);
//		super.print();
//		System.out.println("duty: " + duty);
	}

	
}
