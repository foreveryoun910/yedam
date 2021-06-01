package 도형;

public class Tri extends Shape implements Drawable {
	
	private int h;
	
	public Tri(int w, int h) {
		this.w = w;
		//super(w);
		this.h = h;
	}

	@Override
	public void area() {
		result = (w * h) / 2;		
	}

	@Override
	public void draw() {
		System.out.println("tri draw");
		
	}

	
}
