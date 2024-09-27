package chap06;

public class Student {
	//필드 : 속성을 가짐
	String stNo;
	String name;

	
	//생성자 : 객체를 생성해줌. 객체의 속성을 초기화 시켜주는 역할을 함. 그래서 필드에 = 0으로 안해도 됨.
	Student(String stNo, String name) {
		this.stNo = stNo;
		this.name = name;
	}
	
	//메소드: 기능을 가짐
	//리턴되는 값이 없으면 void
	void study() {
		System.out.println("공부합니다.");
	}
	
	
}

