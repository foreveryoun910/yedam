package pkg.collect;

public class StringTest {
	public static void main(String[] args) {
		
		String str = "hello everybody!!";
		char c = str.charAt(0);
		System.out.println("인덱스 위치의 한글자: " + c);
		
		System.out.println(str.substring(6, 11));		//단어 자르기
		System.out.println(str.contains("body"));		//이 단어가 포함되어 있는가
		System.out.println(str.endsWith("!!"));			//이 단어로 끝나는가
		System.out.println(str.startsWith("hell"));		//이 단어로 시작하는가
	
		System.out.println("============");
		
		String num = "201030-1231234";
		
		String[] arr = num.split("-");
		System.out.println(arr[0]);
		System.out.println(arr[1].charAt(0));
		
		System.out.println("============");
		
		String path = "c:/temp/image/a.jpg";
		
		int pos = path.indexOf("/");
		int pos2 = path.lastIndexOf("/");		//끝에서부터 검색
		int pos3 = path.lastIndexOf("/", pos2+1);
		System.out.println(pos + " : " + pos2);
		
		//마지막 .의 위치에서 +1 해서 마지막까지(확장자만) 자르기: lastIndexOf, substring
		System.out.println("확장자: " + path.substring(path.lastIndexOf(".")+1));
		
		System.out.println("============");
		
		System.out.println("파일명: " + StringUtil.getFileName(path));
		System.out.println("확장자: " + StringUtil.getExtention(path));
		System.out.println("경로: " + StringUtil.getPath(path));
		
		System.out.println("============");
		
		String b = "문자열 문자";
		//String d = new String(b.getBytes(), "euc-kr");		//인코딩
		
		//b = b.replace('열', '값');
		//System.out.println(b);
		b = b.replace("자열", "을 여시오");
		System.out.println(b);
		
	}
}
