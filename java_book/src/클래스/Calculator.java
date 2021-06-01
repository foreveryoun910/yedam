package 클래스;

public class Calculator {
	
	//싱글톤
	private static Calculator instance = new Calculator();
	
	public static Calculator getInstance() {
		return instance;
	}
	
	private Calculator() {}	//새 인스턴스?생성 못하게 막음
	
	public int add(int a, int b) {
		return a+b;
	}
}
