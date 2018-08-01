package customermanagement.customer.service;

import customermanagement.customer.model.Customer;


public interface CustomerService {

    Iterable<Customer> findAll();

    void save(Customer customer);
}
