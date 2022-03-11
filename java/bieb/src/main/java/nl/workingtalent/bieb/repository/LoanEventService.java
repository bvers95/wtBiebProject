package nl.workingtalent.bieb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanEventService {

	@Autowired
	private LoanEventRepository loanEventRepo;
	
}
