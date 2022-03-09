package working.talent.bieb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("integrationtest") // runs in the integrationtest env (application-integrationtest.properties is used)
class BiebApplicationIT { // the postfix IT is a tick for the failsafe plugin to run this during the maven integration-test lifecycle phase

	@Test
	void contextLoads() {
	}
}
