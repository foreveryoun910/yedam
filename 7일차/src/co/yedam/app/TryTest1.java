package co.yedam.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TryTest1 {

	public static void main(String[] args) {

		// NullPointerException 에러
		try {
			String s = null;
			System.out.println(s.charAt(0));
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 에러메세지 보는 명령어
			// e.printStackTrace(); //에러메세지 자세하게 보는 명령어
		}

		// ArrayIndexOutOfBoundsException 에러
		try {
			int[] arr = new int[5];
			System.out.println(arr[5]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		int a = 0;
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.print("입력> ");
				a = scanner.nextInt();
				if(a < 5)
					break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("a: " + a);
		System.out.println("the end");
	}

}
