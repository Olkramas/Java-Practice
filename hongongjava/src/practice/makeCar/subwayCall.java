package practice.makeCar;

import java.util.Scanner;

public class subwayCall {
	String[] station = {"문양", "다사", "대실", "강창", "계명대", "성서산업단지", 
						"이곡", "용산", "죽전", "감삼", "두류", "내당", "반고개", 
						"청라언덕", "반월당", "경대병원", "대구은행", "범어", "수성구청",
						"만촌", "담티", "연호", "대공원", "고산", "신매", "사월", 
						"정평", "임당", "영남대"};
	String startStation;
	String destination;
	int direction;
	
	subwayCall(String startStation, String destination) {
		this.startStation = startStation;
		this.destination = destination;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	void menu() {
		System.out.println("환영합니다. 메뉴를 선택해주세요.");
		while(true) {
			System.out.println("-----------------------------");
			System.out.println("1.출발/도착역 입력하기\t2.종료");
			System.out.println("-----------------------------");
			int firstMenu = Integer.parseInt(scanner.nextLine());
			
			if(firstMenu == 1) {
				System.out.print("출발역을 입력해주세요 > ");
				this.startStation = scanner.nextLine();
				System.out.println("1.영남대 방향 \t 2.반월당 방향");
				this.direction = Integer.parseInt(scanner.nextLine());
				run(this.startStation, this.direction);
			} else {
				System.out.println("프로그램을 종료합니다.");
			}
			
		}
	}
	void run(String startStation, int direction) {
		
	}
}
