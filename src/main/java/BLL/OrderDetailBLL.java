/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import hibernatebanhang.DAL.OrderDetail;
import hibernatebanhang.DAL.OrderDetailDAL;

/**
 *
 * @author Canh
 */
public class OrderDetailBLL {
    private OrderDetailDAL orderDetailDAL;
    
    public OrderDetailBLL()
    {
        orderDetailDAL = new OrderDetailDAL();
    }
    
    public void newOrderDetail(OrderDetail od)
    {
        orderDetailDAL.addOrderDetail(od);
    }
}
