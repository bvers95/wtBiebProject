package nl.workingtalent.bieb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.workingtalent.bieb.model.BookItem;

@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Long> {

}
