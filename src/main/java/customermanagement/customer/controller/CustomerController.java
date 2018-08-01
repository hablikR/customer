package customermanagement.customer.controller;

import customermanagement.customer.model.Customer;
import customermanagement.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {


    private final CustomerServiceImpl customerServiceImpl;

    @Autowired
    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public Iterable<Customer> findAllCustomer()
    {
        return this.customerServiceImpl.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Customer addNew(@RequestBody Customer customer){
        customerServiceImpl.save(customer);
        return customer;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/find")
    public String show(Model model){
        Iterable<Customer> customerList = customerServiceImpl.findAll();
        model.addAttribute("customers", customerList);
        return "show";
    }


}
