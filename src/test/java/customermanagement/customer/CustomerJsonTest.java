package customermanagement.customer;


import customermanagement.customer.dto.CustomerDTO;
import customermanagement.customer.service.CustomerService;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;

import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@org.springframework.boot.test.autoconfigure.json.JsonTest
public class CustomerJsonTest {

    @Autowired
    private JacksonTester<CustomerDTO> json;

    @Test
    public void customerObjectEqual() throws Exception {
        String content = "{\"id\":\"1\",\"name\":\"Sanyi\",\"address\":\"Sirok\",\"phone\":\"01234567889\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new CustomerDTO(new Long(1),"Sanyi", "Sirok",
                        "0123456789"));
    }

    @Test
    public void customerObjectEqual2() throws Exception {
        String content = "{\"id\":\"1\",\"name\":\"Sanyi\",\"address\":\"Sirok\",\"phone\":\"01234567889\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new CustomerDTO(new Long(1),"Sanyo", "Sirok",
                        "0123456789"));
    }
    @Test
    public void customerObjectNotEqual() throws Exception {
        String content = "{\"id\":\"1\",\"name\":\"Sanyi\",\"address\":\"Sirok\",\"phone\":\"01234567889\"}";
        assertThat(this.json.parse(content))
                .isNotEqualTo(new CustomerDTO(new Long(3),"Sanyo", "Sirok",
                        "0123456789"));
    }

    @Test
    public void customerIDtest() throws Exception {
        String content = "{\"id\":\"1\",\"name\":\"Sanyi\",\"address\":\"Sirok\",\"phone\":\"01234567889\"}";
        assertThat(this.json.parseObject(content).getId()).isEqualTo(Long.parseLong("1"));
    }
}

