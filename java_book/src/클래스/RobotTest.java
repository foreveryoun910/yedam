package 클래스;

public class RobotTest {
	
	
	//기본타입
	public static void change(int a) {
		a += 10;
	}
	
	//참조타입
	public static void change(Robot robot) {
		robot.setArm(5);
	}
	
	
	public static void main(String[] args) {
		
		//	 r: 참조변수
//		Robot r = new Robot(2, 4);
//		change(r);
//		System.out.println(r.getArm());
		
		
		int a = 1;
		change(a);
		System.out.println(a);
		
//		//2.객체생성
//		Robot robot = new Robot(2, 4, "홍길동");
//		System.out.println(robot.getArm());
//		System.out.println(robot.getLeg());
//		Robot robot2 = new Robot(2, 2, "김길동");
//		System.out.println(robot2.getArm());
//		System.out.println(robot2.getLeg());
//		
//		//3.객체사용(메소드호출)
//		robot.print();
	}
	
	
}
