package nl.benooms.reproduce;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.web.client.LocalHostUriTemplateHandler;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ben Ooms on 2-8-16.
 */
@SpringBootApplication
public class TestConfiguration {
    @Autowired
    ApplicationContext applicationContext;

    /**
     * Borowed from org.springframework.boot.test.context.SpringBootTestContextCustomizer
     *
     */
    @Bean
    TestRestTemplate restTemplate(){
        RestTemplateBuilder builder = getRestTemplateBuilder(applicationContext);
        TestRestTemplate template = new TestRestTemplate(builder.build());
        template.setUriTemplateHandler(
                new LocalHostUriTemplateHandler(applicationContext.getEnvironment()));
        return template;
    }

    private RestTemplateBuilder getRestTemplateBuilder(
            ApplicationContext applicationContext) {
        try {
            return applicationContext.getBean(RestTemplateBuilder.class);
        }
        catch (NoSuchBeanDefinitionException ex) {
            return new RestTemplateBuilder();
        }
    }
}
