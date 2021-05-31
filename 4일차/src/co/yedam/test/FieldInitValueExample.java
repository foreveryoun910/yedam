package co.yedam.test;

public class FieldInitValueExample {

	public static void main(String[] args) {
		FieldInitValue fiv = new FieldInitValue(10, 10.5);	// 객체 생성
		System.out.println(fiv.toString());
		
		FieldInitValue Fieldiv = new FieldInitValue();
		Fieldiv.intField = 5;
		Fieldiv.doubleField = 5.5;
		System.out.println("int: " + Fieldiv.intField);
		System.out.println("double: " + Fieldiv.doubleField);
	}

}
