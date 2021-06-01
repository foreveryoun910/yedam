package co.yedam.tv;

public class LgTV implements RemoteControl {
	
	public LgTV() {}

	@Override
	public void powerOn() {
		System.out.println("엘지TV --전원ON");
		
	}

	@Override
	public void powerOff() {
		System.out.println("엘지TV --전원OFF");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("엘지TV --볼륨UP");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("엘지TV --볼륨DOWN");
		
	}

}
