package nl.benooms.reproduce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;


/**
 * Created by Ben Ooms on 3-8-16.
 */
@JsonTest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductVOJsonTests {

    @Autowired
    private JacksonTester<ProductVO> productVOJacksonTester;

    @Test
    public void testSerializeProductVO() throws IOException {
        ProductVO productVO = new ProductVO("product one", new BigDecimal(10));

        assertThat(this.productVOJacksonTester.write(productVO)).hasJsonPathStringValue("@.name");
    }
}
