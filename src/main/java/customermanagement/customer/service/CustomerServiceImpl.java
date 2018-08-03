package customermanagement.customer.service;

import customermanagement.customer.dto.CustomerDTO;
import customermanagement.customer.model.Customer;
import customermanagement.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
        return null;

    }

    @Override
    public void save(CustomerDTO customerDTO) {
        Customer customer = new Customer();
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


    public CustomerDTO convertToDTO(Customer customer){
        CustomerDTO custDTO = new CustomerDTO();

        custDTO.id = customer.getId();
        custDTO.name= customer.getName();
        custDTO.address = customer.getAddress();
        custDTO.phone = customer.getPhone();

        return  custDTO;
    }

    public List<CustomerDTO> convertToDTOList(List<Customer> customerList){
      List<CustomerDTO> dtoList = new ArrayList<CustomerDTO>();
        for(Customer c : customerList){
            dtoList.add(convertToDTO(c));
        }
        return dtoList;
    }


}
