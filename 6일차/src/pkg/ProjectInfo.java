package pkg;
/**
 * 
 * @author admin
 * 
 */
public class ProjectInfo {
	public static final String name = "예담주식회사";		//final -> 초기값 주고나면 변경 불가
	static String uploadpath = "c:/temp";		//static -> 모든 클래스에서 공유 가능
	int version = 1;							//인스턴스 필드, new 키워드로 객체 생성해야 접근 가능
}
