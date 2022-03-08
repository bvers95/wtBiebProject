package working.talent.bieb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import working.talent.bieb.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
