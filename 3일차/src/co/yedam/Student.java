package co.yedam;

/*
 * 클래스 선언 -> new 클래스 생성 -> 필드나 메서드 호출 -> 실행
 * 1. 클래스 선언
 * 		class 이름 {      } <- 아무것도 없어도 클래스 가능
 */
public class Student {
	
	String name;
	String num;
	
	void print() {
		System.out.println(name + ": " + num);
	}
}