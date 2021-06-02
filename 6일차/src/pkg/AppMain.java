package pkg;

public class AppMain {
	
	static void print() {
		System.out.println("==");		
	}
	
	
	public static void main(String[] args) {
		
		Count count1 = new Count();
		Count.cnt1++;		//스태틱
		count1.cnt2++;		//필드
		
		Count count2 = new Count();
		Count.cnt1++;
		count2.cnt2++;
		
		Count count3 = new Count();
		Count.cnt1++;
		count3.cnt2++;
		
		System.out.println(Count.cnt1 + " : " + count1.cnt2);
		System.out.println(Count.cnt1 + " : " + count2.cnt2);
		System.out.println(Count.cnt1 + " : " + count3.cnt2);
		
		
		print();
		
		//DateUtil dateUtil = new DateUtil();
		System.out.println(DateUtil.curDate());
		
		ProjectInfo.uploadpath = "/upload";				//final 주기 전에는 바꿀 수 있다
		System.out.println(ProjectInfo.name);	//static으로 바꾸면 클래스명만 치면 바로 불러오기 가능
		
		ProjectInfo info = new ProjectInfo();
		System.out.println(info.version);
	}
}
