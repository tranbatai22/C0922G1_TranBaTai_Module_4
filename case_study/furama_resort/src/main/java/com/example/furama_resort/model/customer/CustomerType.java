package com.example.furama_resort.model.customer;

import com.example.furama_resort.model.customer.Customer;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerTypeId;
    @Size(min = 0, max = 50)
    @NonNull
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customerSet;

    public CustomerType() {
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    @NonNull
    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(@NonNull String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
