package working.talent.bieb.Books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookInterface extends JpaRepository<Book, Long> {
	
}
