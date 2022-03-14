package nl.workingtalent.bieb.repository;

import nl.workingtalent.bieb.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

    Optional<Label> findByNameIgnoreCase(String name);
	
}
