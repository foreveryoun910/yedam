package pkg.friend;

import java.util.List;

import pkg.Friend;

public class FriendManager implements FriendAccess {
	Friend[] friends = new Friend[5];
	
	
	public FriendManager() {
		friends[0] = new CompanyFriend("예담전자", "순이", "010-2222-4444");
		friends[1] = new SchoolFriend("중앙초등학교", "돌이", "010-3333-4444");
		friends[2] = new CompanyFriend("삼성전자", "미자", "010-5555-4444");
		friends[3] = new CompanyFriend("엘지전자", "진숙", "010-4444-4444");
		friends[4] = new SchoolFriend("중앙고등학교", "철이", "010-6666-4444");
	}

	@Override
	public void insert(Friend friend) {
		// 등록
		
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
		System.out.println();
	}

	@Override
	public Friend selectOne(String name) {
		// 단건조회
		return null;
	}
	

}
