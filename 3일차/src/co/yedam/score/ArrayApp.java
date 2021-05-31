package co.yedam.score;

import java.util.Scanner;

public class ArrayApp {
	
	int[] arr;			// 성적
	int studentNum;		// 학생수
	
	Scanner scanner = new Scanner(System.in);
	
	void init() {
		// 인원수를 입력받아서 그 인원수만큼 배열을 초기화
		System.out.print("학생수> ");
		studentNum = scanner.nextInt();
		arr = new int[studentNum];
	}
	
	void input() {
		// 점수 입력
		for (int i=0; i<arr.length; i++) {	
			System.out.printf("scores[%d]> ", i);
			arr[i] = scanner.nextInt();	
		}
	}
	
	void print() {
		// 배열 출력
		for (int i=0; i<arr.length; i++) {		
			System.out.printf("scores[%d]> %d\n", i, arr[i]);
		}
		System.out.println();
	}
	
	void avg() {
		// 합계	---------------->>>> 평균으로 변경
		int result = 0;
		double avg;
		for (int i=0; i<arr.length; i++) {
			result += arr[i];
		}
		avg = (double)result / arr.length;
		System.out.printf("평균 점수: %.2f\n", avg);
	}
	
	void max() {
		// 최댓값
		int max = arr[0];
		for (int i=0; i<arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("최고 점수: " + max);
	}
	
	

	public static void main(String[] args) {

		ArrayApp app = new ArrayApp();
		
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		int selectNum = 0;
		
		while(run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택> ");
			
			selectNum = scanner.nextInt();
			if(selectNum == 1) {
				app.init();
			}
			if(selectNum == 2) {
				app.input();
			}
			if(selectNum == 3) {
				app.print();
			}
			if(selectNum == 4) {
				app.max();
				app.avg();
			}
			if(selectNum == 5) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
		
//		app.init();
//		app.print();
//		app.avg();
//		app.max();

	}
	
	
}
