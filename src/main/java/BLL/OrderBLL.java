/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import hibernatebanhang.DAL.Order;
import hibernatebanhang.DAL.OrderDAL;
import java.io.Serializable;

/**
 *
 * @author Canh
 */
public class OrderBLL {
    private OrderDAL orderDAL;
    
    public OrderBLL()
    {
        orderDAL = new OrderDAL();
    }
    
    public Order getOrder(int od)
    {
        return orderDAL.getOrder(od);
    }
    
    public Serializable newOrder(Order o)
    {
        return orderDAL.addOrder(o);
    }
    
    public void addToOrder(){
        
    }
}
