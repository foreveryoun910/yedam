package co.yedam.score2;

public class ScoreArr2App {
	
	// 2차원배열
				  //kor eng mat
	int[][] arr = {{100, 90, 80, 40}, 
				   {10, 20},
				   {50, 50, 50},
				   {30, 30, 30}};
	
	
	void print() {
		
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	
	// 해당 학생의 과목 수
	int getSbjCount(int num) {
	
		return arr[num].length;
	}
	
	
	// 입력한 점수의 한 학생의 총점 계산
	int stdTotal(int num) {
		int result = 0;
		
		// 합계 계산
		for (int i=0; i<arr[num].length; i++) {
			result += arr[num][i];
		}
		
		return result;
	}
	
}
