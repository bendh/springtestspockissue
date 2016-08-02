package nl.benooms.reproduce

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.*;

/**
 * Created by Ben Ooms on 2-8-2016.
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class spockAutowiredSpec extends Specification {

    @Autowired
    def WebApplicationContext context

    @Autowired
    TestRestTemplate restTemplate;

    def "Expect a injected context" (){
        expect:
            assert context
    }



    def "expect a injected test resttemplate" () {
        expect:
            assert restTemplate
    }

}