package 스레드;

public class ThreadTest {

	public static void main(String[] args) {

		Print100 print100 = new Print100();
		print100.setPriority(Thread.MIN_PRIORITY);
		System.out.println(print100.getName());
		print100.start();

//		Print1000 print1000 = new Print1000();
//		print1000.setPriority(Thread.MAX_PRIORITY);
//		System.out.println(print1000.getName());
//		print1000.start();

		Print1000 print1000 = new Print1000();
		Thread thread2 = new Thread(print1000);
		thread2.start();

		Thread thread1 = new Thread(new Print10000());
		thread1.start();

		//익명객체
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 2000; i <= 2100; i++) {
					System.out.println(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread3.start();
		
		
		//람다식: 구현클래스 구현메소드가 1개일 때 -> Runnable 인터페이스랑 run 메소드만 구현하면 됨 -> 람다식 가능
		Thread thread4 = new Thread( () -> {		
			for (int i = 3000; i <= 3100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}} );
		thread4.start();
	}

}
