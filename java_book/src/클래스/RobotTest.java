package 클래스;

public class RobotTest {
	public static void main(String[] args) {
		
		//2.객체생성
		Robot robot = new Robot(2, 4, "홍길동");
		System.out.println(robot.getArm());
		System.out.println(robot.getLeg());
		Robot robot2 = new Robot(2, 2, "김길동");
		System.out.println(robot2.getArm());
		System.out.println(robot2.getLeg());
		
		//3.객체사용(메소드호출)
		robot.print();
	}
	
	
}
