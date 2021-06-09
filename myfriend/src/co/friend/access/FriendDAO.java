package co.friend.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import co.friend.model.Friend;
import co.friend.util.DAO;

//FriendAccess.java, FriendList.java

public class FriendDAO extends DAO implements FriendAccess {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	
	//name, tel 값을 담아주는 컬렉션
	public Map<String, String> getNameTel(){
		Map<String, String> map = new HashMap<>();
		
		try {
			psmt = conn.prepareStatement("select name, tel from friend");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				map.put(rs.getString("name"), rs.getString("tel"));	
			}
			
		
			Set<Entry<String, String>> ent = map.entrySet();	//entry타입: map컬렉션 한건한건에 대한 데이터타입????
			Iterator<Entry<String, String>> eiter = ent.iterator();	//iterator : 반복자
			while(eiter.hasNext()) {
				Entry<String, String> e = eiter.next();
				System.out.println(e.getKey() + ", " + e.getValue());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	
	
	//등록
	@Override
	public void insert(Friend friend) {
		try {
			psmt = conn.prepareStatement("insert into friend values(?, ?, ?)");
			psmt.setString(1, friend.getGubun());
			psmt.setString(2, friend.getName());
			psmt.setString(3, friend.getTel());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 등록했습니다");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	//수정
	@Override
	public void update(Friend friend) {
		try {
			//구분하고 이름을 조건으로 줘서 전화번호를 수정
			psmt = conn.prepareStatement("update friend set tel=? where gubun=? and name=?");
			psmt.setString(1, friend.getTel());
			psmt.setString(2, friend.getGubun());
			psmt.setString(3, friend.getName());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경했습니다");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	//삭제
	@Override
	public void delete(String name) {
		try {
			psmt = conn.prepareStatement("delete from friend where name=?");
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제했습니다");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	
	//전체조회
	@Override
	public ArrayList<Friend> selectAll() {
		ArrayList<Friend> fList = new ArrayList<Friend>();
		try {
			psmt = conn.prepareStatement("select * from friend");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Friend friend = new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
				
				fList.add(friend);	//데이터 건수만큼 arrayList에 담아서 반환
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return fList;
	}

	
	//이름조회
	@Override
	public Friend selectOne(String name) {
		Friend f = null;
		try {		
			psmt = conn.prepareStatement("select * from friend where name=?");
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				f = new Friend();
				f.setGubun(rs.getString("gubun"));
				f.setName(rs.getString("name"));
				f.setTel(rs.getString("tel"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	
	//전화조회
	@Override
	public Friend findTel(String tel) {
		Friend f = null;
		try {
			psmt = conn.prepareStatement("select * from friend where tel=?");
			psmt.setString(1, tel);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				f = new Friend();
				f.setGubun(rs.getString("gubun"));
				f.setName(rs.getString("name"));
				f.setTel(rs.getString("tel"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	
}
