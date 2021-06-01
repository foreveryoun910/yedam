package 도형;

public class AppMain {

	public static void main(String[] args) {
		
//		Shape s = new Rect(4, 5);		//부모자식간에는 참조 가능
//		
//		s.area();
//		s.print();
		
//		Shape[] s = new Shape[3];	//부모클래스로 정의하면 하나의 배열 안에 여러가지 형식을 담을 수 있음
//		s[0] = new Rect(4, 5);
//		s[1] = new Circle(5);
//		s[2] = new Tri(4, 5);
//		
//		for(Shape temp : s) {
//			temp.area();
//			temp.print();
		
		Drawable[] s = new Drawable[3];	//부모클래스로 정의하면 하나의 배열 안에 여러가지 형식을 담을 수 있음
		s[0] = new Rect(4, 5);			//자식타입이 부모타입으로 자동 형변환
		s[1] = new Circle(5);			//메모리는 자식타입이 더 큼 왜냐하면 부모타입의 요소 + 자기 자신의 요소라서
		s[2] = new Tri(4, 5);			//부모타입을 자식타입으로 형변환하려면 강제로 ()해줘야 함
		
		for(Drawable temp : s) {
			temp.draw();
//			if(temp instanceof Rect) {				
//				((Rect)temp).area();		//부모타입 -> 자식타입 : 강제형변환
//			}
//			else if(temp instanceof Circle) {
//				((Circle)temp).area();
//			}
//			else if(temp instanceof Tri) {
//				((Tri)temp).area();
//			}
			if(temp instanceof Shape) {
				((Shape)temp).area();
				((Shape)temp).print();
			}
			
			if(temp instanceof Movable) {
				((Movable)temp).move();
			}
		}
	}

}
