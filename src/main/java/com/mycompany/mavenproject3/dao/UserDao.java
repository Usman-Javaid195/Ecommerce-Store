
package com.mycompany.mavenproject3.dao;

import com.mycompany.mavenproject3.entities.Customer;
import jakarta.persistence.*;
import org.hibernate.*;


public class UserDao {
    private SessionFactory factory;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }

    public Customer getUserEmailAndPasword(String email, String password){
        Customer user =null;
        try{
            String query="from Customer where email =: e and password =: p";
            Session session=this.factory.openSession();
            Query q=session.createQuery(query);
            q.setParameter("e",email);
            q.setParameter("p", password);
            user=(Customer)q.getSingleResult();
            session.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
}
