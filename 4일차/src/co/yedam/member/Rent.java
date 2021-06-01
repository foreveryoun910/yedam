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

	
	public Rent(String title, String name, String date) {
		super();
		this.title = title;
		this.name = name;
		this.date = date;
	}
	
	public Rent(String title, String name) {
		this(title, name);
	}
	
	public Rent() {
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
