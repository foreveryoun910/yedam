package co.yedam.fly;

public class Bird extends Animal implements Flyer {
	
	public Bird() {}

	@Override
	public void run() {
		//super.run();
		System.out.println("새는 날아다닌다.");
	}

	@Override
	public void eat() {
		//super.eat();
		System.out.println("벌레를 쪼아먹는다.");
	}
	
	public void takeOff() {
		System.out.println("새는 이륙한다.");
	}
	
	public void fly() {
		System.out.println("새는 훨훨 날아간다.");
	}
	
	public void land() {
		System.out.println("구구구구....");
	}
	
	public void layEggs() {
		System.out.println("새알");
	}
	
}
