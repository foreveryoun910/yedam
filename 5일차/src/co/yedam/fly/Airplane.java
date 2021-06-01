package co.yedam.fly;

public class Airplane implements Flyer{

	@Override
	public void takeOff() {
		System.out.println("비행기는 이륙한다");
	}

	@Override
	public void fly() {
		System.out.println("비행기는 날아간다");
		
	}

	@Override
	public void land() {
		System.out.println("비행기는 착륙한다");
		
	}
	
	
}
