package 최태백.Account;

import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 배열 선언
		Account[] bank = new Account[100];

		int count = 0;

		boolean run = true;

		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택 > ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			System.out.println();

			switch (menuNum) {
			case 1:
				System.out.println("계좌생성");

				while (true) {
					if (bank[count] == null && count <= 100) {
						System.out.println("계좌번호: ");
						String ano = scanner.nextLine();
//						for(int i=0; i<count-1; i++) {
//							if(!bank[i].getAno().equals(ano)) {
//								System.out.println("계좌번호 중복입니다. 초기화면으로 돌아갑니다.");
//								break;
//							}
//						}

						System.out.println("계좌 주: ");
						String owner = scanner.nextLine();

						System.out.println("초기 금액 입력");
						int balence = Integer.parseInt(scanner.nextLine());

						bank[count] = new Account(ano, owner, balence);

						System.out.println("계좌가 생성되었습니다.");
						count++;
						break;
					}

				}
				break;

			case 2:
				for (int i = 0; i <= count - 1; i++) {
					bank[i].showList();
				}
				break;

			case 3:
				System.out.println("---------------");
				System.out.println("예금");
				System.out.println("---------------");

				System.out.println("계좌번호: ");
				String checkAno = scanner.nextLine();
				for (int i = 0; i < count; i++) {
					if (bank[i].getAno().equals(checkAno)) {
						System.out.println("예금액: ");
						int inputM = Integer.parseInt(scanner.nextLine());
						if (bank[i].getBalence() + inputM <= Account.MAX_BALANCE) {
							bank[i].setBalence(bank[i].getBalence() + inputM);
							System.out.println("예금을 성공했습니다.");
						} else {
							System.out.println("통장 잔고가 1,000,000원을 초과했습니다.");
						}

					}
					if (i == count-1) {
						System.out.println("계좌번호를 확인해주세요.");
					}
				}
				break;
			case 4:
				System.out.println("---------------");
				System.out.println("출금");
				System.out.println("---------------");

				System.out.println("계좌번호: ");
				String checkAno1 = scanner.nextLine();
				for (int i = 0; i < count; i++) {
					if (bank[i].getAno().equals(checkAno1)) {
						System.out.println("출금액: ");
						int inputM = Integer.parseInt(scanner.nextLine());
						if (bank[i].getBalence() - inputM >= Account.MIN_BALANCE) {
							bank[i].setBalence(bank[i].getBalence() - inputM);
							System.out.println("출금을 성공했습니다.");
						} else {
							System.out.println("통장 잔액이 부족합니다.");
						}
					}
					if (i == count-1) {
						System.out.println("계좌번호를 확인해주세요.");
					}
				}
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
			}
		}
	}

}
