package 연산자;

/*
 * ^ : xor - 서로 다르면 1 (암호화)
 * & : and - 마스크 (안 보이게 만든다, 0으로 만든다)
 * | : or
 */
public class 비트연산 {
	public static void main(String[] args) {
		
		//논리비트연산- 암호화/복호화
		int a = 04474;
		int key = 01111;	//암호화된 키값
		
		System.out.println("원문: " + a);
		
		int b = a ^ key;
		System.out.println("암호화: " + b);
		
		int c =  b ^ key;
		System.out.println("복호화: " + c);
		
		int d = 0b10101111;
		int e = 0b00000010;		//마스크, 1인지 알고 싶은 자리만 1 주고 나머지는 0 씌움, 한 자리만 알고 싶을 때
		System.out.println(Integer.toBinaryString(d & e));
	
		
		
		//쉬프트연산
		int f = 8;
		System.out.println(f >> 1);		//8=1000을 오른쪽으로 1 보내면 -> 0100	/2(나누기 2)한 거랑 같다. 속도가 더 빠름
		System.out.println(f << 1);		//오른쪽으로 한자리 가는 건 *2랑 같은 효과
	}
}
