package nl.benooms.reproduce;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ben Ooms on 2-8-16.
 */
@RestController
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        return "hello";
    }
}
