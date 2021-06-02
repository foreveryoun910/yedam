package pkg;

/*
 * 정적메소드(static) 안에서는 정적필드만 접근할 수 있다
 * 일반 메소드나 필드 접근하려면 따로 new 써서 객체 만들어주고 접근해야 하기 때문에	p.277
 * 접근제어자:		private	>	default	>	protected	>	public
 * 				클래스 내부	같은 패키지	다른 패키지-상속
 */
public class DateUtil {

	public static String curDate() {
		return "20210610";
	}
}
