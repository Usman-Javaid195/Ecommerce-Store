/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author usman
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int customer_id;
    @Column(length=20)
    private String customer_Name;
   
        @Column(length=100)
    
    private String email;
        @Column(length=1500)
    private String address;
    private String password;
      @Column(length=14)
    private String phonenumber;
    @Column(name="user_type")
    String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    public Customer(int customer_id, String customer_Name, String email, String address, String password, String phonenumber, String userType) {
        this.customer_id = customer_id;
        this.customer_Name = customer_Name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.phonenumber = phonenumber;
        this.userType=userType;
    }

    public Customer(String customer_Name, String email, String address, String password, String phonenumber,String userType) {
        this.customer_Name=customer_Name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.phonenumber = phonenumber;
        this.userType=userType;
    }

    public Customer() {
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setFirst_name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "customer_id=" + customer_id + ", customer_Name=" + customer_Name + ", email=" + email + ", address=" + address + ", password=" + password + ", phonenumber=" + phonenumber + '}';
    }
    
}
