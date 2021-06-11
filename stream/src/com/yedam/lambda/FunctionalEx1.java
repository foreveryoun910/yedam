package com.yedam.lambda;


interface Run {
	void run();
}


class RunCls implements Run {

	@Override
	public void run() {
		System.out.println("달립니다.");
	}
	
} //이게 Run인터페이스 구현하는 정석적인 방법①


public class FunctionalEx1 {
	
	public static void main(String[] args) {
		
		RunCls cls= new RunCls();
		cls.run();
		//이게 Run인터페이스 구현하는 정석적인 방법②
		
		
		
		Run r = new Run() {

			@Override
			public void run() {
				System.out.println("빨리 달립니다.");
			}
			
		}; //end of 익명객체
		r.run();
		//Run이라는 인터페이스를 구현하는 익명구현객체(따로 클래스를 선언하지 않고 바로 new로 생성해주면서 {} <-- 바디까지
		
		System.out.println("============================");
		
		Run r = /*new Run() {

			@Override
			public void run() */ () -> /*{*/
				System.out.println("빨리 달립니다.");
			/*}
			
		}; */ //end of 익명객체
		r.run();
		
		System.out.println("============================");
		
		Run r = () -> System.out.println("빨리 달립니다.");
		r.run();
		
	}
}
