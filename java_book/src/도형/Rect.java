package 도형;

public class Rect extends Shape implements Drawable, Movable {

	private int h;
	
	//메소드는 public이어야 함
	public Rect(int w, int h) {
		this.w = w;
		//super(w);
		this.h = h;		
	}
	
	@Override
	public void area() {
		result = w * h;
	}

	@Override
	public void draw() {
		System.out.println("rect draw");
		
	}

	@Override
	public void move() {
		System.out.println("rect move");
		
	}

}
