package 배열;
/*
 * 배열: 크기고정
 * 순차적으로 데이터를 저장하고 읽는 용ㄷ
 * 추가/삭제가 번거로움
 */
public class 배열초기화 {
	public static void main(String[] args) {
		
		//1차원배열
		//배열선언
		int[] a;	//배열도 객체로 인식 -> new 이용해서 힙 영역에 메모리 할당해야 함
		a = new int[10];
		//배열값초기화
		a[0] = 10;	//배열이 10개니까 인덱스는 0~9
		a[1] = 20;	//초기값은 0
		a[2] = 100;
		a[3] = 50;
		//배열출력
//		for(int i=0; i<a.length; i++) {
//			System.out.println(a[i]);
//		}
		//배열요소 삭제(삭제기능이 따로 있는 건 아니고 인덱스 다음부터 앞으로 이동해서 덮어쓰는?삭제시키는?느낌)
		for(int i=2; i<a.length; i++) {
			a[i-1] = a[i];
			System.out.println(a[i]);
		}
		//배열선언과 초기화를 한꺼번에
		int[] b = {100, 200, 300};	//new int[3]{100, 200, 300}
		System.out.println("배열크기: " + b.length);
		
		
		//정수형배열
		//문자열배열
		//문자열배열
		
		//객체배열
		
		//2차원배열
		//정수형2차원배열
	}
}
