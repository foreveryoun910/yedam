package 클래스;

public class Member {
	 
	String name;
	String id;
	String password;
	int age;
	
	// 기본생성자
	Member(){}
	
	// 모든 필드를 초기화하는 생성자
	public Member(String name, String id, String password, int age) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", password=" + password + ", age=" + age + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Member mb = ((Member)obj);		//Object타입 obj를 Member타입으로 강제형변환
		return mb.name.equals(this.name) && mb.id.equals(this.id);
		//강제형변환한 obj의 name과 member의 name을 비교?????
	}
	
	
	
	
}
