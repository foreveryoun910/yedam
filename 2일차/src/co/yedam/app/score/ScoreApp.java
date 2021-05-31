package co.yedam.app.score;
/*
 * 성적처리 프로그램
 * 국어,영어,수학 입력
 * 총점,평균,등급 계산
 */

import java.util.Scanner;

public class ScoreApp {
	
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	float avg;
	char grade;

	
	
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public float getAvg() {
		return avg;
	}

//	public void setAvg(float avg) {
//		this.avg = avg;
//	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	// 성적입력
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어점수: ");
		kor = scanner.nextInt();
		System.out.print("수학점수: ");
		mat = scanner.nextInt();
		System.out.print("영어점수: ");
		eng = scanner.nextInt();
		
		
		sum = kor + mat + eng;
		avg = (float)sum / 3;
		
		return;
	}
	
//	// 합계계산
//	int getSum() {
//		sum = kor + mat + eng;
//		return sum;
//	}
//	
//	// 평균계산
//	float getAvg() {
//		avg = sum / 3;
//		return avg;
//	}
	
	
	boolean isPass() {
		if (avg >= 60) {
			return true;
			}
		else {
			return false;
			}
		}
		// 평균이 60점 이상이면 true, 아니면 false
	
	
	
	char getGrade() {				//	80 상	60 중	나머지 하
		switch ((int) avg / 10) { // 점수 100까지 있으니까 10으로 나눠서 십의자리수만 가지고 등급매기기..
		case 10:
		case 9:
			grade = '수';
		case 8:
		case 7:
			grade = '우';
			break;
		case 6:
		case 5:
			grade = '미';
			break;
		case 4:
		case 3:
			grade = '양';
			break;
		default:
			grade = '가';
			break;
		}
		
		return grade;
	}

}
