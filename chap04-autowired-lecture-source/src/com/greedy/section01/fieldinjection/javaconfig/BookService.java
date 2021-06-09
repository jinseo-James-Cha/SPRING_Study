package com.greedy.section01.fieldinjection.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	/* 
	 * @Autowired 
	 * BookDAO 타입의 bean으로 생성된 객체를 이 property에 자동으로 연결해준다.
	 * 
	 * 따라서, 
	 * BookDAOImpl의 
	 * @Repository("bookDao")
	 * public class BookDAOImpl implements BookDAO
	 * 
	 * 결국 Autowired가 걸린 객체 타입과 Bean으로 설정된 클래스 중 BookDAO가 type으로 있는 클래스를 wiring해준다.
	 * */
	@Autowired
	private BookDAO bookDAO;
	
	public BookService() {}
	
	public BookService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	/* 도서 정보 전체 조회 */
	public List<BookDTO> selectAllBooks(){
		return bookDAO.selectBookList();
	}
	
	/* 도서번호로 도서 조회 */
	public BookDTO selectOneBook(int sequence) {
		return bookDAO.selectOneBook(sequence);
	}
	
}
