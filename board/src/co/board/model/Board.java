package co.board.model;

/*
 * table
 * board: b_id(글번호) / b_title / b_content / b_writer
 * member: u_id / u_pass
 */

public class Board {

	private int b_id;
	private String b_title;
	private String b_content;
	private String b_writer;
	private int b_parent_id;
	
	private String u_id;
	private String u_pass;
	
	
	public Board() {}
	
	public Board(int b_id, String b_title, String b_content, String b_writer) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
	}
	
	public Board(String b_title, String b_content, String b_writer) {
		this(0, b_title, b_content, b_writer);
		
		System.out.printf("%d\t%s\t%s\n%s\n", b_id, b_title, b_writer, b_content);
		
	}
	


	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pass() {
		return u_pass;
	}
	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}
	
	
	
	public int getB_parent_id() {
		return b_parent_id;
	}

	public void setB_parent_id(int b_parent_id) {
		this.b_parent_id = b_parent_id;
	}

	
	
	@Override
	public String toString() {
		return "글 번호: " + b_id + "\n" + "제목: " + b_title + ", 작성자: " + b_writer + "\n" + "내용: " + b_content;
	}
	
	
}
