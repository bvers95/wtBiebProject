package nl.workingtalent.bieb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
//@JsonIgnoreProperties("book")
public class BookItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime creationDateTime = LocalDateTime.now();

	private LocalDateTime removalDate;

	// Reference annotation to avoid infinite loop with ManyToOne relationship => LoanEvent is child of parents Account and BookItem 
	@JsonManagedReference
	@OneToMany(mappedBy="bookItem")
	private List<LoanEvent> loanEvents;
	
	@JsonBackReference
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
