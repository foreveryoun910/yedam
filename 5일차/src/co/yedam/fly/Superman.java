package co.yedam.fly;

//extends: 다중상속 불가능
public class Superman extends Human implements Flyer {
	
	public Superman() {}
	
	@Override
	public void takeOff() {
		System.out.println("슈퍼맨은 이륙한다.");
	}
	
	@Override
	public void fly() {
		System.out.println("슈퍼맨은 난다.");
	}
	
	@Override
	public void land() {
		System.out.println("슈퍼맨은 착륙한다.");
	}
	
}
