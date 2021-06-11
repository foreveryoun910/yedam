package com.yedam.common;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.yedam.Employee;
import com.yedam.EmployeeDAO;

public class EmployeeExample {
	public static void main(String[] args) {
		
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> employees = dao.getEmployeeList();
		Stream<Employee> eStream = employees.stream();
		
		
//		employees.stream().forEach(new Consumer<Employee>() {
//
//			@Override
//			public void accept(Employee t) {
//				System.out.println(t);
//			}}); //배열 내용 출력 테스트
		
		
		eStream.filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				
				int dateBirth = Integer.parseInt(t.getBirthDate().substring(0, 4));
						return dateBirth >= 1970;
			}})
		
		.forEach( (t) -> System.out.println("이름: " + t.getFirstName() + " " + t.getLastName() + ", 타이틀: " + t.getTitle()));
		
		
	}
}
