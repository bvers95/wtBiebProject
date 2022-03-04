package working.talent.bieb.Books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/api/books")
	public List<Book> findAllBooks() {
		return bookService.findAllBooks();
	}
	
	@PostMapping("/api/book/add")
	public Book createBook(@RequestBody Book book) {
		bookService.addNewBook(book);
		return book;
	}
	
	@PostMapping(path = "/api/book/{isbn}/author")
	public void addAuthorToBook(@PathVariable Long isbn , @RequestBody Author author) {
        bookService.addAuthorToBook(isbn, author);
    } 
	
}
