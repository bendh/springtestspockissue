package nl.benooms.reproduce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


// entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringtestSpockIssueApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testInjectionOfRestTemplate() {
		assertThat(testRestTemplate).isNotNull();
	}

}
