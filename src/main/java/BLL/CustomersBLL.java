/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import hibernatebanhang.DAL.Customers;
import hibernatebanhang.DAL.CustomersDAL;

/**
 *
 * @author caothanh
 */
public class CustomersBLL {

  private  CustomersDAL cusDAL;
  
  public CustomersBLL()
  {
      cusDAL = new CustomersDAL();
  }
  
  public Customers getCustomer(int CustomersID)
  {
      cusDAL = new CustomersDAL();
      Customers c = cusDAL.getCustomer(CustomersID);
      return c;
  }
}
