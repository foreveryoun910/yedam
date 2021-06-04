package co.yedam.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		String str = "1 hi";
		Scanner scanner = new Scanner(str);
		int a = scanner.nextInt();
		String b = scanner.next();
		//next는 String 하나, nextLine은 한줄 다 읽어내는 것
		System.out.println(a + " : " + b);
		*/
		
		String str = "1 hi";
		Scanner scanner = new Scanner(new FileInputStream("d:/temp/f.dat"));
		//파일로부터 읽어들여서 화면에 출력하기
		
		while(true) {
			try {
			String a = scanner.next();
			//next는 String 하나, nextLine은 한줄 다 읽어내는 것
			System.out.println(a);
			} catch(Exception e) {
				break;
			}
		}
	}
}
