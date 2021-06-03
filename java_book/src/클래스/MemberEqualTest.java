package 클래스;

public class MemberEqualTest {
	public static void main(String[] args) {
		
		Member m1 = new Member("김기자", "kim", "1111", 20);
		Member m2 = new Member(new String("김기자"), "kim", "2222", 25);
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));
		//Member의 equals 메서드 오버라이딩: id와 name을 비교해서 같으면 true 리턴
	}
}
