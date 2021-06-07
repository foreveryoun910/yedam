package 스레드;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	
	//메모리 입력받으면 2초 있다가 메모리를 출력한다.
	//synchronized: 동기화 -> 줄 세워서 차례대로 일이 처리될 수 있도록 한다.
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}
}
