package co.yedam.app.score;

public class AppMain {
	public static void main(String[] args) {
		// 3. new 객체 생성
		ScoreApp score = new ScoreApp();
		
		// 4. 객체 이용(메서드 호출)
		// 성적입력
		score.input();
		
		// 결과출력
		System.out.println(
				"합계: " + score.sum + " 평균: " + score.avg + " 등급: " + score.getGrade());
		System.out.println("합격여부: " + (score.isPass() ? "합격" : "불합격"));
	}
}