package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

//14-2 보조스트림 p.615
//파일 입력해서 모니터 출력
public class BufferTest {
	public static void main(String[] args) {
		
		try {
			BufferedReader fr = new BufferedReader(new FileReader("D:/temp/data.txt"));
			PrintStream out = System.out;
			
			String a;
			while(true) {
				a = fr.readLine();
				if(a == null) break;
				out.println(a);
			}
			fr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
