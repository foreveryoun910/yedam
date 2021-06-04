package co.friend.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.friend.model.Friend;


//List는 인터페이스라서 new 키워드로 객체 생성 안 된다????
//그래서 ArrayList로 정의해줘야 함
//구현클래스, 인터페이스를 받아서 쓰는 클래스(?)
public class FriendList implements FriendAccess {
	ArrayList<Friend> friends;		//리스트
	
	//파일 오픈하는 메소드
	String path = "d:/temp/friend.txt";
	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while(true) {
				if(! scanner.hasNext()) break;	//더이상 읽을 것이 없으면 종료
				String str = scanner.next();
				if(str == null) break;
				String[] arr = str.split(" ");
				friends.add(new Friend(arr[0], arr[1], arr[2]));
			}
			scanner.close();
		} catch(Exception e) {
			e.printStackTrace();	//에러메세지 볼 수 있는 메소드
		}
	}
	
	
	//파일 저장하는 메소드
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for(Friend f : friends) {
				fw.write(String.format("%s %s %s\n", f.getGubun(), f.getName(), f.getTel()));
			}
			fw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public FriendList() {
		friends = new ArrayList<Friend>();
		open();
	}	
	
	
	@Override
	public void insert(Friend friend) {
		//등록,추가
		friends.add(friend);
		save();
	}

	@Override
	public void update(Friend friend) {
		//수정
		for(Friend f : friends) {
			if(f.getName().equals(friend.getName())) {
				f.setTel(friend.getTel());
			}
		}
		save();
	}

	@Override
	public void delete(String name) {
		//삭제
		for(Friend f : friends) {
			if(f.getName().equals(name)) {
				friends.remove(f);
				save();
				break;
			}
		}
	}

	@Override
	public ArrayList<Friend> selectAll() {
		//전체조회
		System.out.println("FriendList");
		return friends;
		
//		//반복하면서 인덱스 하나씩 출력해보기
//		for(Friend f : friends) {
//			System.out.println(f);
//		}
	}

	@Override
	public Friend selectOne(String name) {
		//단건조회
		for(Friend f : friends) {
			if(f.getName().equals(name)) {	
				//해당 이름과 일치하는지 확인
				//해당 단어가 포함되는 걸 찾으려면 contains ( 이외에도 endWith, startWith..등등.. 사용 )
				return f;					
			}
		}
		return null;
	}


	@Override
	public Friend findTel(String tel) {
		//단건조회
		for(Friend f : friends) {
			if(f.getTel().contains(tel)) {	
				//해당 단어가 포함되는 걸 찾으려면 contains ( 이외에도 endWith, startWith..등등.. 사용 )
				return f;					
			}
		}
		return null;
	}
	

	
}
