package co.yedam.test;

import java.util.Arrays;

/*
 * 기본데이터형 8타입은 값 초기화 안 해줘도 기본값 0으로 초기화
 * 참조변수(String, 배열)의 초기값은 null
 */
public class FieldInitValue {
	@Override
	public String toString() {
		return "FieldInitValue [byteField=" + byteField + ", shortField=" + shortField + ", intField=" + intField
				+ ", longField=" + longField + ", booleanField=" + booleanField + ", charField=" + charField
				+ ", floatField=" + floatField + ", doubleField=" + doubleField + ", arrField="
				+ Arrays.toString(arrField) + ", referenceField=" + referenceField + "]";
	}
	byte byteField;
	short shortField;
	int intField;
	long longField;
	
	boolean booleanField;
	char charField;
	
	float floatField;
	double doubleField;
	
	int[] arrField;
	String referenceField;
	
	// 생성자 추가
	FieldInitValue(int intF, double doubleF){
		intField = intF;
		doubleField = doubleF;
	}
	
	FieldInitValue(){}
	
}
