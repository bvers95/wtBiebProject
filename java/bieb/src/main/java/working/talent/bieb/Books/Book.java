package working.talent.bieb.Books;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Book {
		
	@Id
	private Long isbn;

	private String title;
	
	/* As the book entity is our main entity we join the 
	tables from here and we name the table and columns of
	the new junction table that is created for us */
	@ManyToMany
	@JoinTable(
		name = "bookAuthor", 
		joinColumns = @JoinColumn(name = "isbn"), 
		inverseJoinColumns = @JoinColumn(name = "authorId"))
	private Set<Author> author;
	
	private String language;
	
	private String description;
	
	private Boolean isPhysical;

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Author> getAuthor() {
		return author;
	}

	public void setAuthor(Set<Author> author) {
		this.author = author;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsPhysical() {
		return isPhysical;
	}

	public void setIsPhysical(Boolean isPhysical) {
		this.isPhysical = isPhysical;
	}
	
}
