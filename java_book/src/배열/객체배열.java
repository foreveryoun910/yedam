package 배열;

import java.awt.Point;

/*
 * 객체배열: 배열의 요소 타입이 객체인 경우
 */
public class 객체배열 {
	public static void main(String[] args) {
		//변수선언
		Score[] a;
		a = new Score[10];	//반드시 크기가 들어가야 한다!!!
		a[0] = new Score("홍길동", 100, 90, 80);	//Score 자체도 객체기 때문에 반드시 new로 생성해야 한다??
		a[1] = new Score("김길동", 40, 65, 70);
		a[2] = new Score("박길동", 95, 60, 80);
		
		//이름만 출력
		for(int i=0; i<a.length; i++) {
			if(a[i] != null) {				
				System.out.println(a[i].name);
			}
		}
		
		//선언과 동시에 초기화
		Score[] b = {new Score("홍길똥", 100, 90, 80), 
				new Score("김길똥", 40, 65, 70), 
				new Score("박길똥", 95, 60, 80)};
		
		//이름과 총점 출력
		//반복문 파이썬의 in과 같은 방식(확장된 for문) : 뒤에는 배열변수
		for(Score score : b) {
			System.out.println(score.name + " : " + score.total);
		}
		
		//객체배열
		//Point: x, y 좌표값을 저장
		Point[] c = {new Point(10, 10), 
				new Point(30, 10), 
				new Point(10, 30), 
				new Point(30, 30)};
		
		for(Point point : c) {
			System.out.println(point.x + ", " + point.y);
		}
	}
}
