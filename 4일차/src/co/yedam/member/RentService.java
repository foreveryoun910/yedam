package co.yedam.member;

import java.util.Scanner;

public class RentService implements Service {

	Rent[] rent;
	int count;			//입력건수
	int maxCount = 10;	//최대건수
	
	Scanner scanner = new Scanner(System.in);
	
	public RentService() {
		rent = new Rent[maxCount];	//rent 변수에 Rent배열 입력?초기화?
	}
	
	@Override
	public void input() {
		//등록
		if(count > maxCount) {
			System.out.println("더 이상 추가할 수 없습니다.");
			return;
		}
		System.out.print("제목> ");
		String title = scanner.next();
		System.out.print("이름> ");
		String name = scanner.next();
		rent[count++] = new Rent(title, name);
		System.out.println("빌려간 건수: " + count);
		
	}

	@Override
	public void update() {
		//수정
		System.out.print("수정할 번호> ");
		int date = scanner.nextInt();
		if(date >= count-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.println("이름> ");
		String name = scanner.next();
		rent[date].setName(name);
		System.out.println("수정되었습니다.");
		
	}

	@Override
	public void delete() {
		// 삭제
		System.out.println("삭제할 번호> ");
		int date = scanner.nextInt();
		if(date > count-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		for(int i=date; i<count-1; i++) {
			rent[i] = rent[i+1];
		}
		count--;
		System.out.println("삭제되었습니다.");
		
	}

	@Override
	public void selectAll() {
		//전체조회
		System.out.println(String.format("%-20s %-20s", "도서명", "이름"));
		System.out.println("================================================================");
		for(int i=0; i<count; i++) {
			System.out.println(String.format("%-20d %-20s %-20s", rent[i].getDate(), rent[i].getTitle(), rent[i].getName()));
		}
		System.out.println("================================================================");
		
	}

	@Override
	public void selectOne() {
		// 단건조회(이름)
		System.out.print("조회할 번호> ");
		int date = scanner.nextInt();
		if(date>count-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.println(String.format("도서명: %s\t 이름: %s\n", rent[date].getTitle(), rent[date].getName()));
		
	}

}
