/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.dao;
import com.mycompany.mavenproject3.entities.Product;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author usman
 */
public class ProductDao {
      private SessionFactory factory;

    public ProductDao(SessionFactory factory) {
        this.factory = factory;
    }
    public boolean saveProduct(Product product){
        boolean f=false;
        try{
            Session session =this.factory.openSession();
            Transaction tx= session.beginTransaction();
            session.save(product);
            tx.commit();
            session.close();
            f=true;
        }
        catch(Exception e){
            e.printStackTrace();
            f=false;
        }
        return f;
    }
    public List<Product> getAllProducts(){
        Session s = this.factory.openSession();
        Query query= s.createQuery("from Product");
        List<Product> list=query.getResultList();
        return list;
        
    }
    
     public List<Product> getAllProductsByID(int cid){
        Session s = this.factory.openSession();
        Query query= s.createQuery("from Product as p where p.category.category_ID =: id");
        query.setParameter("id",cid);
        List<Product> list=query.getResultList();
        return list;
        
    }
}
