package nl.workingtalent.bieb.repository;

import nl.workingtalent.bieb.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepo;

	public List<Account> getAllAccounts() {
		List<Account> allAccounts = accountRepo.findAll();
		return allAccounts;
	}

	public Optional<Account> getAccountById(Long id) {
		Optional<Account> foundAccount = accountRepo.findById(id);
		return foundAccount;
	}

	public Account createAccount(Account account) {
		Account newAccount = new Account();
		// Some fields are empty
		if (account.someEmpty()) {
			// Meaning we throw an internal server error like the other errors
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// Check if the email that is used to create an account is already used
		if (accountRepo.findByEmailIgnoreCase(account.getEmail()).isPresent()) {
			// Or else we throw an internal server error like the other errors
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// We ignore all input other than email
		newAccount.setEmail(account.getEmail());
		accountRepo.save(newAccount);
		return newAccount;
	}
	
}
