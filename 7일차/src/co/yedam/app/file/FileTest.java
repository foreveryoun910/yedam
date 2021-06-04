package co.yedam.app.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	public static void main(String[] args) throws IOException {
		//filecreate();
		//makefolder();
		//fileInfo();
		folderlist();
	}
	
	
	public static void filecreate() throws IOException {
		//파일 생성
		File file = new File("d:/temp/diary.txt");
		boolean result = file.createNewFile();
		System.out.println(result);
	}
	


	private static void makefolder() {
		//폴더만들기
		File file = new File("d:/temp/images");
		file.mkdir();
	}
	
	
	private static void fileInfo() {
		//파일정보
		File file = new File("d:/temp/image.png");
		System.out.println("파일크기: " + file.length());
		System.out.println("파일이름: " + file.getName());
		System.out.println("파일경로: " + file.getPath());
	}
	

	private static void folderlist() {
		//폴더목록
		File file = new File("d:/temp");
		if(file.isDirectory()) {
			//얘가 디렉토리인지 확인(폴더일 수도 있으니까?)
			File[] list = file.listFiles();
			for(File f : list) {
				if(StringUtil.getExtention(f.getName()).equals("png")) {
					//확장자가 png인 파일만 선택해서 불러오기
					System.out.println(f.getName());
					FileUtil.copy(f.getAbsolutePath(), "d:/temp/images/" + f.getName());
				}
			}
		}
	}


	
}
