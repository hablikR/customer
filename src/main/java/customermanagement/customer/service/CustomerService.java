package customermanagement.customer.service;

import customermanagement.customer.model.Customer;
import java.util.List;


public interface CustomerService {

    List<Customer> findAll();

    void save(Customer customer);
}
