package chap06;

public class Car {
	//필드
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 300;
	int speed;
	int gas;
	
	
	//생성자
	
	//메소드
	void setGas(int gas) {
		this.gas = gas;
	}
	
	
	//필드를 외부에서 바꿀수 없게 만듦 보통은(정보 보호기능) 그래서 getter setter메소드가 필요하게 됨.
	public int getSpeed() {
		return speed;
	}
	
	
	//gas가 있는지 없는지 확인하는 메소드
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("달립니다 (gas잔량: " + gas + ")");
				gas--;
			} else {
				System.out.println("멈춥니다 (gas잔량: " + gas + ")");
				//void일 때 return은 메소드 자체를 종료 시킬 수 있음.
				return;
			}
		}
	}
	
	void keyTurnOn() {
		System.out.println("키를 돌립니다.");
	}
	
	void run2() {
		for(int i=10; i<= 50; i+=10) {
			speed = i;
			System.out.println("달립니다. (시속:" + speed + "km/h)");
		}
	}
	
	
}
