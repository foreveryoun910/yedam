package co.yedam.app.date;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day_year = calendar.get(Calendar.DAY_OF_YEAR);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		System.out.println(year + " , " + month + " , " + day);
		System.out.println(day_year);
		System.out.println(hour + " : " + minute + " : " + second);
		System.out.println(calendar);
		System.out.println(System.currentTimeMillis());
		
		
		
		//살아온 일수 계산
		Calendar birth = Calendar.getInstance();
		birth.set(1993, 8, 10);
		long dur = calendar.getTimeInMillis() - birth.getTimeInMillis();
		dur = dur / 1000 / 60 / 60 / 24;
		System.out.println("내가 태어난 지: " + dur + "일");
		
		
		//기념일 계산(Calendar)
		Calendar christmas = Calendar.getInstance();
		christmas.set(2021, 11, 25);
		long xmas = christmas.getTimeInMillis() - calendar.getTimeInMillis();
		xmas = xmas / 1000 / 60 / 60 / 24;
		System.out.println("크리스마스까지 d-" + xmas + "일");
		
		//날짜 조회(LocalDate)
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate.getYear() + "/" + 
							currentDate.getMonthValue() + "/" + 
							currentDate.getDayOfMonth());	//오늘 날짜 출력
		System.out.println(currentDate.plusDays(100));	//오늘부터 100일 뒤 날짜
		
		LocalTime start = LocalTime.of(10, 35, 40);
		LocalTime end = LocalTime.of(10, 36, 50, 800);
		
		Duration duration = Duration.between(start, end);
		
		System.out.println("hours: " + duration.toHours());
		System.out.println("Seconds: " + duration.getSeconds());
		System.out.println("Nano Seconds: " + duration.getNano());
				
				
		//Date -> String
		SimpleDateFormat df = new SimpleDateFormat("\"EEE, MMM d, ''yyyy\"");
		System.out.println(df.format(date));
		System.out.println(df.format(calendar.getTime()));
		
		
		//String -> Date
		
		
		// !!!!!!!!!!!!!!!!! Ctrl + Shift + o : 한번에 import 다 해줌 !!!!!!!!!!!!!!!!!!!!!
		
		
	}
}
