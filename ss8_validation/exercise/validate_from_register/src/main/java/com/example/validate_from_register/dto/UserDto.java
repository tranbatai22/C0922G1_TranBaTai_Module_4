package com.example.validate_from_register.dto;

import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto{
    private int id;

    @NotBlank(message = "không được để trống")
    @Size(min = 5, max = 45,message = "Tên tối thiểu 5 kí tự và tối đa 45 kí tự.")
    private String firstNameLastName;
    @Pattern(regexp = "/((09|03|07|08|05)+([0-9]{8})\\b)/g", message = "Số điện thoại không đúng định dạng")
    private String phoneNumber;
    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    private int age;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email không đúng định dạng")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstNameLastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstNameLastName = firstNameLastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstNameLastName() {
        return firstNameLastName;
    }

    public void setFirstNameLastName(String firstNameLastName) {
        this.firstNameLastName = firstNameLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
