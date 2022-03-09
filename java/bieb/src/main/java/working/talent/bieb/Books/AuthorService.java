package working.talent.bieb.Books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorService {

	@Autowired
	private AuthorInterface authorInterface;
	
	public Optional<Author> findAuthor(Long id) {
		return authorInterface.findById(id);
	}
	
	public List<Author> findAllAuthors() {
		return authorInterface.findAll();
	}

	@Transactional // starts a JTA transaction when entering this method from the outside!!!
	public Author save(Author author) {
		return this.authorInterface.save(author);
	}
	
}
