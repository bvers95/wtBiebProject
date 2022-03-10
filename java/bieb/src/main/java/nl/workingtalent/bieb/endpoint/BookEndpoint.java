package nl.workingtalent.bieb.endpoint;

import nl.workingtalent.bieb.model.Book;
import nl.workingtalent.bieb.repository.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/books")
public class BookEndpoint {
	
	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping(value = "id/{id}")
	public Optional<Book> getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}

	@GetMapping(value = "isbn/{isbn}")
	public Optional<Book> getBookByIsbn(@PathVariable String isbn) {
		return bookService.getBookByIsbn(isbn);
	}

	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

}
