package working.talent.bieb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import working.talent.bieb.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
