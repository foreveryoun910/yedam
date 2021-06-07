package wrapper;

import java.util.ArrayList;

/*
 * 1.기본 데이터형을 객체화
 * 2.타입변환
 */
public class WrapperTest {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(10));		//박싱
		list.add(new Integer("10"));	//박싱
		list.add(100);		//다른 명령어 없어도 Integer 객체로 자동으로 박싱
		
		Integer a = 100;
		int b = a.intValue();	//언박싱
		b = a;				//자동으로 언박싱
		
		
	}
}
