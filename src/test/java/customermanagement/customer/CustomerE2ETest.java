package customermanagement.customer;


import com.fasterxml.jackson.databind.ObjectMapper;
import customermanagement.customer.dto.CustomerDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations="classpath:test.properties")
public class CustomerE2ETest {

    private int port = 8080;

    @Autowired
    private TestRestTemplate testRestTemplate;
    private HttpHeaders headers = new HttpHeaders();


   @Before
    @Test
    public void testAddCustomerMoreitem() throws Exception{

        List<CustomerDTO> customerDTO = new ArrayList<CustomerDTO>();
        CustomerDTO item1 = new CustomerDTO(new Long(1), "Jani", "Marokko", "655");
        CustomerDTO item2 = new CustomerDTO(new Long(2), "Sanyi", "Athen", "599");
        customerDTO.add(item1);
        customerDTO.add(item2);

        for(CustomerDTO item : customerDTO){

            String uri = "/api/customer";

            String inputInJson  =this.mapToJson(item);

            HttpEntity<CustomerDTO> entity= new HttpEntity<CustomerDTO>(item, headers);
            ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWthPort(uri), HttpMethod.POST,entity,String.class);

            String responseJson = response.getBody();
            assertThat(responseJson).isEqualTo(inputInJson);

        }
    }


    @Test
    public void testGetCustomer() throws Exception{
        List<CustomerDTO> customerDTO = new ArrayList<CustomerDTO>();
        CustomerDTO item = new CustomerDTO(new Long(1), "Jani", "Marokko", "655");
        CustomerDTO item2 = new CustomerDTO(new Long(2), "Sanyi", "Athen", "599");

        customerDTO.add(item);
        customerDTO.add(item2);

        String uri ="/api/customer/show";

        String inputInJson  =this.mapToJson(customerDTO);

        HttpEntity<List<CustomerDTO>> entity = new HttpEntity<>(customerDTO,headers);
        ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWthPort(uri), HttpMethod.GET,entity,String.class);

        String responseJson = response.getBody();
        assertThat(responseJson).isEqualTo(inputInJson);
    }


    @Test
    public void testGetCustomerByID() throws Exception{
        CustomerDTO customerDTO = new CustomerDTO(new Long(1), "Jani", "Marokko", "655");

        int id = 1;
        String uri ="/api/customer/show/" + id;

        String inputInJson  =this.mapToJson(customerDTO);

        HttpEntity<CustomerDTO> entity = new HttpEntity<CustomerDTO>(customerDTO,headers);
        ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWthPort(uri), HttpMethod.GET,entity,String.class);

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
