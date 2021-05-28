package co.yedam.app;

public class MemberInfoMain {
	public static void main(String[] args) {
		MemberInfo member = new MemberInfo();
		
//		member.input();
//		member.print();
		
		member.heightWeightInput();
		member.bmi();
		System.out.println("bmi 지수: " + member.result + " 결과: " + member.s);
	}
}
