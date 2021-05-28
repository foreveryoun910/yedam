package co.yedam;

public class StudentExample {

	public static void main(String[] args) {
		// 2. 객체 생성 (생성된 객체 = 인스턴스)
		StudentApp app = new StudentApp();
		Student student = app.createStudent();
		student.print();
	}

}