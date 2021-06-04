package co.friend.access;

import java.util.ArrayList;

import co.friend.model.Friend;

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
	//이름은 손대지말고 번호만 업데이트?
	public void update(Friend friend);
	
	//삭제
	public void delete(String name);
	
	//전체조회
	public ArrayList<Friend> selectAll();
	
	//단건조회
	public Friend selectOne(String name);
	
	//전화번호 검색
	public Friend findTel(String tel);
}
