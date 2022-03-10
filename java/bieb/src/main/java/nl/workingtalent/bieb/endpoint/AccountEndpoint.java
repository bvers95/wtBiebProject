package nl.workingtalent.bieb.endpoint;

import nl.workingtalent.bieb.model.Account;
import nl.workingtalent.bieb.repository.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/accounts")
public class AccountEndpoint {

	@Autowired
	private AccountService accountService;
	
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
	
}
