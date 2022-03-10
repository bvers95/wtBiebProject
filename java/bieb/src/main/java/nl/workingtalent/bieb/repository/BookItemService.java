package nl.workingtalent.bieb.repository;

import nl.workingtalent.bieb.model.Book;
import nl.workingtalent.bieb.model.BookItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookItemService {

	@Autowired
	private BookItemRepository bookItemRepo;

	@Autowired
	private BookRepository bookRepo;

	public List<BookItem> getAllBookItems() {
		List<BookItem> allBookitems = bookItemRepo.findAll();
		return allBookitems;
	}

	public Optional<BookItem> getBookItemById(Long id) {
		Optional<BookItem> foundBookItem = bookItemRepo.findById(id);
		return foundBookItem;
	}

	public BookItem addBookItem(Long bookId) {
		BookItem newBookItem = new BookItem();
		// Check if the book we want to add a bookItem to exists
		Book expectedBook = bookRepo.findById(bookId).orElseThrow(
			// Or else we throw an internal server error like the other errors
			() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)
		);
		System.out.println(expectedBook);
		newBookItem.setBook(expectedBook);
		bookItemRepo.save(newBookItem);
		return newBookItem;
	}
	
}
