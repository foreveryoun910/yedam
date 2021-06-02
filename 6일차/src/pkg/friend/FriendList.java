package pkg.friend;

import java.util.ArrayList;
import java.util.List;

import pkg.Friend;

public class FriendList implements FriendAccess {
	ArrayList<Friend> friends;

	
	public FriendList() {
		friends = new ArrayList<Friend>();
	}	//List는 인터페이스라서 new 키워드로 객체 생성 안 된다????
		//그래서 ArrayList로 정의해줘야 함
	
	
	@Override
	public void insert(Friend friend) {
		// 등록,추가
		friends.add(friend);
	}

	@Override
	public void update(Friend friend) {
		// 수정
		
	}

	@Override
	public void delete(String name) {
		// 삭제
		
	}

	@Override
	public void selectAll() {
		// 전체조회
		System.out.println("FriendList");
	}

	@Override
	public Friend selectOne(String name) {
		// 단건조회
		for(Friend f : friends) {
			if(f.getName().equals(name)) {	//해당 이름과 일치하는지 확인
				return f;					//해당 단어가 포함되는 걸 찾으려면 contains ( 이외에도 endwith, startwith..등등.. 사용 )
			}
		}
		return null;
	}
	
}
