package com.example.furama_resort.dto;

import com.example.furama_resort.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class CustomerDto implements Validator {
    private int id;
    @Max(value = 50, message = "Tên không được vượt quá 50 kí tự")
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[A-Z]\\p{L}+(\\s[A-Z]\\p{L}*)+$", message = "Tên không được chứa số, các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String name;
    private String dateOfBirth;
    private int gender;
    @Size(min = 0, max = 50)
    @NotBlank(message = "CMND không được để trống")
    @Pattern(regexp = "(\\d{9})|(\\d{12})",message = "số cmnd phải đúng định dạng,vd:XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCard;
    @Size(min = 10, max = 10)
    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^([(]84[)][+])?09[0-1]\\d{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phoneNumber;
    @Size(min = 0, max = 50)
    @Email
    @Pattern(regexp = "[a-zA-Z]+\\w+@\\w+(\\.\\w+)+", message = "email phải đúng định dạng, vd: abc123@gmail.com")
    @NotBlank(message = "Email không được để trống")
    private String email;
    @Size(min = 0, max = 100)
    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
    }
}
