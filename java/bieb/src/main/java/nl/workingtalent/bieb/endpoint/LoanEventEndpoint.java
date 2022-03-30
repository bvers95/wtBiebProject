package nl.workingtalent.bieb.endpoint;

import nl.workingtalent.bieb.model.LoanEvent;
import nl.workingtalent.bieb.repository.LoanEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

}
