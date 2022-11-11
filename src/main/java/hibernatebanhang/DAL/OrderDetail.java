/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernatebanhang.DAL;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Canh
 */
@Data
@Entity
@Table
public class OrderDetail
{
    @Id
    private int OrderID;
    @Id
    private int VegetableID;
    @Column
    private java.sql.Date Quantity;
    @Column
    private float Price;
    
    @OneToMany (mappedBy = "catagory")  
    private List<Order> listOrder;

}