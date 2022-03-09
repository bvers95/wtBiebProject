package working.talent.bieb.Books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	

	@GetMapping
	public List<Book> findAllBooks() {
		return bookService.findAllBooks();
	}
	
	@PostMapping("add") // in fact can be empty here, since posting is creating
	public Book createBook(@RequestBody Book book) {
		bookService.addNewBook(book);
		return book;
	}
	
	@PostMapping("{isbn}/author")
	public void addAuthorToBook(@PathVariable Long isbn , @RequestBody Author author) {
        bookService.addAuthorToBook(isbn, author);
    }
	
}
