package api;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SystemTest {

	public static void main(String[] args) throws IOException, URISyntaxException {
		System.out.println(System.currentTimeMillis());
		//파일명 rename, 실행시간 체크
		
		//0이 아닌 값: 정상실행, 0인 값:조느라 못 들음...
		//System.exit(1);
		
		Map<String, String> map = System.getenv();
		System.out.println(map.get("JAVA_HOME"));
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ":" + map.get(key));
		}
		
		//System.gc();	/자동으로 실행된다. 
		
		Field[] fields = Book.class.getDeclaredFields();
		for(Field f : fields) {
			System.out.println(f.getName() + ":" + f.getType());
		}
		URI uri = Book.class.getResource("/resources/menu.txt").toURI();		//상대경로
		Scanner scanner = new Scanner(new File(uri));
		System.out.println(scanner.next());
	}

}
