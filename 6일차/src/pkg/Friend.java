package pkg;
/*
 * 접근제한자 기본: 같은 패키지 내
 * 다른 패키지인데 상속관계인 클래스는 쓸 수 있게 하는 거: protected
 */
public class Friend {
	// 클래스 중첩 가능 but public은 불가능, public은 클래스 이름이랑 동일해야 함
	protected String gubun;
	protected String name;
	protected String tel;
	public Friend() {}
	
	public Friend(String gubun, String name, String tel) {
		super();
		this.gubun = gubun;
		this.name = name;
		this.tel = tel;
	}
	
	public void print() {
		System.out.printf("친구: %20s %20s %20s\n", gubun, name, tel);
	}


	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	@Override
	public String toString() {
		return "Friend [gubun=" + gubun + ", name=" + name + ", tel=" + tel + "]";
	}
	
}