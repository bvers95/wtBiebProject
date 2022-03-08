package working.talent.bieb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import working.talent.bieb.model.LoanEvent;

@Repository
public interface LoanEventRepository extends JpaRepository<LoanEvent, Long> {

}
