/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernatebanhang.DAL;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Canh
 */
public class OrderDAL {
    Session session;
    
    public OrderDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    public Order getOrder(int orderID)
    {
        Order obj;
        session.beginTransaction();
        obj = session.get(Order.class, orderID);
        session.getTransaction().commit();
        return obj;
        
    }

    public Serializable addOrder(Order obj)
    {
        Serializable id=session.save(obj);
        return id;
        
//        session.getTransaction().commit();
    }

    public void deleteOrder(Order obj)
    {
        session.delete(obj);
    }
    
    public static void main(String args[])
    {
        OrderDAL dal = new OrderDAL();
        //Vegetable obj = dal.getVegetable(1);
        //System.out.println(obj.getVegetableName());
        Order order = dal.getOrder(1);
        
        System.out.print("ID: " + order.getOrderID()); 
    
    }
}
