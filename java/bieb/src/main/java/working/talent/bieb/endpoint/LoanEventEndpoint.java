package working.talent.bieb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import working.talent.bieb.repository.LoanEventService;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/loanevents")
public class LoanEventEndpoint {

	@Autowired
	private LoanEventService loanEventService;
	
	@GetMapping
	 public void testFunction() {
       System.out.println("test loan event");
   }
	
}
