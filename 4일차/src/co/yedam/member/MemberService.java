package co.yedam.member;

import java.util.Scanner;

public class MemberService implements Service {

	Member[] members = new Member[10];
	Scanner scanner = new Scanner(System.in);
	int count = 0;
	
//	// 회원가입
//	void insert(String name, String id, String password, int age) {
//		members[count] = new Member(name, id, password, age);
//		count++;
//	}
	
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
	
	
//	// 멤버 번호로 조회
//	void printMember(int i) {
//		System.out.println(members[i].name);
//		System.out.println(members[i].id);
//		System.out.println(members[i].age);
//	}
	
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
	
	public void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}

	
	
	
	
	@Override
	public void input() {
		//회원등록
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

	@Override
	public void update() {
		// 회원수정
		System.out.printf("수정할 id> ");
		int id = scanner.nextInt();
		if(id >= count-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.print("이름> ");
		String name = scanner.next();
		members[id].setName(name); 
		System.out.println("수정되었습니다.");
		
	}

	@Override
	public void delete() {
		// 회원삭제
		System.out.printf("삭제할 id> ");
		int id = scanner.nextInt();
		if(id > count-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		for(int i=id; i<count-1; i++) {
			members[i] = members[i+1];
		}
		count--;
		System.out.println("삭제되었습니다.");
	}

		
	@Override
	public void selectAll() {
		// 전체조회
		for(int i=0; i<count; i++) {
			System.out.printf("%d\t %s\t %s\t %s\t %d\n", i, members[i].id, members[i].name, members[i].password, members[i].age);
		}
	}

	@Override
	public void selectOne() {
		// 단건조회
		System.out.print("번호> ");
		int i = scanner.nextInt();
		System.out.printf("%d\t %s\t %s\t %s\t %d\n", i, members[i].id, members[i].name, members[i].password, members[i].age);
	
	}	
}
