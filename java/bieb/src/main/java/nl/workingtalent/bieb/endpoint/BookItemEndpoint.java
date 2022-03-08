package nl.workingtalent.bieb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.bieb.model.Book;
import nl.workingtalent.bieb.model.BookItem;
import nl.workingtalent.bieb.repository.BookItemService;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/bookitems")
public class BookItemEndpoint {
	
	@Autowired
	private BookItemService bookItemService;
	
	//@PostMapping(value="/add/{bookId}")
	//public Book addNewBookItem(@PathVariable Long bookId) {
		//return bookItemService.addNewBookItem(bookItem);
	//}
	
}
