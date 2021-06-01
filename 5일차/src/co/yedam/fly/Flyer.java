package co.yedam.fly;
/*
 * 인터페이스
 * 1.다중상속
 * 2.모든 메소드에 public abstract가 생략되어있다
 * 3.모든 메소드가 추상메소드
 * 4.개발표준 역할
 */
public interface Flyer {

	void takeOff();

	void fly();

	void land();

}