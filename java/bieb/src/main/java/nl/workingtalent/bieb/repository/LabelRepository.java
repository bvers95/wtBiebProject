package nl.workingtalent.bieb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.workingtalent.bieb.model.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
	
	
}
