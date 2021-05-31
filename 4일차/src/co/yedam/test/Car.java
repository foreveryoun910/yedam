package co.yedam.test;

/*
 * 자동차 정보 저장
 * 필드만 가지는 클래스
 * 객체지향 1단계. 클래스 선언
 */
public class Car {
	// 필요한 필드(만들고자 하는 클래스의 상태값, 속성, 정보 등등...)
	String company;
	String model;
	String color;
	int maxSpeed;
	int speed;
	
	/*
	 * 생성자 만드는 규칙
	 * 1. 객체 생성시에 호출되어 필드 초기화를 하는 특수용도의 메서드
	 * 2. 생성자 이름은 클래스명과 동일
	 * 3. 리턴타입 X(없음)
	 * 4. 생성자 여러개 중복선언(오버로딩)은 가능하지만
	 * 	  매개변수의 타입과 개수는 달라야 한다.
	 */
	Car(String company, String model, String color){
		this(company, model, color, 0, 0);
	}
	
//	Car(){
//		this("현대", "그랜저", "검정", 350, 0);
//	}
	
	Car(){}		// 기본생성자 (이렇게만 만들어도 됨)
	// 원래 자바가 기본적으로 기본생성자 만들어주는데
	// 22열처럼 생성자가 하나 정의되면 기본생성자 안 만들어줌
	// 그래서 이렇게 따로 정의해줘야 함

	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed
				+ ", speed=" + speed + "]";
	}

	public Car(String model, int speed) {
		this("", model, "", 0, speed);

		}

	// 5개 전부 초기화
	public Car(String company, String model, String color, int maxSpeed, int speed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		
		if(maxSpeed > 100) {
			this.maxSpeed = maxSpeed;
		} else {
			this.maxSpeed = 100;
		}
		if (speed > 50) {
			this.speed = speed;
		} else {
			this.speed = 50;
		}
	
	}
}
