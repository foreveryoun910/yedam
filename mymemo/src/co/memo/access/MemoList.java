package co.memo.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.memo.model.Memo;

public class MemoList implements MemoAccess {

	ArrayList<Memo> memos;
	
	
	//파일 오픈하는 메소드
	String path = "d:/temp/memo.txt";
	
	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while(true) {
				if(! scanner.hasNext()) break;
				String str = scanner.nextLine();
				if(str == null) break;
				String[] arr = str.split("/");
				memos.add(new Memo(arr[0], arr[1]));
			}
			scanner.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//파일 저장하는 메소드
	public void save() {
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(path));
			for(Memo m : memos) {
				bf.write(String.format("%s/%s\n", m.getDate(), m.getContent()));
			} bf.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//??????????
	public MemoList() {
		memos = new ArrayList<Memo>();
		open();
	}
	
	//등록, 추가
	@Override
	public void input(Memo memo) {
		memos.add(memo);
		save();
	}

	
	//수정
	@Override
	public void update(Memo memo) {
		for(Memo m : memos) {
			if(m.getDate().equals(memo.getDate())) {
				m.setContent(memo.getContent());
			}
		}
		save();
		
		
	}

	
	//삭제
	@Override
	public void delete(String date) {
		for(Memo m : memos) {
			if(m.getDate().equals(date)) {
				memos.remove(m);
				save();
				break;
			}
		}
		
	}

	
	//전체조회
	@Override
	public ArrayList<Memo> selectAll() {
		System.out.println("MemoList");
		return memos;
	}

	
	
	//날짜검색
	@Override
	public Memo selectDate(String date) {
		for(Memo m : memos) {
			if(m.getDate().equals(date)) {
				return m;
			}
		}
		return null;
	}

	
	//내용검색
	@Override
	public Memo selectContent(String content) {
		for(Memo m : memos) {
			if(m.getContent().contains(content)) {
				return m;
			}
		}
		return null;
	}

}
