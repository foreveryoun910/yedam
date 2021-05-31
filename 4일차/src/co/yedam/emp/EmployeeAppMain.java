package co.yedam.emp;

import java.util.Scanner;

public class EmployeeAppMain {
	public static void main(String[] args) {
		EmployeeApp app = new EmployeeApp();
		Scanner scanner = new Scanner(System.in);
		int selectNum = 0;
		boolean run = true;
		while (run) {
			System.out.println("=========================================================");
			System.out.println("1.사원수 | 2.사원정보입력 | 3.사원리스트 | 4.검색 | 5.급여합계 | 6.종료");
			System.out.println("=========================================================");
			System.out.print("선택> ");
			selectNum = scanner.nextInt();
			if (selectNum == 1) {
				app.init();
			} else if (selectNum == 2) {
				app.input();
			} else if (selectNum == 3) {
				app.print();
			} else if (selectNum == 4) {
				System.out.print("검색할 사번> ");
				int num = scanner.nextInt();
				String name = app.search(num);
				System.out.print("이름은 " + name);
			} else if (selectNum == 5) {
				int s = app.sum();
				System.out.println("총 급여는 " + s + " 입니다.");
			} else if (selectNum == 6) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
		scanner.close();
	}
}
