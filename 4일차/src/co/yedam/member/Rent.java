package co.yedam.member;

public class Rent {
	private String title;
	private String name;
	private String date;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}

	
	public Rent(String title, String name, String date) {		//매개변수 3개짜리 생성자
		super();
		this.title = title;
		this.name = name;
		this.date = date;
	}
	
	public Rent(String title, String name) {					//매개변수 2개짜리 생성자
		this(title, name, "2021-6-2");							//근데 이제 2개짜리 생성자는 받아올 수 있는 게 없으니까????밑에서 저 형식 받아옴
																//this(어쩌구저쩌구) 형식일 때
	}
	
	public Rent() {												//매개변수 안 받는 생성자
		this("","","");
	}
	
	
	public void print() {
		System.out.printf("제목:%s  작자:%s\n", title, name);
	}
	@Override
	public String toString() {
		return "Rent [title=" + title + ", name=" + name + ", date=" + date + "]";
	}
	
	
}
