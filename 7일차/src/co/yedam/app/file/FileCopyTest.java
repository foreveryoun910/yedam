package co.yedam.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//혼자바 14-1 입출력 스트림 p.592
public class FileCopyTest {
	public static void main(String[] args) {
		//파일복사
		try {
		FileInputStream fis = new FileInputStream("D:/temp/image.png");	//경로이름
		FileOutputStream fos = new FileOutputStream("D:/temp/image2.png");
		
		byte[] b = new byte[100];	//속도 빠르게(100바이트씩 읽어들인다)
		
		while(true) {
			int cnt = fis.read(b);
			if(cnt == -1) break;	//더이상 읽어들일 것이 없을 때 -1을 반환하기 때문에 -1일 때 break
			fos.write(b);
		}
		fis.close();
		fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
