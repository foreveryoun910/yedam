package pkg;
/*
 * 클래스 public
 * 필드 private
 * 메소드 public
 */
public class Car {
	private String model;
	private int speed;
	private boolean stop;
	
	
	public Car() {}
	
	public Car(String model, int speed) {
		this.model = model;
		if(speed < 50) {
			speed = 50;
		}
		this.speed = speed;
	}
	
	public Car(String model) {
		this(model, 0);
	}
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", speed=" + speed + "]";
	}
	
	
	
}
