package 연산자;

public class 관계연산 {

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		
		//&&: 첫번째 관계식이 false면 두번째 계산식은 처리 안 한다
		//||: 첫번째 관계식이 true면 두번째 계산식은 처리 안 한다(하나만 true여도 true니까)
		if(y++ > 10 & x++ > 10) {
			System.out.println("A");
		}
		else {
			System.out.println("B");
		}
		
		System.out.println(x);
		System.out.println(y);

	}

}
