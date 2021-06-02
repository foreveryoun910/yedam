package pkg.inheritence;

public class MainApp {
	public static void main(String[] args) {
		
		A a = new D();				//자동형변환
		int temp = ((D)a).sd;		//강제형변환
		
		A o = new A();				//애초에 A타입으로만 생성됐지 D가 안 만들어졌기 때문에
		temp = ((D)o).sd;			//D형 여기서 아무리 찾아봤자 안 나옴(런타임오류발생)
		
		System.out.println(a instanceof A);
		System.out.println(a instanceof B);
		System.out.println(a instanceof D);
		System.out.println(a instanceof X);
		
		B b = new D();
		
		
		
//		B b = new B();
//		b = new D();
//		b = new C();
		

	}
}
