package nl.workingtalent.bieb.endpoint;

import nl.workingtalent.bieb.model.Account;
import nl.workingtalent.bieb.model.LoanEvent;
import nl.workingtalent.bieb.repository.AccountService;
import nl.workingtalent.bieb.repository.LoanEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/accounts")
public class AccountEndpoint {

	@Autowired
	private AccountService accountService;

	@Autowired
	private LoanEventService loanEventService;
	
	@GetMapping
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
    }

	@GetMapping(value = "id/{id}")
	public Optional<Account> getAccountById(@PathVariable Long id) {
		return accountService.getAccountById(id);
	}

	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}

	@PostMapping(value = "{accountId}/bookitem/{bookItemId}")
	public LoanEvent createLoanEvent(@PathVariable Long accountId, @PathVariable Long bookItemId) {
		return loanEventService.createLoanEvent(bookItemId, accountId);
	}

}
