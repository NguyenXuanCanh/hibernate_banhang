package hibernatebanhang.DAL;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Canh
 */
@Data
@Entity
@Table
public class Order
{
    @Id
    private int OrderID;
    @Id
    private int CustomerID;
    @Column
    private java.sql.Date Date;
    @Column
    private float Total;
    @Column
    private String Note;
    
    @OneToMany (mappedBy = "catagory")  
    private List<Order> listOrder;

}
