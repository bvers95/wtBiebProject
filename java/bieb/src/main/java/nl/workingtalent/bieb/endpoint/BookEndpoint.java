package nl.workingtalent.bieb.endpoint;

import nl.workingtalent.bieb.model.Book;
import nl.workingtalent.bieb.model.Label;
import nl.workingtalent.bieb.model.BookItem;
import nl.workingtalent.bieb.repository.BookItemService;
import nl.workingtalent.bieb.repository.BookService;
import nl.workingtalent.bieb.repository.LabelService;
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

	@Autowired
	private BookItemService bookItemService;

	@Autowired
	private LabelService labelService;

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

	@PostMapping(value = "{id}/bookitem")
	public BookItem addBookItem(@PathVariable Long id) {
		return bookItemService.addBookItem(id);
	}

	@PutMapping(value = "/{bookId}/label/{labelId}")
	public Label assignLabel(@PathVariable Long bookId, @PathVariable Long labelId) {
		return labelService.assignLabel(bookId, labelId);
	}

}
