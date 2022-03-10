package nl.workingtalent.bieb.repository;

import nl.workingtalent.bieb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Book newBook = bookRepo.save(book);
		return newBook;
	}
	
}
