package co.yedam.fly;

public abstract class Animal {
	
	public Animal() {}
	
	
	public void run() {
		System.out.println("달린다.");
	}
	
	//무조건 오버라이딩 되는 클래스 만들기 -> 추상클래스
	public abstract void eat();
	
	public void sleep() {
		System.out.println("잔다.");
	}
	
}
