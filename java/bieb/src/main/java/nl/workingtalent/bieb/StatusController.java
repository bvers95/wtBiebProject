package nl.workingtalent.bieb;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	@RequestMapping(value = "/status")
	public Date status() {
		return new Date();
	}
	
}
