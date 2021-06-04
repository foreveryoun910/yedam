package test1;

import java.util.Scanner;

public class EmployeeApp {
	Employee[] emp = new Employee[1000];
	Scanner scanner = new Scanner(System.in);
	int count = 0;
	
	void init() {
		//사원수
		System.out.println(count);
	}
	
	void input() {
		//사원입력
		System.out.print("사번> ");
		int employeeId = scanner.nextInt();
		System.out.print("이름> ");
		String name = scanner.next();
		System.out.print("급여> ");
		int salary = scanner.nextInt();
		
		emp[count] = new Employee(employeeId, name, salary);
		count++;		
	}
	
	void print() {
		//전체조회
		for(Employee e : emp) {
			System.out.printf("%d\t %s\t %d\n", e.getEmployeeId(), e.getName(), e.getSalary());
		}
		//이거 오류나는 이유!!!!!!!!!!!!!!!!!!!!
		//향상된 for문으로 반복 돌리면 배열 개수 1000개 준 거 다 돌리기 때문에 NullPoint가 존재한다고 오류나는 것!!!!!
		//1.그냥 일반 for문으로 반복돌리기
		//2.도전해보고 싶은 것
		//-------배열 개수 자체를 조절해서 한번 해보기
		//-------try catch 한번 써보기(오류제어)
		//-------if문 써서 null이면 출력 안 하게 할 수는 없나?
	}
	
	String search() {
		//검색(단건조회)
		//사번으로 검색해서 사원 이름 찾기
		System.out.println("사번 입력> ");
		int num = scanner.nextInt();
		String name = "";
		for(Employee e : emp) {
			if(num == e.getEmployeeId()) {
				name = e.getName();
			}
			else if(num != e.getEmployeeId()) {
				System.out.println("일치하는 사원이 없습니다.");
			}
		}
		return name;
	}
	
	int sum() {
		//급여합계
		int total = 0;
		for(Employee e : emp) {
			total += e.getSalary();
		}
		return total;
	}
}
