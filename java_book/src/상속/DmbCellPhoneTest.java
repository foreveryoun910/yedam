package 상속;

public class DmbCellPhoneTest {
	public static void main(String[] args) {
		
		DmbCellPhone phone = new DmbCellPhone();
		
		DmbCellPhone dmbCellPhone = new DmbCellPhone("갤럭시 노트10", "핑크", 10);
		
		System.out.println(dmbCellPhone.color + " : " + dmbCellPhone.model);
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannel(20);
		dmbCellPhone.turnOffDmb();
		dmbCellPhone.powerOff();
		
	}
	
}
