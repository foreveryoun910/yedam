package co.yedam.app.gugudan;

public class GugudanApp {
	
	// 몇단인지 입력받는 메서드(입력받은 답만 출력)
	void printDan(int dan) {
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i));
		}
		System.out.println();
		// 결과: 2*1=2  ~~~  2*9=18
	}
	
	
	void printRange(int s, int e) {
		for(int i=s; i<=e; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(i + "*" + j + "=" + (i*j) + "\t");
			}
			System.out.println();
		}
		// s단부터 e단까지 출력
	}
	
	
	// 전체 출력
	void printAll() {
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(i + "*" + j + "=" + (i*j));
			}
			System.out.println();
		}
		// 전부
	}
	
	// 9단부터 거꾸로 출력
	void printAllReverse() {
		for(int i=9; i>=2; i--) {
			for(int j=1; j<=9; j++) {
				System.out.println(i + "*" + j + "=" + (i*j));
			}
			System.out.println();
		}

	}


}
