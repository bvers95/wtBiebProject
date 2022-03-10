package nl.workingtalent.bieb.endpoint;

import nl.workingtalent.bieb.model.BookItem;
import nl.workingtalent.bieb.repository.BookItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/bookitems")
public class BookItemEndpoint {
	
	@Autowired
	private BookItemService bookItemService;

	@GetMapping
	public List<BookItem> getAllBookItems() {
		return bookItemService.getAllBookItems();
	}

	@GetMapping(value = "id/{id}")
	public Optional<BookItem> getBookItemById(@PathVariable Long id) {
		return bookItemService.getBookItemById(id);
	}

	@PostMapping
	public BookItem addBookItem(@RequestBody Long bookId) {
		return bookItemService.addBookItem(bookId);
	}
	
}
