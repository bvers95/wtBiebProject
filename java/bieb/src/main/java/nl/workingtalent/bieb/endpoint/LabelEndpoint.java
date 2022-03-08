package nl.workingtalent.bieb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.bieb.model.Book;
import nl.workingtalent.bieb.repository.LabelService;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/labels")
public class LabelEndpoint {

	@Autowired
	private LabelService labelService;
	
}
