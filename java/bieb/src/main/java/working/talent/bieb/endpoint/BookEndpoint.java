package working.talent.bieb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import working.talent.bieb.model.Book;
import working.talent.bieb.repository.BookService;

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
