package working.talent.bieb.Books;

import java.util.List;
import java.util.Optional;

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
		Long bookIsbn = book.getIsbn();
		Optional<Book> foundBook = bookInterface.findById(bookIsbn);
		if (foundBook.isEmpty()) {
			// Book should be added
			bookInterface.save(book);
		}
	}
	
	@Transactional
	public void addAuthorToBook(Long isbn, Author author) {
		/* We get the book that we send the author to, normally findById
		returns an <Optional> type, but the orElseThrow mitigates that */
		Book book = bookInterface.findById(isbn).orElseThrow();
		
		
		
		// TODO: Make sure that no new author is made the fields already match an existing author
		// If there is an author that is already in the database put that author to the book
		// (so no author = authorInterface.save(author);)
		String authorName = author.getName();
		String authorDescription = author.getDescription();
		System.out.println(authorName);
		System.out.println(authorDescription);
		// TODO on top
		
		
		
		// We save the author to the author repository
		author = authorInterface.save(author);
		// We add to already existing
		book.getAuthors().add(author);
	}
	
}
