package co.yedam.numgame;

public class NumberGameApp {
	
	int com;
	int user;
	
	// com이 임의의 수(num) 생성	
	void init() {
		System.out.println("com이 숫자를 생성합니다.");
		com = (int)(Math.random()*100+1);		// 1~100 출력
	}
	
	
	// user가 수 입력
	void input() {
		System.out.print("user가 수 입력: ");
	}
	
	// 비교해서 높다, 낮다: false 정답: true 출력
	boolean confirm() {
		if (com == user) {
			return true;
		}
		if (com > user) {
			System.out.println("높다");
			return false;
		}
		if (com < user) {
			System.out.println("낮다");
			return false;
		}
		
	}
	
	void start() {
		init();
		while(true) {
			input();
			if (confirm()) {
				break;
			}
		}
	}
	
	// 정답을 맞히면(true) 종료
}
