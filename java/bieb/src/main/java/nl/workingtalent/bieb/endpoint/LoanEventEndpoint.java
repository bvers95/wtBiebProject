package nl.workingtalent.bieb.endpoint;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.bieb.model.LoanEvent;
import nl.workingtalent.bieb.repository.LoanEventService;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/loanevents")
public class LoanEventEndpoint {

	@Autowired
	private LoanEventService loanEventService;
	
	@GetMapping
	public List<LoanEvent> getAllLoanEvents() {
		return loanEventService.getAllLoanEvents();
	}
	
	@GetMapping(value = "id/{id}")
	public Optional<LoanEvent> getLoanEventById(@PathVariable Long id) {
		return loanEventService.getLoanEventById(id);
	}

	
	@PostMapping(value = "{accountId}/{bookItemId}")
	public LoanEvent createLoanEvent(@PathVariable Long accountId, @PathVariable Long bookItemId) {
		return loanEventService.createLoanEvent(bookItemId, accountId);
	}
}
