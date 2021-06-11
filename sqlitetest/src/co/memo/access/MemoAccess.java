package co.memo.access;

import java.util.ArrayList;

import co.memo.model.Memo;

public interface MemoAccess {
	
	public void insert(String date, String title, String content);
	
	public void update(Memo memo);
	
	public void delete(String title);
	
	public ArrayList<Memo> findAll();
	
	public ArrayList<Memo> findByDate(String date);
	
	public ArrayList<Memo> findByContent(String content);
}
