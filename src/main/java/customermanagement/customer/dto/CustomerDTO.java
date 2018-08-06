package customermanagement.customer.dto;

import customermanagement.customer.model.Customer;

public class CustomerDTO {

    private Long id;

    private String name;

    private String address;

    private String phone;

    public CustomerDTO(Long id,  String name, String address, String phone) {
        this.id =id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public CustomerDTO(Customer customer){
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
    }

    public CustomerDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
