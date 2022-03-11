package nl.workingtalent.bieb.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true,
			nullable = false)
	private String isbn;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String language;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String coverUrl;

	@Column(nullable = false)
	private Integer publishYear;

	@Column(nullable = false)
	private String nameAuthor;

	@Column(nullable = false)
	private Boolean isPhysical;

	@ManyToMany
	private List<Label> labels;

	@OneToMany(mappedBy="book")
	private List<BookItem> bookItems;

	public boolean someEmpty() {
		return (this.isbn == null
			|| this.title == null
			|| this.language == null
			|| this.description == null
			|| this.coverUrl == null
			|| this.publishYear == null
			|| this.nameAuthor == null
			|| this.isPhysical == null
		);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public Integer getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Integer publishYear) {
		this.publishYear = publishYear;
	}

	public String getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	public Boolean getIsPhysical() {
		return isPhysical;
	}

	public void setIsPhysical(Boolean physical) {
		isPhysical = physical;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	public List<BookItem> getBookItems() {
		return bookItems;
	}

	public void setBookItems(List<BookItem> bookItems) {
		this.bookItems = bookItems;
	}

}
