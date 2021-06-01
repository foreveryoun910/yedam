package 클래스;

//1.클래스선언
public class Robot {

	//필드
	//private(클래스 내부에서만 접근가능): 접근제어자
	private int arm;
	private int leg;
	private String name;
	
	//setter: 필드값을 변경
	//getter: 필드값을 조회

	public int getArm() {
		return arm;
	}

	public void setArm(int arm) {
		this.arm = arm;
	}

	public int getLeg() {
		return leg;
	}

	public void setLeg(int leg) {
		this.leg = leg;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	//일반메서드
	public void print() {
		System.out.printf("arm : %d\t leg : %d\t name : %s\n", arm, leg, name);
	}
	
	//생성자 오버로딩
	//생성자
	public Robot() {}	//컴파일러가 기본으로 만드는 기본 생성자

	public Robot(int arm, int leg) {
		this.arm = arm;	//this는 자기자신 객체를 참조하는 참조변수
		this.leg = leg;
	}
	
	public Robot(int arm, int leg, String name) {
		this.arm = arm;
		this.leg = leg;
		this.name = name;
	}
}
