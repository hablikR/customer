package customermanagement.customer.controller;

import customermanagement.customer.model.Customer;
import customermanagement.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController{


    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerServiceImpl) {
        this.customerService = customerServiceImpl;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Customer addNew(@RequestBody Customer customer){
        customerService.save(customer);
        return customer;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/findall")
    public String show(Model model){
        Iterable<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "show";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public String removeByID(@PathVariable(name= "id") Long id, Model model){
        model.addAttribute("customers", customerService.findByID(id));
        model.addAttribute("message", "Customer removed!");
        customerService.delete(id);
        return "show";
    }

    @RequestMapping(value = "/update/{newName}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateCustomerByID(@RequestParam(name = "id") Long pID, @PathVariable(value = "newName") String pName){

        return "show";
    }

}
