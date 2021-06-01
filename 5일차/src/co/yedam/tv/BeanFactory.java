package co.yedam.tv;

public class BeanFactory {
	//Object: 최상위 클래스
	//Object타입으로 주면 모든 자료형,클래스 다 넘길 수 있음
	public static Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		}
		else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
