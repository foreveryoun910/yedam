package co.yedam.test;

public class CarExample {

	public static void main(String[] args) {
		// 객체지향 2단계. 객체 생성(인스턴스)
		Car myCar = new Car();
		myCar.company = "삼성자동차";
		myCar.maxSpeed = 400;
		myCar.color = "레드";
		System.out.println("제조회사: " + myCar.company);
		System.out.println("스피드: " + myCar.speed);
		
		myCar.speed = 100;
		System.out.println("스피드 변경 후: " + myCar.speed);
		
		// 생성자
		Car yourCar = new Car("르노", "SM6", "블루");
		System.out.println(yourCar.toString());
		// "코나, 100"
		Car miniCar = new Car("코나", 100);
		System.out.println(miniCar);
		
		Car xCar = new Car("소렌토", 40);
		System.out.println(xCar);
		
		Car yCar = new Car("기아", "투싼", "블랙");
		System.out.println(yCar);
	}

}
