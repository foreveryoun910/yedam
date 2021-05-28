package co.yedam.score2;

public class AppMain {

	public static void main(String[] args) {

		ScoreArr2App score = new ScoreArr2App();

		// score.print();

		for (int i = 0; i < score.arr.length; i++) {
			System.out.println(score.getSbjCount(i) + "과목 총합: " + score.stdTotal(i));
		}
	}

}
