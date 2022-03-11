package nl.workingtalent.bieb.endpoint;

import nl.workingtalent.bieb.model.Label;
import nl.workingtalent.bieb.repository.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/labels")
public class LabelEndpoint {

	@Autowired
	private LabelService labelService;

	@GetMapping
	public List<Label> getAllLabels() {
		return labelService.getAllLabels();
	}

	@GetMapping(value = "id/{id}")
	public Optional<Label> getLabelById(@PathVariable Long id) {
		return labelService.getLabelById(id);
	}

	@PostMapping
	public Label createLabel(@RequestBody Label label) {
		return labelService.createLabel(label);
	}
	
}
