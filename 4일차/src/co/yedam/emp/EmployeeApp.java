package co.yedam.emp;

import java.util.Scanner;

public class EmployeeApp {
	Employee[] employee = new Employee[1000];
	Scanner scanner = new Scanner(System.in);
	int count = 0;
	
	void input() {
		//사원정보입력
		System.out.print("사번> ");
		int employeeId = scanner.nextInt();
		System.out.print("이름> ");
		String name = scanner.next();
		System.out.print("급여> ");
		int salary = scanner.nextInt();
		
		employee[count] = new Employee(employeeId, name, salary);
		count++;
	}
	
	void init() {
		//사원수
		System.out.println(count);
	}
	
	void print() {
		//사원리스트
		for(int i=0; i<count; i++) {
			System.out.printf("%d\t %s\t %d\n", employee[i].employeeId, employee[i].name, employee[i].salary);
		}
	}
	
	String search(int num) {
		//사번으로 검색해서 사원 찾기
		String name = "";
		//String result = employee.name;
		for(int i=0; i<count; i++) {
			if(num == employee[i].employeeId) {
				name = employee[i].name;
			}
			else {
				System.out.println("일치하는 사원이 없습니다.");
			}
		}
		return name;
	}
	
	int sum() {
		//급여합계
		int total = 0;
		for(int i=0; i<count; i++) {
			total += employee[i].salary;
		}
		return total;
	}
	
	
}
