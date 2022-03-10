package nl.workingtalent.bieb.endpoint;

import nl.workingtalent.bieb.repository.BookItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
