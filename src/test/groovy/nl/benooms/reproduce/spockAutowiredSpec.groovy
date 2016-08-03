package nl.benooms.reproduce

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

/**
 * Created by Ben Ooms on 2-8-2016.
 *
 */
@SpringApplicationConfiguration(SpringtestSpockIssueApplication)
@WebIntegrationTest(randomPort = true)
class spockAutowiredSpec extends Specification {

    @Autowired
    def WebApplicationContext context

    @Autowired
     TestRestTemplate restTemplate

    def "Expect a injected context" (){
        expect:
            assert context
    }

    def "expect a injected test resttemplate" () {
        expect:
            assert restTemplate
    }

    def "Expect get http call to /hello returns hello" () {
        when:
            def response = restTemplate.getForObject("/hello", String.class)
        then:
            assert response == 'hello'
    }



}