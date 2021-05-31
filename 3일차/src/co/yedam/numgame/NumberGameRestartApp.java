package co.yedam.numgame;

import java.util.Scanner;

public class NumberGameRestartApp {
	
	int com;
	int user;
	Scanner scanner = new Scanner(System.in);
	
	// com이 임의의 수(num) 생성	
	void init() {
		System.out.println("com이 숫자를 생성합니다.");
		com = (int)(Math.random()*100+1);		// 1~100 출력
	}
	
	
	// user가 수 입력
	void input() {
		System.out.print("user가 수 입력: ");
		user = scanner.nextInt();
	}
	
	// 비교해서 높다, 낮다: false 정답: true 출력
	boolean result;
	boolean confirm() {
		if (com == user) {
			result = true;
			System.out.println("정답");
		}
		else if (com < user) {
			result = false;
			System.out.println("정답보다 높다");
		}
		else if (com > user) {
			result = false;
			System.out.println("정답보다 낮다");
		}
		return result;
		
	}
	
		
	void start() {
		init();
		while(true) {
			input();
			if(confirm() == true) {			//confirm() 메소드의 결과값이 true면 반복 종료
				if(confirmStart() == false) {
					break;
				}
			}
		}
	}
	
	boolean confirmStart() {
		System.out.println("게임을 다시 시작할까요?(y/n)");
		char re = scanner.next().charAt(0);
		if(re == 'y' || re == 'Y') {
			return true;
		}
		else {
			System.out.println("게임을 종료합니다.");
			return false;
		}
	}
	
}
		
	
	// 정답을 맞히면(true) 종료..하지 않고 리스타트

