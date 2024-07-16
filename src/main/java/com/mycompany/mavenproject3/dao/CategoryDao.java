/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.dao;

import com.mycompany.mavenproject3.entities.Category;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author usman
 */
public class CategoryDao {
    private SessionFactory factory;

    public CategoryDao(SessionFactory factory) {
        this.factory = factory;
    }
    //saving category to database
    public int saveCategory(Category cat)
    {
        Session session=this.factory.openSession();
        Transaction tx = session.beginTransaction();
        int catId=(int)session.save(cat);
        tx.commit();
        session.close();
        return catId;
        
        
    }
    public List<Category> getCategories(){
        Session s=this.factory.openSession();
        Query query =s.createQuery("from Category");
        List<Category> list=query.getResultList();
        return list;
        
    }
    public Category getCategoryById(int cid){
        Category cat=null;
        try{
            Session session =this.factory.openSession();
             cat= session.get(Category.class, cid);
             session.close();
             
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return cat;
    }
}
