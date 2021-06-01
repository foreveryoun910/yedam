package 도형;

public abstract class Shape {
	
	int w;
	double result;
	
	
	public Shape() {}
	
	public Shape(int w) {
		this.w = w;
	}
	
	
	public void print() {
		System.out.println("면적=" + result);
	}
	
	public abstract void area();	//추상메소드 부모클래스에서는 내용 없음
}
