package com.greedy.section01.fieldinjection.javaconfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDAOImpl implements BookDAO {

	private Map<Integer, BookDTO> bookList;
	
	public BookDAOImpl() {
		bookList = new HashMap<Integer, BookDTO>();
		
		/* database가 없기때문에 샘플데이터 삽입 */
		bookList.put(1, new BookDTO(1, 123456, "자바의 정석", "남궁성", "도우출판", new Date()));
		bookList.put(2, new BookDTO(2, 223456, "수학의 정석", "차진서", "자이글출판", new Date()));
		bookList.put(3, new BookDTO(3, 323456, "연탄길", "James", "모두출판", new Date()));
		bookList.put(4, new BookDTO(4, 423456, "칭찬칭찬", "Cha", "나와출판", new Date()));
	}
	
	@Override
	public List<BookDTO> selectBookList() {
		/* Map객체에서 values를 하면 ArrayList로 사용 할 수 있다 */
		return new ArrayList<BookDTO>(bookList.values());
	}

	@Override
	public BookDTO selectOneBook(int sequence) {
		return bookList.get(sequence);
	}

}
