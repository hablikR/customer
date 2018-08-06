package customermanagement.customer.service;

import customermanagement.customer.dto.CustomerDTO;
import customermanagement.customer.model.Customer;
import customermanagement.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return  convertToDTOList((List<Customer>) this.customerRepository.findAll());
    }

    @Override
    public CustomerDTO findByID(Long id) {
        Optional<Customer> customer = this.customerRepository.findById(id);
        if(customer.isPresent()){
            return convertToDTO(customer.get());
        }
        else {
            return null;
        }
    }

    @Override
    public void save(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO);
        this.customerRepository.save(customer);
    }

    @Override
    public boolean existById(Long id) {
        return this.customerRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public void updateService(CustomerDTO customerDTO){
        if(existById(customerDTO.getId())) {
            this.save(customerDTO);
        }
    }

    private CustomerDTO convertToDTO(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getName(),customer.getAddress(),customer.getPhone());
    }

    private List<CustomerDTO> convertToDTOList(List<Customer> customerList){
      List<CustomerDTO> dtoList = new ArrayList<CustomerDTO>();
        for(Customer c : customerList){
            dtoList.add(convertToDTO(c));
        }
        return dtoList;
    }


}
