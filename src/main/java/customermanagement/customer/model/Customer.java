package customermanagement.customer.model;

import customermanagement.customer.dto.CustomerDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.text.DefaultEditorKit;
import java.util.Comparator;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    public Customer() {
    }

    public Customer(CustomerDTO customerDTO){

        this.id = customerDTO.getId();
        this.name  =customerDTO.getName();
        this.address  = customerDTO.getAddress();
        this.phone = customerDTO.getPhone();
    }

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
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
