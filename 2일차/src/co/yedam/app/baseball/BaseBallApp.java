package co.yedam.app.baseball;

import java.util.Scanner;

/*
 * 임의의 수 3개
 * 사용자 수 입력
 * 스트라이크, 볼 카운트
 */
public class BaseBallApp {
	
	int strike;
	int ball;
	int com1, com2, com3;
	int user1, user2, user3;
	
	void makeRnd() {
		// 난수생성
		System.out.println("com 숫자 생성");
		com1 = (int)(Math.random()*10);
		com2 = (int)(Math.random()*10); 
		com3 = (int)(Math.random()*10);
		
		// 중복 제거하는 방법 공부해서 추가하기
	}

	
	void userInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("user 숫자 입력: ");
		user1 = scanner.nextInt();
		System.out.print("user 숫자 입력: ");
		user2 = scanner.nextInt();
		System.out.print("user 숫자 입력: ");
		user3 = scanner.nextInt();
				
	}
	
	void count() {
		// 스트라이크, 볼 카운트
		
		if (com1 == user1) {
			strike = strike + 1;
		}	// 같은 자리일 때 스트라이크 증가
		else if ((com1 == user2) || (com1 == user3)) {
			ball = ball + 1;
		}	// 같은 숫자 다른 자리일 때 볼 증가

		if (com2 == user2) {
			strike = strike + 1;
		}
		else if ((com2 == user1) || (com2 == user3)) {
			ball = ball + 1;
		}
		
		if (com3 == user3) {
			strike = strike + 1;
		}
		else if ((com3 == user1) || (com3 == user1)) {
			ball = ball + 1;
		}	
		
		System.out.println("스트라이크: " + strike + " 볼: " + ball + '\n');

	}
	
	void start() {
		makeRnd();
		while(strike<3) {
			strike = ball = 0;
			userInput();
			count();
		}
	}

}
