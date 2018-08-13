package customermanagement.customer.dto;

import customermanagement.customer.model.Customer;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
