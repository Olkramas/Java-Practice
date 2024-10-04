package bookManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMain {
	/*
	1도서등록 2.도서검색 3.도서전체 출력 4.도서삭제 5.도서정보변경 6.종료

	도서 객체 : 책제목, 저자, 가격, 책번호

	도서main에 다 만들기 : 전체메뉴 반복실행
			     메뉴별로 작업
	*/
	
	//필드 외부 접근 막기 - getter/setter
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Book> booklist = new ArrayList<>();
		BookDao dao = new BookDao();
		//됐다 안됐다 판단하기 위해 만들었음.
		int cnt = 0;
		
		boolean run = true;
		
		while(run) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.도서등록 | 2.도서검색 | 3.도서 전체 목록 | 4. 도서삭제 | 5.도서 정보 변경 | 6. 종료");
			System.out.println("--------------------------------------------------------------------");
			System.out.print("메뉴 이동 > ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			
			dao.connect();
			
			switch(menuNum) {
			case 1:
				//도서등록
				System.out.println("[도서등록]");
				System.out.println("책 제목을 입력하세요 > ");
				String title = scanner.nextLine();
				System.out.println("저자를 입력하세요 > ");
				String writer = scanner.nextLine();
				System.out.println("책 가격을 입력하세요 > ");
				int bookPrice = Integer.parseInt(scanner.nextLine());
				System.out.println("책 번호를 입력하세요 > ");
				String bookNum = scanner.nextLine();
				
				booklist.add(new Book(title, writer, bookNum, bookPrice));
				dao.insert();
				System.out.println("입력이 완료되었습니다.");
				
//				for(BookDao ele : booklist) {
//					ele.connect(menuNum);
//					//int cnt로 값 받아서 1또는 0으로 받아서 성공했는지 실패했는지까지 구현해야됨.
//				}

				break;
			case 2:
				//도서검색 책 제목으로 검색
				System.out.println("검색할 책 제목을 입력하세요");
				String titleForCondition= scanner.nextLine();
				
				
//				Iterator<BookDao> bookIr = booklist.iterator();
//				while(bookIr.hasNext()) {
//					boolean checkTitle = bookIr.next().getTitle().equals(titleForCondition);
//					if(checkTitle == true) {
//						bookIr.
//					}
//				}
				break;
			case 3:
				//도서전체 조회
			case 4:
				//도서 삭제 책번호 받기
			case 5:
				//도서정보변경
				//책제목 : 변경할 책번호, 변경할 책 가격입력 => 수정
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			}
			
		}
	}

}
