package working.talent.bieb.Books;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Book {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long isbn;

	private String title;

	/* As the book entity is our main entity we join the
	tables from here and we name the table and columns of
	the new junction table that is created for us */
	@ManyToMany
	/*@JoinTable(
		name = "bookAuthor", 
		joinColumns = @JoinColumn(name = "isbn"), 
		inverseJoinColumns = @JoinColumn(name = "authorId"))*/
	// zoals gezegd dan gewoon authorId => Author::id en klaar...
	private Set<Author> authors;
	
	private String language;
	
	private String description;
	
	private Boolean isPhysical;

	@PrePersist
	public void init() {
		System.out.println("This will be executed just before a Book is persisted");

		// this.creationDate = LocalDate.now();
	}

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

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
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
