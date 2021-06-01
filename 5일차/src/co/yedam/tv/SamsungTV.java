package co.yedam.tv;

public class SamsungTV implements RemoteControl{

	public SamsungTV() {}
	
	@Override
	public void powerOn() {
		System.out.println("삼성TV --전원ON");
		
	}

	@Override
	public void powerOff() {
		System.out.println("삼성TV --전원OFF");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("삼성TV --볼륨UP");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("삼성TV --볼륨DOWN");
		
	}

}
