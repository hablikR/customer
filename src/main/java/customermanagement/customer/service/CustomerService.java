package customermanagement.customer.service;

import customermanagement.customer.dto.CustomerDTO;
import customermanagement.customer.model.Customer;

import java.util.List;

public interface CustomerService{

    List<CustomerDTO> findAll();

    void save(CustomerDTO customerDTO);

    boolean existById(Long id);

    void delete(Long id);

    CustomerDTO findByID (Long id);


}
