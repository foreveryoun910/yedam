package co.memo.access;

import java.util.ArrayList;

import co.memo.model.Memo;

public interface MemoAccess {
	
	//1.메모등록
	public void input(Memo memo);
	
	//2.메모수정
	public void update(Memo memo);
	
	//3.메모삭제(날짜로 검색해서 삭제)
	public void delete(String date);
	
	//4.메모전체조회
	public ArrayList<Memo> selectAll();
	
	//5.날짜검색
	public Memo selectDate(String date);
	
	//6.내용검색
	public Memo selectContent(String content);
}
