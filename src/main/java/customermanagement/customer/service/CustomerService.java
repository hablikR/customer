package customermanagement.customer.service;

import customermanagement.customer.dto.CustomerDTO;

import java.util.List;

public interface CustomerService{

    /**
     * Return with the all customer
     *
     * @return List<CustomerDTO></CustomerDTO>
     */
     List<CustomerDTO> findAll();

    /**
     *Sava a new Customer in the table
     * @param customerDTO  = new CustomerDTO
     */
    void save(CustomerDTO customerDTO);

    /**
     *Check the customer by
     * @param id = CustomerDTO.id
     * @return if exis, return true
     */
    boolean existById(Long id);

    /**
     *Delete a row from the table by ID
     * @param id
     */
    void delete(Long id);

    /**
     * Find a customer by
     * @param id = CustomerDTO.id
     * and
     * @return with one customer.
     */
    CustomerDTO findByID (Long id);

    /**
     * Check a customer. If it is exist, update the Name, Address and Phone.
     * @param customer = a customer who is exist with a same ID but different name, address, or phone.
     */
    void updateService(CustomerDTO customer);
}
