/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import hibernatebanhang.DAL.Category;
import hibernatebanhang.DAL.Customers;
import hibernatebanhang.DAL.CustomersDAL;
import java.util.List;

public class CustomersBLL {

  private  CustomersDAL cusDAL;
  
  public CustomersBLL()
  {
      cusDAL = new CustomersDAL();
  }
  public List loadCustomer()
    {
        List list;
        list =cusDAL.loadCustomers() ;
        
        return list;
    }
  public Object[][] convertList(List<Customers> list)
    {
        int rows = list.size();
        int cols = 4;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            obj[i][0] = list.get(i).getCustomerID();
            obj[i][1] = list.get(i).getFullname();
            obj[i][2] = list.get(i).getAddress();
            obj[i][3] = list.get(i).getCity();
        }
        return obj;
    }
  public Customers getCustomer(int CustomersID)
  {
      cusDAL = new CustomersDAL();
      Customers c = cusDAL.getCustomer(CustomersID);
      return c;
  }
  public String newCustomer(Customers cus)
    {
        if(cusDAL.addCustomers(cus)){
            return "Create customer successfully";
        }
        return "Create customer fails";
    }
  public String editCustomer(Customers cus)
    {
        if(cusDAL.updateCustomers(cus)){
            return "Edit customer successfully";
        }
        return "Edit customer fails";
    }
  public String deleteCustomer(Customers cus)
    {
        if(cusDAL.deleteCustomer(cus)){
            return "Delete customer successfully";
        }
        return "Delete customer fails";
    }
  public List<Customers> findCustomer(String nameCus)
    {
        return cusDAL.findCustomer(nameCus);
    }
}

