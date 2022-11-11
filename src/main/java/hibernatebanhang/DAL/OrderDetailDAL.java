/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernatebanhang.DAL;

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
    public OrderDetail getOrderDetail(int orderDetailID)
    {
        OrderDetail obj;
        session.beginTransaction();
        obj = session.get(OrderDetail.class, orderDetailID);
        session.getTransaction().commit();
        return obj;
        
    }

    public void addOrderDetail(Order obj)
    {
        session.save(obj);
    }

    public void deleteOrderDetail(Order obj)
    {
        session.delete(obj);
    }
    
    public static void main(String args[])
    {
        OrderDetailDAL dal = new OrderDetailDAL();
        //Vegetable obj = dal.getVegetable(1);
        //System.out.println(obj.getVegetableName());
        OrderDetail order = dal.getOrderDetail(1);
        
        System.out.print("ID: " + order.getOrderID()); 
    
    }
}
