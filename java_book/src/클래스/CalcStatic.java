package 클래스;

public class CalcStatic {
	
	final static double PI = 3.14;
	//final: 조회는 가능하지만 값 변경불가, 상수
	//상수는 대문자로 써준다
	//여러 단어가 이어졌을 경우 _로 구분
	//ex) PI_INT
	
	//static: 클래스에 생성된 모든 객체가 공유하는 필드
	//객체를 생성하지 않고도 클래스 이름으로 접근 가능

	@Override
	public String toString() {
		return "CalcStatic [pi=" + PI + "]";
	}
	
	public static int add(int inNum1, int inNum2) {
		return inNum1 + inNum2;
	}
	
	
}
