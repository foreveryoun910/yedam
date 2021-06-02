package pkg.friend;

import java.util.List;

import pkg.Friend;

/*
 * 친구관리개발시 개발표준
 * 인터페이스: 상수필드 + 추상메소드
 * 상수필드: public static final
 * 메소드: public abstract
 */
public interface FriendAccess {
	
	//등록
	public void insert(Friend friend);
	
	//수정
	public void update(Friend friend);
	
	//삭제
	public void delete(String name);
	
	//전체조회
	public void selectAll();
	
	//단건조회
	public Friend selectOne(String name);
}
