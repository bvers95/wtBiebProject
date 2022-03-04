package working.talent.bieb.Books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
