/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import hibernatebanhang.DAL.Vegetable;
import hibernatebanhang.DAL.VegetableDAL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caothanh
 */
public class VegetableBLL {

   VegetableDAL vegDAL = new VegetableDAL();
  
//  public VegetableBLL()
//  {
//      vegDAL = new VegetableDAL();
//  }
//  
  public ArrayList<Vegetable> getALL()
  {
      return vegDAL.loadVegetable();
  }
  public boolean hasVegetable(String name)
  {
      return vegDAL.hasVegetable(name);
  }
  public List getVegetablebyName(String name)
  {
      return vegDAL.getVegetablebyName(name);
  }
  public Vegetable getVegetable(int id)
  {
      return vegDAL.getVegetable(id);
  }
  public String updateVegetable(Vegetable veg)
  {
      if(vegDAL.updateVegetable(veg))
      {
          return "Success";
      }
      else
      {
          return "Fails";
      }
  }
  public List<Vegetable> find(String name)
  {
      return vegDAL.find(name);
  }
   public String addVegetable(Vegetable veg)
  {
      if(vegDAL.addVegetable(veg))
      {
          return "Success";
      }
      else
      {
          return "Fails";
      }
  }

   public String delVegetable(Vegetable veg)
   {
       if(vegDAL.deleteVegetable(veg))
      {
          return "Success";
      }
      else
      {
          return "Fails";
      }
   }
  public Object[][] converVegetable(List<Vegetable> list)
  {
      int rows = list.size();
        int cols = 6;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            obj[i][0] = list.get(i).getVegetableID();
            obj[i][1] = list.get(i).getVegetableName();
            obj[i][2] = list.get(i).getUnit();
            obj[i][3] = list.get(i).getAmount();
            obj[i][4] = list.get(i).getImage();
            obj[i][5] = list.get(i).getPrice();
        }
        return obj;
  }
    public static void main(String[] args) {
        Vegetable veg = new Vegetable();
        veg.setVegetableName("mango");
        veg.setAmount(150);
        veg.setUnit("Kg");
        veg.setImage("");
        veg.setCatagory(new CategoryBLL().getCategorybyName("Fruit").get(0));
        veg.setPrice(50000.00);
        System.out.println(new VegetableBLL().addVegetable(veg));
    }
}
