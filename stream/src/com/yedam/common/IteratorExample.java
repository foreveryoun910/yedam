package com.yedam.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.yedam.Person;
import com.yedam.PersonDAO;

public class IteratorExample {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Hong", "Park", "Choi");	//asList -> List에 요소 담기
		
		list.iterator();	//iterator : 반복
		Iterator<String> iter = list.iterator();	//반복된 요소를 지정,사용하기 위해서 반복자 선언
		while(iter.hasNext()) {
			String val = iter.next();	//String타입의 val에 요소 대입?
			//System.out.println(val);
			System.out.println(val.toUpperCase().length());
		}
		
		
		//코드를 간략하게 사용하고 싶어서 stream 사용		--> 람다식 형태
		System.out.println("<stream>");
		Stream<String> stream = list.stream();
		stream.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
			
		});	//forEach() <-- ()에는 메소드가 사용(매개함수)		//함수 --> 람다표현식
		//stream의 각각의 요소?에 대해서 어떤 기능을 실행하겠다?라는 의미
		
		
		
		//sample 요소를 database에서 갖고 오도록 한다.
		PersonDAO dao = new PersonDAO();
		ArrayList<Person> persons = dao.getPersonList();
		Stream<Person> pStream = persons.stream();
		//forEach에 오는 애는 Consumer고 Consumer는 accept만 가지고 있으니까 람다식 조건 충족
		//매개변수타입도 Person인 거 뻔하니까 지워주고 어차피 수행할 식 하나밖에 없으니까 중괄호도 지워준다.
		//원래 interface는 new로 추가할 수 없는데 익명객체로 바로 받아와서 쓸 거라서 가능
		long cnt = pStream//
		.filter(  (t) -> t.getAge() > 25  )	//return값이 true인 요소만 다음 스트림으로 넘겨준다.(필터링)
		.filter(  (t) -> t.getName().startsWith("홍")  )
		//.forEach(  (t) -> System.out.println(t.toString())  )//
		.count();
		System.out.println("최종처리 건수: " + cnt);
	}
	
}
