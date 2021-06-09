package co.friend.common;

import co.friend.access.FriendDAO;

public class ColletionEx4 {
	public static void main(String[] args) {
		
		//이름, 연락처 출력하세요
		FriendDAO dao = new FriendDAO();
		dao.getNameTel();
	}
}
