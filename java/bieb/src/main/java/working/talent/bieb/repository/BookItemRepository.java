package working.talent.bieb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import working.talent.bieb.model.BookItem;

@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Long> {

}
