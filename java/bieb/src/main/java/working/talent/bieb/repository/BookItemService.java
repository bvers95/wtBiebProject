package working.talent.bieb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import working.talent.bieb.model.Book;
import working.talent.bieb.model.BookItem;

@Service
public class BookItemService {

	@Autowired
	private BookItemRepository bookItemRepo;
	
	public void addNewBookItem(Long bookId) {
		
		// pull eerst de book 
		
		// create
		//BookItem newBook = new BookItem;
		//Book newBookItem = bookItemRepo.save(bookId);
		//return newBook;
	}
	
}
