package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

//키보드
//보조스트림 -> 변환기, 필터 <-- 1바이트씩 2바이트씩 잘라서 받아들일 수 있게 하는 역할?????뭐대충그런느낌?????
public class FileSaveTest {
	public static void main(String[] args) {
		//stream: byte단위로 읽어들임(이미지, 바이너리파일)
		//char: reader, writer(텍스트파일)
		
		try {
		BufferedReader isr = new BufferedReader(new InputStreamReader(System.in));	
		//1.InputStream을 InputStreamReader로 감쌌음 <--- 바이트로 읽어들이는 걸 2바이트씩 묶어서 char로 변환시키는 역할
		//2.그걸 또 BufferedReader로 감싸줘서 필터링해?????????????????? --> 걍 한줄씩 읽겠다 버퍼는 한줄 통으로
		
		BufferedWriter br = new BufferedWriter(new FileWriter("d:/temp/f.dat"));
		//키보드로 입력한 내용을 파일으로 만들 거예요 --> 메모장으로 확인
		
		while(true) {
			
			String c = isr.readLine();	
			//ctrl+스페이스 눌러서 쓸 수 있는 메소드 확인하면...그중에 .. read를 보면 int byte 한글자씩만 받아들일 수 있다는...아마..
			//BufferedReader로 필터링하고나면 줄단위로 읽어오니까 readLine
			
			if(c == null) break;
		
			br.write(c);
			br.write("\n");
			//한꺼번에 여러줄 입력받고 싶어요 ------> readLine과 write를 for문 while문 돌리면 돼요
			//여러줄 입력하고 ctrl + z 눌러서 종료하고 경로로 들어가서 f.dat 파일 확인확인
		}
		br.close();
		//꼭 닫아줘야 한다.
		
		
		//System.out.println(c)
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
