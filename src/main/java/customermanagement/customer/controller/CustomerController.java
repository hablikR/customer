package customermanagement.customer.controller;

import customermanagement.customer.dto.CustomerDTO;
import customermanagement.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    public void addNew(@RequestBody CustomerDTO customer){
        customerService.save(customer);
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


}
