package 스레드;
/*
 * Runnable은 스레드로 실행가능한! 이지 스레드 자체인 건 아니다.
 */
public class Print10000 implements Runnable {

	@Override
	public void run() {
		for(int i=10000; i<=10100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
