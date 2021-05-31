package co.yedam.member;

import java.util.Scanner;

public class MemberService {

	Member[] members = new Member[10];
	Scanner scanner = new Scanner(System.in);
	int count = 0;
	
	// 회원가입
	void insert(String name, String id, String password, int age) {
		members[count] = new Member(name, id, password, age);
		count++;
	}
	
	// 회원가입(인수 없이)
	void insert() {
		System.out.print("id> ");
		String id = scanner.next();
		System.out.print("password> ");
		String password = scanner.next();
		System.out.print("name> ");
		String name = scanner.next();
		System.out.print("age> ");
		int age = scanner.nextInt();
		
		members[count] = new Member(name, id, password, age);
		count++;
	}
	
	// 전체 회원 리스트 출력
	void printList() {
		for(int i=0; i<count; i++) {
			System.out.printf("%d\t %s\t %s\t %s\t %d\n", i, members[i].id, members[i].name, members[i].password, members[i].age);
		}
	}
	
	
	// 멤버 번호로 조회
	void printMember(int i) {
		System.out.println(members[i].name);
		System.out.println(members[i].id);
		System.out.println(members[i].age);
	}
	
	// 멤버 번호로 조회(인수 없이)
	void printMember() {
		System.out.print("번호> ");
		int i = scanner.nextInt();
		System.out.printf("%d\t %s\t %s\t %s\t %d\n", i, members[i].id, members[i].name, members[i].password, members[i].age);
	}
	
	
	// id로 조회
	boolean printId() {
		boolean result = false;
		System.out.print("조회할 id> ");
		String id = scanner.next();
		for(int i=0; i<count; i++) {			
			if (id.equals(members[i].id)) {
				result = true;
				System.out.printf("%s\t %s\t %s\t %d\n", members[i].id, members[i].name, members[i].password, members[i].age);
				break;
			}
		}	
		if (result == false) {
			System.out.println("회원이 아닙니다.");
		}
		return result;
	}
	
	
	
	// 로그인 & 로그아웃
	boolean login(String id, String password) {
		boolean result = false;
		for(int i=0; i<count; i++) {
			if(id.equals(members[i].id) && password.equals(members[i].password)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	
	// 로그인 인수 입력받아서
	boolean login() {
		System.out.print("id> ");
		String id = scanner.next();
		System.out.print("password> ");
		String password = scanner.next();
		boolean result = false;
		for(int i=0; i<count; i++) {
			if(id.equals(members[i].id) && password.equals(members[i].password)) {
				result = true;
				System.out.println("로그인 성공!");
				break;
			}
		}
		return result;
	}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}	
}
