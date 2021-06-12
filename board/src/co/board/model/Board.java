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
	



	public Board() {}
	
	public Board(int b_id, String b_title, String b_content, String b_writer, int b_parent_id) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_parent_id = b_parent_id;
	}
	
	
	
	//한건조회하면 출력되는 양식 작성
	public Board(int b_id, String b_title, String b_content, String b_writer) {
//		super();
//		this.b_id = b_id;
//		this.b_title = b_title;
//		this.b_content = b_content;
//		this.b_writer = b_writer;
	}
	
	
	//게시글 등록하면 보이는 출력양식
	public Board(String b_title, String b_content, String b_writer) {
		//this(0, b_title, b_content, b_writer);
		
		//System.out.printf("%d\t%s\t%s\n%s\n", b_id, b_title, b_writer, b_content);
		
	}
	
	
	//댓글 달면 나오는 풍경
	public Board(int b_parent_id, String b_content) {
//		this(0, "제목", b_content, "작성자", b_parent_id);
		//System.out.printf("%d\t%s\t%s\n%s\n", b_id, b_title, b_writer, b_content);
	}
	
	

	
	//전체조회 및 기본출력양식
	@Override
	public String toString() {
		System.out.printf(" %-15d %-30s %-10s", b_id, b_title, b_writer);
		//return "글 번호 [" + b_id + "] " + "\n" + "제목: " + b_title + "\n" + "작성자: " + b_writer + "\n" + 
			//	"내용: " + b_content + "\n";
		return "";
	}
	
	
	/*
	 * 글 번호 [ ]
	 * 제목: 					/ 작성자:
	 * 내용:
	 * └─댓글:  (+ "└─댓글: " + b_comment)
	 */
	
	

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

	
	
	
	public int getB_parent_id() {
		return b_parent_id;
	}

	public void setB_parent_id(int b_parent_id) {
		this.b_parent_id = b_parent_id;
	}

	
}
