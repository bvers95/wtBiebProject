package nl.workingtalent.bieb.repository;

import nl.workingtalent.bieb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;

	public List<Book> getAllBooks() {
		List<Book> allBooks = bookRepo.findAll();
		return allBooks;
	}

	public Optional<Book> getBookById(Long id) {
		Optional<Book> foundBook = bookRepo.findById(id);
		return foundBook;
	}

	public Optional<Book> getBookByIsbn(String isbn) {
		Optional<Book> foundBook = bookRepo.findByIsbn(isbn);
		return foundBook;
	}

	public Book addBook(Book book) {
		// Some fields are empty
		if (book.someEmpty()) {
			// Meaning we throw an internal server error like the other errors
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// Checks if the isbn we just got is actually unique
		if (bookRepo.findByIsbn(book.getIsbn()).isPresent()) {
			// Or else we throw an internal server error like the other errors
			throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED);
		}
		Book newBook = bookRepo.save(book);
		return newBook;
	}
	
}
