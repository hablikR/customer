package customermanagement.customer.controller;

import customermanagement.customer.dto.CustomerDTO;
import customermanagement.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/customer")
public class CustomerController{

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerServiceImpl) {
        this.customerService = customerServiceImpl;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public CustomerDTO addNew(@RequestBody CustomerDTO customer){
        customerService.save(customer);
        return customer;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public void updateCustomerByID(@RequestBody CustomerDTO customer){
        customerService.updateService(customer);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeByID(@PathVariable(value = "id") Long id){
        customerService.delete(id);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)

    public List<CustomerDTO> show(){
        Iterable<CustomerDTO> customerList = customerService.findAll();
        return (List<CustomerDTO>) customerList;
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CustomerDTO showByID (@PathVariable(value = "id")Long id){
        CustomerDTO customerDTO = customerService.findByID(id);
            return customerDTO;
    }
}
