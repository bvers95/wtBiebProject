package nl.workingtalent.bieb.repository;

import nl.workingtalent.bieb.model.Book;
import nl.workingtalent.bieb.model.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {

	@Autowired
	private LabelRepository labelRepo;

	@Autowired
	private BookRepository bookRepo;

	public List<Label> getAllLabels() {
		List<Label> allLabels = labelRepo.findAll();
		return allLabels;
	}

	public Optional<Label> getLabelById(Long id) {
		Optional<Label> foundLabel = labelRepo.findById(id);
		return foundLabel;
	}

	public Label createLabel(Label label) {
		Label newLabel = new Label();
		// Some fields are empty
		if (label.someEmpty()) {
			// Meaning we throw an internal server error like the other errors
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// Check if the name that is used to create a label is already used
		if (labelRepo.findByNameIgnoreCase(label.getName()).isPresent()) {
			// Or else we throw an internal server error like the other errors
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// Only use the name from the post
		newLabel.setName(label.getName());
		labelRepo.save(newLabel);
		return newLabel;
	}

	public Label assignLabel(Long bookId, Long labelId) {
		// Check if the book we want to add a label to exists
		Book expectedBook = bookRepo.findById(bookId).orElseThrow(
			// Or else we throw an internal server error like the other errors
			() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)
		);
		// Check if the label we want to add to a book does exist
		Label expectedLabel = labelRepo.findById(labelId).orElseThrow(
				// Or else we throw an internal server error like the other errors
				() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)
		);
		List<Label> currentLabels = expectedBook.getLabels();
		// check if the label already exists in list
		if (currentLabels.contains(expectedLabel)) {
			// Or else we throw an internal server error like the other errors
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// Add the label to current list
		currentLabels.add(expectedLabel);
		expectedBook.setLabels(currentLabels);
		bookRepo.save(expectedBook);
		return expectedLabel;
	}
	
}
