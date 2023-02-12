package com.example.furama_resort.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String userName;
    private String passWord;
    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_name"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;

    public User() {
    }

    public User(String userName, String passWord, Set<Role> roleSet) {
        this.userName = userName;
        this.passWord = passWord;
        this.roleSet = roleSet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
