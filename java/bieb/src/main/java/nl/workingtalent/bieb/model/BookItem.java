package nl.workingtalent.bieb.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class BookItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime creationDateTime = LocalDateTime.now();

	private LocalDateTime removalDate;

	@OneToMany(mappedBy="bookItem")
	private List<LoanEvent> loanEvents;
	
	@ManyToOne
	private Book book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public LocalDateTime getRemovalDate() {
		return removalDate;
	}

	public void setRemovalDate(LocalDateTime removalDate) {
		this.removalDate = removalDate;
	}

	public List<LoanEvent> getLoanEvents() {
		return loanEvents;
	}

	public void setLoanEvents(List<LoanEvent> loanEvents) {
		this.loanEvents = loanEvents;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
