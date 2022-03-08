package nl.workingtalent.bieb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.workingtalent.bieb.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
