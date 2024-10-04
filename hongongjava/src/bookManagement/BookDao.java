package bookManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {
	//필드
	Connection conn = null;
	


	
	//메소드
	//1.연결 설정 메소드
	void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
//			System.out.println("db연결성공");
			
			//이 자리에 spl문 + preparseStatement 넣으면 됨
//			switch(menuNum) {
//			case 1: insert(conn); break;
//			case 2: //selectWhere(conn); break;
//				System.out.println("case2연결됨."); break;
//			default : System.out.println("아무것도 안걸림");
//			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
//					System.out.println("연결끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
//	2.연결끊기 메소드
//	public void disConnect(Connection conn) {
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	//3.
	
	
	//3.insert메소드
	void insert() {
		String sql = "" +
				     "insert into book (title, " +
				     "                  writer, " +
				     "                  price, " +
				     "                  bnum ) "+
				     "values (?, "+
				     "        ?, " +
				     "        ?, " +
				     "        ?)";
				     
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, this.title);
//			pstmt.setString(2, this.writer);
//			pstmt.setInt(3, this.bookPrice);
//			pstmt.setString(4, this.bookNum);
			int rows = pstmt.executeUpdate();
			if(rows == 1) {	
				System.out.println("추가 성공");
				pstmt.close();
			} else {
				System.out.println("추가 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//4.select where 조건에 따른 검색(책제목)
	void selectWhere(Connection conn) {
		String sql = "" +
	                 "select * " +
				     "from book " +
	                 "where title=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, this.title);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BookDao book = new BookDao();
//				book.setTitle(rs.getString(1));
//				book.setWriter(rs.getString(2));
//				book.setBookPrice(rs.getInt(3));
//				book.setBookNum(rs.getString(4));
//				System.out.println(book.getTitle() + " : " + book.getWriter() + " : " + book.getBookPrice() + " : " + book.getBookNum());
				System.out.println(book);
			}
			int rows = pstmt.executeUpdate();
			if(rows == 1) {	
				System.out.println("가져오기 성공");
				pstmt.close();
				rs.close();
			} else {
				System.out.println("가져오기 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	//5.select 목록전체 조회
	//6.delete 삭제
	//7.update 메소드(책제목 : 변경할 책변호, 밴경할 책가격 입력 => 수정)
	
//	@Override
//	public String toString() {
//		return title + " : " + writer + " : " + bookNum + " : " + bookPrice;
//	}

	

}
