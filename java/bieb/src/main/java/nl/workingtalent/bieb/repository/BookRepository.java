package nl.workingtalent.bieb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.workingtalent.bieb.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
