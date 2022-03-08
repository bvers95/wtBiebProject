package nl.workingtalent.bieb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalent.bieb.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public Book addNewBook(Book book) {
		Book newBook = bookRepo.save(book);
		return newBook;
	}
	
}
