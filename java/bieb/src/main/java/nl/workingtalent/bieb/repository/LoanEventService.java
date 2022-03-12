package nl.workingtalent.bieb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import nl.workingtalent.bieb.model.Account;
import nl.workingtalent.bieb.model.BookItem;
import nl.workingtalent.bieb.model.LoanEvent;

@Service
public class LoanEventService {

	@Autowired
	private LoanEventRepository loanEventRepo;
	
	@Autowired
	private BookItemRepository bookItemRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	public List<LoanEvent> getAllLoanEvents(){
		List<LoanEvent> allLoanEvents = loanEventRepo.findAll();
		return allLoanEvents;
	}
	
	public Optional<LoanEvent> getLoanEventById(Long id) {
		Optional<LoanEvent> foundLoanEvent = loanEventRepo.findById(id);
		return foundLoanEvent;
	}
	
	public LoanEvent createLoanEvent(Long bookItemId, Long accountId) {
		
		LoanEvent newLoanEvent = new LoanEvent();

		// Check if the bookItem associated with the event actually exists
		BookItem expectedBookItem = bookItemRepo.findById(bookItemId).orElseThrow(
				// Or else we throw an internal server error like the other errors
				() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)
				);
		
		// Check if the account associated with the event actually exists
		Account expectedAccount = accountRepo.findById(accountId).orElseThrow(
				// Or else we throw an internal server error like the other errors
				() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)
				);
		
		newLoanEvent.setAccount(expectedAccount);
		newLoanEvent.setBookItem(expectedBookItem);
		loanEventRepo.save(newLoanEvent);
		return newLoanEvent;
	}
	
	

}
