package customermanagement.customer;


import com.fasterxml.jackson.databind.ObjectMapper;
import customermanagement.customer.dto.CustomerDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerE2ETest {

    private int port = 8080;

    @Autowired
    private TestRestTemplate testRestTemplate;
    private HttpHeaders headers = new HttpHeaders();

    @Test
    public void testAddCustomer() throws Exception{
        CustomerDTO customerDTO = new CustomerDTO(new Long(22), "Jani", "Marokko", "655");

        String uri = "/api/customer";

        String inputInJson  =this.mapToJson(customerDTO);

        HttpEntity<CustomerDTO> entity= new HttpEntity<CustomerDTO>(customerDTO, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWthPort(uri), HttpMethod.POST,entity,String.class);

        String responseJson = response.getBody();
        assertThat(responseJson).isEqualTo(inputInJson);

    }


    private String mapToJson(Object object) throws  Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    private String formFullURLWthPort(String uri){
        return "http://localhost:" + port + uri;
    }
}
