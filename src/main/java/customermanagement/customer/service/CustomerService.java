package customermanagement.customer.service;

import customermanagement.customer.model.Customer;

import java.util.Optional;

public interface CustomerService{

    Iterable<Customer> findAll();

    void save(Customer customer);

    boolean existById(Long id);

    void delete(Long id);

    Optional<Customer> findByID (Long id);


}
