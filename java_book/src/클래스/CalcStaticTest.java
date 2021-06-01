package 클래스;

public class CalcStaticTest {
	public static void main(String[] args) {
		
		
		//정적멤버는 객체 생성하지 않고 클래스이름으로 접근 가능
		//CalcStatic.PI = 3.141592;
		System.out.println(CalcStatic.PI);
		System.out.println(CalcStatic.add(10, 20));
		
		System.out.println(Integer.MAX_VALUE);
		
				//참조변수
		CalcStatic c1 = new CalcStatic();		
		CalcStatic c2 = new CalcStatic();
		//클래스타입			//생성자, new 객체 생성
		
		
//		System.out.println(c1);
//		System.out.println(c2);
	}
}
