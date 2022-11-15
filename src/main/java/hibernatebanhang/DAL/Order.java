package hibernatebanhang.DAL;

import com.sun.istack.NotNull;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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
@Table(name="`Order`")
public class Order
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int OrderID;
    
    @Column
    private java.sql.Date Date;
    
    @Column
    private float Total;
    
    @Column
    private String Note;
    
    @OneToMany (mappedBy = "order")
    private List<OrderDetail> listOrderDetail;
    
    @ManyToOne 
    @JoinColumn (name="CustomerID")
    private Customers customer;
}
