package working.talent.bieb.Books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping("/api/author/{authorId}")
	public Optional<Author> getAuthor(@PathVariable Long authorId) {
		return authorService.findAuthor(authorId);
	}
	
	@RequestMapping("/api/authors")
	public List<Author> getAllAuthors() {
		return authorService.findAllAuthors();
	}
	
}
