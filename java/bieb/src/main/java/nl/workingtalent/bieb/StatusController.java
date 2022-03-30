package nl.workingtalent.bieb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class StatusController {
	
	@RequestMapping(value = "/status")
	public LocalDateTime status() {
		return LocalDateTime.now();
	}
	
}
