package customermanagement.customer.controller;

import customermanagement.customer.dto.CustomerDTO;
import customermanagement.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController{


    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerServiceImpl) {
        this.customerService = customerServiceImpl;
    }

  /*
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CustomerDTO addNew(@RequestBody CustomerDTO customer){
        customerService.save(customer);
        return customer;
    }
*/
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/show")
    public String show(Model model){
        Iterable<CustomerDTO> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "show";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeByID(@RequestParam("id") Long id){
        customerService.delete(id);
        return "modify";
    }

    @GetMapping(value ="/remove")
    public String deleteResult(Model model){
        model.addAttribute("remove", "Done!");
        return "modify";
    }

    @GetMapping(value = "/add")
    public String addNew(Model model){
        model.addAttribute("add", new CustomerDTO());
        return "modify";
    }

   @PostMapping(value = "/add")
    public String addNew(@ModelAttribute("customerDTO")  CustomerDTO customerDTO, ModelMap map ){
        customerService.save(customerDTO);
        return "modify";
    }

    @RequestMapping(value = "/update/{newName}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateCustomerByID(@RequestParam(name = "id") Long pID, @PathVariable(value = "newName") String pName){
        return "show";
    }

}
