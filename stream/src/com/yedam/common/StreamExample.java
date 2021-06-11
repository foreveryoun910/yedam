package com.yedam.common;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.ToIntFunction;

import com.yedam.Person;
import com.yedam.PersonDAO;

public class StreamExample {
	public static void main(String[] args) {
		//1.스트림 2.중간처리/최종처리 3.결과

		/*
		List<Person> list = null;
		PersonDAO dao = new PersonDAO();
		list = dao.getPersonList();
		list.stream() //스트림생성
		.filter(new Predicate<Person>() {

			@Override
			public boolean test(Person t) {
				return t.getAge()%2==0;
			}})
		.forEach(v -> System.out.println(v));
		*/
		
		List<Person> list = null;
		PersonDAO dao = new PersonDAO();
		list = dao.getPersonList();
		OptionalDouble avg = list.stream()//
		.filter(  (t) -> t.getAge() % 2 == 0  ) //필터링
//		.filter(   t  -> t.getId() > 900   )
		//.forEach(  v -> System.out.println(v)  );
		.mapToInt(new ToIntFunction<Person>() {

			@Override
			public int applyAsInt(Person p) { //매개값을 Person타입으로 받고 리턴은 int타입
				return p.getAge();
			}}) //매핑 a -> b
		.average(); //나이평균
		if(avg.isPresent()) {			
			System.out.println("평균나이: " + avg.getAsDouble());
		} else {
			System.out.println("만족하는 요소가 없습니다");
		}
	}
}
