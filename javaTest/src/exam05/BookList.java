package exam05;

import java.util.ArrayList;
import java.util.List;

public class BookList {
	//책을 입력하기 위해서 books라는 이름의 배열을 선언한다! 아직은 비어있음!!
	List<Book> books = new ArrayList<Book>();
	
	//배열 books에 책들을 입력한다!!!isbn, 입력, 내용을 입력해야 함
	public void insert(Book book) {
		books.add(book);
	}
	
	//리스트 자료형(배열) findName에서 입력받은 name을 포함하는 배열을 찾아서 출력한다!!!
	public List<Book> findName(String name) {
		List<Book> book = new ArrayList<Book>();
		for(Book b : books) {
			if(b.getName().contains(name)) {
				book.add(b);
			}
		}
		return book;
	}
}
