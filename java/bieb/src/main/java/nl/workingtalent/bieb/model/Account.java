package nl.workingtalent.bieb.model;

import org.apache.commons.lang3.RandomStringUtils;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true,
			nullable = false)
	private String email;

	@Column(nullable = false)
	private String password = RandomStringUtils.random(32, true, true);

	@Column(nullable = false)
	private LocalDateTime creationDateTime = LocalDateTime.now();

	@Column(nullable = false)
	private AccountStatus status = AccountStatus.ACTIVE;

	@Column(nullable = false)
	private Boolean isAdmin = false;
	
	// Reference annotation to avoid infinite loop with ManyToOne relationship => LoanEvent is child of parents Account and BookItem 
	@JsonManagedReference
	@OneToMany(mappedBy="account")
	private List<LoanEvent> loanEvents;

	public enum AccountStatus {
		ACTIVE, FROZEN
	}

	public boolean someEmpty() {
		return (this.email == null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public Boolean getAdmin() {
		return isAdmin;
	}

	public void setAdmin(Boolean admin) {
		isAdmin = admin;
	}

	public List<LoanEvent> getLoanEvents() {
		return loanEvents;
	}

	public void setLoanEvents(List<LoanEvent> loanEvents) {
		this.loanEvents = loanEvents;
	}

}
