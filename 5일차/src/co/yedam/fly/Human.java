package co.yedam.fly;

public class Human extends Animal {
	
	public Human() {}
	
	public void think() {
		System.out.println("인간은 생각한다.");
	}

	@Override
	public void eat() {
		System.out.println("한국인은 밥심이다.");
	}
}
