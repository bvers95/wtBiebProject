package nl.workingtalent.bieb.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDateTime;

@Entity
public class LoanEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime reserveDate;
	
	private LocalDateTime loanDate;
	
	private LocalDateTime returnDate;
	
	// Reference annotation to avoid infinite loop with ManyToOne relationship => LoanEvent is child of parents Account and BookItem 
	@JsonBackReference
	@ManyToOne
	private Account account;
	
	@JsonBackReference
	@ManyToOne
	private BookItem bookItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(LocalDateTime reserveDate) {
		this.reserveDate = reserveDate;
	}

	public LocalDateTime getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDateTime loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public BookItem getBookItem() {
		return bookItem;
	}

	public void setBookItem(BookItem bookItem) {
		this.bookItem = bookItem;
	}

}
