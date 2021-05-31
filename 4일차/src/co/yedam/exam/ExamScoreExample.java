package co.yedam.exam;

public class ExamScoreExample {

	public static void main(String[] args) {
		ExamScore examScore = new ExamScore("수험번호", 60, 20, 80);
		System.out.println(examScore.isPass());
		
		boolean result = examScore.isPass();
		if(result) {
			System.out.println("합격");
		}
		else {
			System.out.println("불합격");
		}
	}

}
