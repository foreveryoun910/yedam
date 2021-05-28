package co.yedam.star;

public class StarApp {
	
	// 삼각형 출력
	void draw(int cnt) {
		for (int i=1; i<=cnt; i++) {
			System.out.println(pad('*', i));

		}
	}
	
	
	
	// 역삼각형 출력
	void drawInvert(int cnt) {
		for (int i=1; i<=cnt; i++) {
			System.out.println(pad('*', cnt-i));
		}
	}
	
	
	
	// 이등변삼각형 출력
	void drawEq(int cnt) {
		for (int i=1; i<=cnt; i++) {
			System.out.print(pad(' ', cnt-i));	// 공백출력
			System.out.println(pad('*', 2*i-1));
		}
	}
	
	// 이등변 역삼각형 출력 ~~~~범위 바꿔서
	void drawEqInvert(int cnt) {
		for (int i=cnt; i>0; i--) {
			System.out.print(pad(' ', cnt-i));	// 공백출력
			System.out.println(pad('*', 2*i-1));
		}
	}
	
//	// 이등변 역삼각형 출력 ~~~~ㅠㅠ너무 복잡하게 했음..
//	void drawEqInvert(int cnt) {
//		for (int i=1; i<=cnt; i++) {
//			System.out.print(pad(' ', i));	// 공백출력
//			System.out.println(pad('*', 2*cnt-2*i-1));
//		}
//	}

	
	
	// 나무만들기 ~~~~~~~~ 과제 ~~~~~~~~
	
	void drawTitle(String title, int cnt) {
		System.out.println(pad('=', cnt));
		System.out.println(title);
		System.out.println(pad('=', cnt));
	}
	
	
	void drawTree(int a, int b) {
		for (int i=a; i<=b; i++) {
			System.out.print(pad(' ', b-i));	// 공백출력
			System.out.println(pad('*', 2*i-1));
		}
	}
	
	
	
	// 삼각형 별 찍는 코드2
//		for (int i=1; i<9; i++) {
//			for(int j=0; j<i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
	
	
	
	
	
	// "*" * 3
	// (*, 10) --> "**********"
	String pad(char s, int cnt) {
		String result = "";
		for (int i=0; i<cnt; i++) {
			result += s;
		}
		return result;
	}
	
}
