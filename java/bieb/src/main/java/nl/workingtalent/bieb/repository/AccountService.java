package nl.workingtalent.bieb.repository;

import nl.workingtalent.bieb.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

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
		// We ignore all input other than email
		newAccount.setEmail(account.getEmail());
		accountRepo.save(newAccount);
		return newAccount;
	}
	
}
