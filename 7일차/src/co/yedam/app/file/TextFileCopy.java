package co.yedam.app.file;

import java.io.FileReader;
import java.io.FileWriter;

public class TextFileCopy {
	public static void main(String[] args) {
		try {
		FileReader fr = new FileReader("D:/temp/data.txt");	//경로설정실수가 잦은 매개변수라서 예외처리 반드시 해줘야 함
		FileWriter fw = new FileWriter("D:/temp/data2.txt");
		
		//int c;	//한 글자는 int로 저장할 수 있다
		//속도 빠르게 해주기 위해 int가 아닌 배열으로 설정해보기
		//int나 byte로 설정 -> 한글자씩 한바이트씩 읽어오는 것 (???
		char[] c = new char[100];
		
		while(true) {
			int cnt = fr.read(c);
			if(cnt == -1) break;
			fw.write(c);
		}
		
		fr.close();
		fw.close();
		
		} catch(Exception e) {}
	}
}
