package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SqliteConnect {
	// 1.조회, 2.입력, 3.수정, 4.삭제, 5.전체리스트(각각 기능을 분리) -> 메소드로 기능분리

	// 매번 써야하는 꼭 필요한 것들은 필드로 선언
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	// 전체리스트
	public static ArrayList<Person> getPersonList() {
		ArrayList<Person> personList = new ArrayList<>(); // personList라는 이름의 배열 생성(아직 비었음)
		connect(); // Connection 연결객체 ( 중 요 )
		String sql = "select * from person";
		try {
			psmt = conn.prepareStatement(sql); // psmt: sql을 실행하고 결과를 담아오기 위한 기능, 연결하고나서 Connection 객체가 가지고 있는
												// PreparedStatement 쿼리를 생성해줘야 함
			rs = psmt.executeQuery(); // 쿼리의 실행결과를 가져오는 부분
			while (rs.next()) {
				// System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
				Person person = new Person(); // 데이터베이스에서 가져온 값을 Person에 담기 위해서
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));

				personList.add(person); // personList에 person의 내용을 담는 것
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return personList;
	}

	// 한건조회
	public static Person getPerson(int id) {
		connect();
		String sql = "select * from person where id = ?"; // 물음표 쓰면 여기에 파라미터가 들어갈 것이라는 뜻
		// PreparedStatement : 쿼리를 실행해서 결과를 받아오는 메소드(?
		Person p = null; // 참조변수 p: heap 영역을 참조해서 값을 가져오는 변수(주소값만 가지고 있음)
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id); // 1번째 파라미터(=?)에 id가 들어간다는 뜻
			rs = psmt.executeQuery(); // select 할 때 사용
			// 한 건만 나올 거니까 반복문은 안 돌려도 되고, 값이 있는지 없는지만 확인한다
			// 여러 건이 아니기 때문에 배열을 불러올 필요는 없고 Person 타입만 불러온다
			if (rs.next()) {
				// 조건을 만족해서 가져오면 그때 p를 할당하겠어............라는 의미
				p = new Person(); // instance 생성, p는 null이라서 이 구문 없이 실행하면 NullPointError
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));
				// 지금 비어있는(null) Person 타입 p에 값을 하나씩 입력

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return p;
	}

	// 입력
	// select 해올 값이 없기 때문에 return 타입이 void
	public static void insertPerson(int id, String name, int age, String phone) {
		connect();
		String sql = "insert into person values(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			// 파라미터(=?)는 1번부터 시작
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setString(4, phone);
			int r = psmt.executeUpdate(); // insert, update, delete 할 때 사용
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 수정
	public static void updatePerson(Person person) {
		connect();
		String sql = "update person set name=?, age=?, phone=? where id=?;";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, person.getName());
			psmt.setInt(2, person.getAge());
			psmt.setString(3, person.getPhone());
			psmt.setInt(4, person.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 삭제
	// 아이디를 받는다 -> 리스트를 조회해서 입력받은 아이디와 동일한 아이디를 가진 요소를 찾는다 -> 해당 요소를 삭제한다
	public static void deletePerson(int id) {
		connect();
		String sql = "delete from person where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id); // ? 자리에 id가 들어간다.
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	
	//이름으로 조회 
	public static ArrayList<Person> getNamePerson(String name) {
		ArrayList<Person> persons = new ArrayList<Person>();
		connect();
		String sql = "select * from person where name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				Person p = new Person();
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setId(rs.getInt("id"));
				p.setPhone(rs.getString("phone"));
				
				persons.add(p);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return persons;
		
	}


	// 연결메소드
	public static void connect() {
//		Connection conn = null;		//연결객체
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		// connect 닫히는 함수
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end of if

		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end of if
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end of if
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 메인메소드에서 기능 호출

		while (true) {
			System.out.println("1: 전체리스트 | 2: 입력 | 3: 수정 | 4: 삭제 | 5: 한건조회 | 6: 이름으로 조회 | 9: 종료");
			int menu = scanner.nextInt();
			if (menu == 1) {
				// 전체리스트 보여주는 기능
				ArrayList<Person> list = getPersonList(); // getPersonList에서 return한 값을 ArrayList타입의 list(변수명)에 저장
				System.out.println("<조회 결과>");
				for (Person person : list) { // list안의 요소들을 하나씩 출력(전체조회)
					System.out.println(person);
				}

			} else if (menu == 2) {
				// 입력기능
				System.out.print("아이디를 입력하세요> ");
				int searchId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("이름을 입력하세요> ");
				String name = scanner.nextLine();
				System.out.print("나이를 입력하세요> ");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.print("전화번호를 입력하세요> ");
				String phone = scanner.nextLine();

				insertPerson(searchId, name, age, phone);

			} else if (menu == 3) {
				// 수정기능
				System.out.print("조회할 아이디를 입력하세요> ");
				int searchId = scanner.nextInt();
				scanner.nextLine();
				Person p = getPerson(searchId); // p -> name, age, phone

				if (p == null) {
					System.out.println("존재하지 않는 아이디입니다");
					continue;
				}

				System.out.print("변경할 이름을 입력하세요> ");
				String changedName = scanner.nextLine();
				System.out.print("변경할 나이를 입력하세요> ");
				String changedAge = scanner.nextLine();
				System.out.print("변경할 전화번호를 입력하세요> ");
				String changedPhone = scanner.nextLine();

				if (!changedName.equals("")) {
					p.setName(changedName);
				}
				if (!changedAge.equals("")) {
					p.setAge(Integer.parseInt(changedAge));
				}
				if (!changedPhone.equals("")) {
					p.setPhone(changedPhone);
				}

				updatePerson(p);

			} else if (menu == 4) {
				// 삭제기능
				System.out.print("삭제할 아이디를 입력하세요> ");
				int searchId = scanner.nextInt();

				deletePerson(searchId);

			} else if (menu == 5) {
				// 단건조회
				System.out.print("조회할 아이디를 입력하세요> ");
				int searchId = scanner.nextInt();
				Person p = getPerson(searchId);
				if (p == null) {
					System.out.println("조회된 값이 없습니다.");
				} else {
					System.out.println(p);
				}

				
			} else if (menu == 6) {
				// 이름으로 조회 -----> 이름은 중복 가능
				System.out.print("조회할 이름을 입력하세요> ");
				String name = scanner.nextLine();
				scanner.nextLine();
				ArrayList<Person> p = getNamePerson(name);
				
				for(Person ps : p) {
					if(ps.equals(name)) {
						System.out.println(ps);
					}
					else {
						System.out.println("조회된 값이 없습니다.");
						break;
					}
				}

				
			} else if (menu == 9) {
				break;
			}

		} // end of while

		System.out.println("정상적인 종료");
		scanner.close();
	} // end of main
} // end of class
