package customermanagement.customer.service;

import customermanagement.customer.model.Customer;
import customermanagement.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> findAll() {
        return  this.customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }
}
