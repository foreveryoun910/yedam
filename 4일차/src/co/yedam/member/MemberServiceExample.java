package co.yedam.member;

import java.util.Scanner;

public class MemberServiceExample {
	public static void main(String[] args) {
		
		MemberService memberService = new MemberService();
			
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		int selectNum = 0;
		
		while(run) {
			System.out.println("=========================================================");
			System.out.println("1.등록 | 2.전체조회 | 3.번호로 조회 | 4.로그인 | 5.id로 조회 | 6.종료");
			System.out.println("=========================================================");
			System.out.print("선택> ");
			
			selectNum = scanner.nextInt();
			if(selectNum == 1) {
				memberService.insert();
			}
			else if(selectNum == 2) {
				memberService.printList();
			}
			else if(selectNum == 3) {
				memberService.printMember();
			}
			else if(selectNum == 4) {
				memberService.login();
			}
			else if(selectNum == 5) {
				memberService.printId();
			}
			else if(selectNum == 6) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
		
	
		
		
		
		
		
		
		
		
		
//		MemberService memberService = new MemberService();
//		
//		memberService.insert("홍길동", "hong", "1234", 23);
//		memberService.insert("윤동주", "yoon", "5678", 27);
//		memberService.insert("권용식", "kwon", "9012", 26);
//		
//		memberService.printList();
//		memberService.printMember(1);
//		
//		System.out.println(memberService.login("yoon", "5678"));
//		System.out.println(memberService.login("yoon", "1111"));
		
		
//		boolean result = memberService.login("hong", "12345");
//		if(result) {
//			System.out.println("로그인 되었습니다.");
//			memberService.logout("hong");
//		}
//		else {
//			System.out.println("id 또는 password가 올바르지 않습니다.");
//		}
	}
}