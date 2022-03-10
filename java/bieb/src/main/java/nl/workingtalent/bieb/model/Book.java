package nl.workingtalent.bieb.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique=true)
	private String isbn;

	private String title;

	private String language;

	private String description;

	@Column(unique=true)
	private String coverUrl;

	private Integer publishYear;

	private String nameAuthor;

	private Boolean isPhysical;

	@ManyToMany
	private List<Label> labels;

	@OneToMany(mappedBy="book")
	private List<BookItem> bookItems;

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

	public void setIsPhysical(Boolean isPhysical) {
		this.isPhysical = isPhysical;
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
