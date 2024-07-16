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
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author usman
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int category_ID;
    @Column(length=50)
    private String category_name;
    @Column(length=2000)
    private String category_description;
    @OneToMany(mappedBy="category")
    private List<Product> products=new ArrayList<>();
    public Category(int category_ID, String category_name, String category_description,List<Product> products) {
        this.category_ID = category_ID;
        this.category_name = category_name;
        this.category_description = category_description;
        this.products=products;
    }

    public Category(String category_name, String category_description) {
        this.category_name = category_name;
        this.category_description = category_description;
    }

    public Category() {
    }

    public int getCategory_ID() {
        return category_ID;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_ID(int category_ID) {
        this.category_ID = category_ID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    @Override
    public String toString() {
        return "Category{" + "category_ID=" + category_ID + ", category_name=" + category_name + ", category_description=" + category_description + '}';
    }
    
    
}
        