package bookManagement;

import java.sql.Connection;
import java.sql.SQLException;
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
		Book book;
		BookDao dao = new BookDao();
		Connection conn = null;
		
		boolean run = true;
		
		while(run) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.도서등록 | 2.도서검색 | 3.도서 전체 목록 | 4. 도서삭제 | 5.도서 정보 변경 | 6. 종료");
			System.out.println("--------------------------------------------------------------------");
			System.out.print("메뉴 이동 > ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			
			
			switch(menuNum) {
			case 1:
				//도서등록
				System.out.println("[도서등록]");
				System.out.println("책 제목을 입력하세요 > ");
				String title = scanner.nextLine();
				String checkTitle = dao.noRe(conn, title);
				if(title.equals(checkTitle)) {
					System.out.println("중복된 책 제목입니다.\n메뉴로 돌아갑니다.");
					break;
				}
				
				System.out.println("저자를 입력하세요 > ");
				String writer = scanner.nextLine();
				System.out.println("책 가격을 입력하세요 > ");
				int bookPrice = Integer.parseInt(scanner.nextLine());
				System.out.println("책 번호를 입력하세요 > ");
				String bookNum = scanner.nextLine();
				
				
				try {
					conn = dao.getConn();
					System.out.println("연결성공");
					book = new Book(title, writer, bookNum, bookPrice);
					
					//데이터 입력
					int rows = dao.insert(conn, book);
					if(rows > 0) {
						System.out.println("저장 성공");
					} else {
						System.out.println("저장 실패");
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				} finally {
					dao.closeConn(conn);
				}

				break;
			case 2:
				//도서검색 책 제목으로 검색
				System.out.println("검색할 책 제목을 입력하세요");
				String titleForCondition= scanner.nextLine();
				try {
					conn = dao.getConn();
					System.out.println("연결성공");
					int rows = dao.selectWhere(conn, titleForCondition);
					if(rows > 0) {
						System.out.println("가져오기 성공");
					} else {
						System.out.println("가져오기 실패");
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				//도서전체 조회
				System.out.println("전체 도서 목록을 조회합니다.");

				try {
					conn = dao.getConn();
					System.out.println("연결성공");
					
					int rows = dao.selectAll(conn);
					if(rows > 0) {
						System.out.println("가져오기 성공");
					} else {
						System.out.println("가져오기 실패");
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				//도서 삭제 책번호 받기
				System.out.println("[도서삭제]");
				System.out.println("삭제할 책의 isbn코드를 입력하세요 > ");
				String inputIsbn = scanner.nextLine();
				
				try {
					conn = dao.getConn();
					System.out.println("연결성공");
					int rows = dao.delete(conn, inputIsbn);
					if(rows > 0) {
						System.out.println("삭제 성공");
					} else {
						System.out.println("삭제 실패");
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				//도서정보변경
				//책제목 : 변경할 책번호, 변경할 책 가격입력 => 수정
				System.out.println("[도서 정보 변경]");
				System.out.println("변경할 책의 제목을 입력하세요 > ");
				String inputTitle = scanner.nextLine();
				
				System.out.println("변경할 책 번호를 입력하세요 > ");
				String changeIsbn = scanner.nextLine();
				
				System.out.println("변경할 가격을 입력하세요 > ");
				int changePrice = Integer.parseInt(scanner.nextLine());
				
				try {
					int rows = dao.update(conn, inputTitle, changeIsbn, changePrice);
					if(rows > 0) {
						System.out.println("변경 성공");
					} else {
						System.out.println("변경 실패");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			}
			
		}
	}

}
