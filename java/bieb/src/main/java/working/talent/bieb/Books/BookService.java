package working.talent.bieb.Books;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookInterface bookInterface;
	
	@Autowired
	private AuthorInterface authorInterface;
	
	public List<Book> findAllBooks() {
		return bookInterface.findAll();
	}
	
	public void addNewBook(Book book) {
		bookInterface.save(book);
	}
	
	@Transactional
	public void addAuthorToBook(Long isbn, Author author) {
		/* We get the book that we send the author to, normally findById
		returns an <Optional> type, but the orElseThrow mitigates that */
		Book book = bookInterface.findById(isbn).orElseThrow();
		// We save the author to the author repository
		author = authorInterface.save(author);
		// We add to already existing
		book.getAuthor().add(author);
	}
	
}
