package customermanagement.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import customermanagement.customer.dto.CustomerDTO;
import customermanagement.customer.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc(secure = false)
public class CustomerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void contextLoad(){
        assertThat(customerService).isNotNull();
    }
    //
    @Test
        public void findAllTest() throws Exception{
        Mockito.when(customerService.findAll()).thenReturn(
                Collections.emptyList()
        );
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("" +
                "http://localhost:8080/customer/show/")
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println(mvcResult.getResponse());

        Mockito.verify(customerService).findAll();
    }


    @Test
    public void showTest() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO(new Long(1),"Sanyi","Mars","022");

        this.mockMvc.perform(get("http://localhost:8080/api/customer/show/" + customerDTO.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void postTest() throws Exception {

    CustomerDTO customerDTO = new CustomerDTO(new Long(2),"Feri","Mars","022");

        this.mockMvc.perform(post("http://localhost:8080/api/customer/")
        .content(toJason(customerDTO))
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception {

        this.mockMvc.perform(delete("http://localhost:8080/api/customer/" +1))
                .andExpect(status().isOk());
    }

    @Test
    public void updateTest() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO(new Long(2),"Feri","Mars","022");

        this.mockMvc.perform(put("http://localhost:8080/api/customer/")
                .content(toJason(customerDTO))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    private byte[] toJason(CustomerDTO cDTO) throws Exception
    {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(cDTO).getBytes();

    }




    
}

