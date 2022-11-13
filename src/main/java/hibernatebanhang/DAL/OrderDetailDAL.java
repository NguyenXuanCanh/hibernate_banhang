/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernatebanhang.DAL;

import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author Canh
 */
public class OrderDetailDAL {
    Session session;
    
    public OrderDetailDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
//    public OrderDetail getOrderDetail(int orderID, int vegetableID)
//    {
//        OrderDetail obj;
//        session.beginTransaction();
//        obj = session.get(OrderDetail.class, orderID, vegetableID);
//        session.getTransaction().commit();
//        return obj;
//        
//    }

    public void addOrderDetail(OrderDetail obj)
    {
        session.save(obj);
    }

    public void deleteOrderDetail(OrderDetail obj)
    {
        session.delete(obj);
    }
    
}
