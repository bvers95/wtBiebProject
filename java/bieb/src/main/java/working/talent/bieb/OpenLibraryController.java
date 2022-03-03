package working.talent.bieb;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OpenLibraryController {
	
	@RequestMapping(value = "/library/{search}", produces = "application/json")
	public String SearchOpenLibrary(@PathVariable String search) {
		
		String query = "https://openlibrary.org/search.json?q=" + search;
		RestTemplate searchOpenLibrary = new RestTemplate();
		String results = searchOpenLibrary.getForObject(query, String.class);
		return results;
		
	}
	
}
