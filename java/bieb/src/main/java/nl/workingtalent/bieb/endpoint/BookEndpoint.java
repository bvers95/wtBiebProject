package nl.workingtalent.bieb.endpoint;

import nl.workingtalent.bieb.model.Book;
import nl.workingtalent.bieb.repository.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/books")
public class BookEndpoint {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping(value="/add")
	public Book addNewBook(@RequestBody Book book) {
		return bookService.addNewBook(book);
	}

}
