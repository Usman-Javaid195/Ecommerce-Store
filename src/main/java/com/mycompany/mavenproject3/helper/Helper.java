/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.helper;

import jakarta.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author usman
 */
public class Helper {
    public static String get10Words(String desc){
        String[] strs=desc.split(" ");
        if(strs.length>10){
            String res="";
            for(int i=0; i<10; i++){
                res=res+strs[i]+" ";
            }
            return (res+"...");
        }
        else{
            return(desc+"...");
        }
    }
    public static Map<String, Integer> getCounts(SessionFactory factory){
        Session session=factory.openSession();
        String q1="FROM Customer";
        String q2="FROM Product";
        Query query1=session.createQuery(q1);
        Query query2=session.createQuery(q2);
        int userCount=query1.getResultList().size();
        int productCount=query2.getResultList().size();
        System.out.println(userCount+" "+ productCount);
        Map<String,Integer> map=new HashMap<>();
        map.put("userCount",userCount);
        map.put("productCount", productCount);
        
        session.close();
        return map;
    }
}
