package working.talent.bieb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import working.talent.bieb.model.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
	
	
}
