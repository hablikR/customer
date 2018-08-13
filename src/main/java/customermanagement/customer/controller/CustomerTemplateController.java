package customermanagement.customer.controller;

import customermanagement.customer.dto.CustomerDTO;
import customermanagement.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerTemplateController {

    private CustomerService customerService;

    @Autowired
    public CustomerTemplateController(CustomerService customerServiceImpl) {
        this.customerService = customerServiceImpl;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model){
        Iterable<CustomerDTO> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "show";
    }
}
