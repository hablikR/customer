package customermanagement.customer;

import customermanagement.customer.controller.CustomerController;
import customermanagement.customer.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerApplicationTests {

    private final CustomerService customerService = null;

    @Autowired
    CustomerController customerController = new CustomerController(customerService);

    @Test
        public void contextLoads() throws Exception{
            assertThat(customerController).isNotNull();
    }




    
}

