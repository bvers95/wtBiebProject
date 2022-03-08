package nl.workingtalent.bieb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.workingtalent.bieb.model.LoanEvent;

@Repository
public interface LoanEventRepository extends JpaRepository<LoanEvent, Long> {

}
