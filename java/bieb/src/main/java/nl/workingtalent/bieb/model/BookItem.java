package nl.workingtalent.bieb.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BookItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate creationDate = LocalDate.now();

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

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public List<LoanEvent> getLoanEvents() {
		return loanEvents;
	}

	public void setLoanEvents(List<LoanEvent> loanEvents) {
		this.loanEvents = loanEvents;
	}
	
}
