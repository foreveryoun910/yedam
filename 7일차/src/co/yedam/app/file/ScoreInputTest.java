package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

//14-2 보조스트림 p.615
public class ScoreInputTest {
	public static void main(String[] args) {
		
		try {
			BufferedReader fr = new BufferedReader(new FileReader("D:/temp/data.txt"));
			PrintStream out = System.out;
			
			String a;
			while(true) {
				a = fr.readLine();
				
				//score 텍스트 파일에서 공백 기준으로 문자열 자르기
				String[] score = a.split("");
				
				//int형으로 형변환해서 더하기
				score[0] = Integer.parseInt(score[0]);
				
				
				if(a == null) break;
				out.println(a);
			}
			fr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
