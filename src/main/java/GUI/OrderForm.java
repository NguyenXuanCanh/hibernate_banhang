package GUI;


import BLL.CategoryBLL;
import BLL.CustomersBLL;
import BLL.OrderBLL;
import BLL.OrderDetailBLL;
import BLL.VegetableBLL;
import hibernatebanhang.DAL.Category;
import hibernatebanhang.DAL.Customers;
import hibernatebanhang.DAL.Order;
import hibernatebanhang.DAL.OrderDetail;
import hibernatebanhang.DAL.Vegetable;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author caothanh
 */
public class OrderForm extends JFrame implements ActionListener {
    CustomersBLL customerBLL=new CustomersBLL();
    Customers customer=new Customers();

    VegetableBLL vegBLL = new VegetableBLL();
    CategoryBLL cateBLL = new CategoryBLL();
    int page = 1;
    Object[][] dataOrder=new Object[0][4];
    OrderForm() {
        init();
        
    }

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        OrderForm f = new OrderForm();

        f.setVisible(true);
    }

    private void init() {
        this.setTitle("Select Vegetable");
        this.setSize(1000, 600);
        this.setLayout(new BorderLayout(20, 20));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        addJPTop();
        addJPCenter();
        addJPRight();
        addJPBottom();
    }
    private void loadVegetable(int cateID)
    {
        List listVeg = cateBLL.getCategory(cateID).getListVegetable();
        Object[][] data = vegBLL.converVegetable(listVeg);
        String[] title = {"VegID", "Name", "Unit", "Amount", "Images", "Price"};
        DefaultTableModel model = new DefaultTableModel(data, title);
        jTable1.setModel(model);
        
//        Object[][] dataOrder=new Object[0][0];
//        String[] titleOrder = {"VegID", "Name", "Quantity"};
//        DefaultTableModel modelOrder = new DefaultTableModel(data, titleOrder);
//        jTable1Order.setModel(modelOrder);
    }
    private void loadCategory()
    {
        List listCate = cateBLL.loadCategory();
        Category[] newList = cateBLL.convertList1(listCate);
        CategoryModel model= new CategoryModel(newList);
        cbCategory = new JComboBox(model);
        cbCategory.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Category cate = (Category ) e.getItem();
                lbStatus.setText(cate.getCatagoryID() + " - " + cate.getName());
                int cateid = cate.getCatagoryID();
                loadVegetable(cateid);
            }
        });
        
    }

    private void addJPTop() {
        jptop = new JPanel();
        jptop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        title = new JLabel("List of Vegetable");
        lbFind = new JLabel("Search:");
        jtxtFind = new JTextField(20);
        jptop.add(lbFind);
        jptop.add(jtxtFind);
        jbtnFind = new JButton("Search");

        jbtnRefresh = new JButton("Refresh");
        
        jbtnFind.addActionListener((ActionEvent e) -> {
            btnFind_Click(e);
        });
        jbtnRefresh.addActionListener((ActionEvent e) -> {
            try {
                btnRefresh_Click(e);
            } catch (SQLException ex) {
                Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.loadCategory();
        jptop.add(jbtnFind);
        jptop.add(jbtnRefresh);
        jptop.add(cbCategory);
        jbtnAdd = new JButton("Add to order");
        jptop.add(jbtnAdd);
        jbtnAdd.addActionListener((ActionEvent e) -> {
            btnAdd_Click(e);
        });
//        jbtnDel = new JButton("Delele product from order");
//        jbtnDel.addActionListener((ActionEvent e) -> {
//            btnDel_Click(e);
//        });
        jbtnSave = new JButton("Save order");
        jbtnSave.addActionListener((ActionEvent e) -> {
            btnSave_Click(e);
        });
//        jptop.add(jbtnDel);        
        jptop.add(jbtnSave);

        this.getContentPane().add(jptop, BorderLayout.NORTH);
    }

    private void addJPCenter() {
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(jTable1);
        this.getContentPane().add(jScrollPane1, BorderLayout.WEST);
    }

    private void addJPRight() {
        jScrollPane1Order = new JScrollPane();
        jpcenter = new JPanel();
        jpcenter.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        
        jScrollPane1Order.setViewportView(jTable1Order);
        
        jpcenter.add(jScrollPane1Order);

//        jpcenter.add();
        this.getContentPane().add(jpcenter, BorderLayout.EAST);
    }

    private void addJPBottom() {
        jpbot = new JPanel();
        lbStatus = new JLabel("");
        jpbot.add(lbStatus);
        jpbot.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        this.getContentPane().add(jpbot, BorderLayout.SOUTH);
    }

    public void btnAdd_Click(ActionEvent e) {
       int column = 0;
       int row = jTable1.getSelectedRow();
       String id = jTable1.getModel().getValueAt(row, 0).toString();       
       String name = jTable1.getModel().getValueAt(row, 1).toString();       
       String price = jTable1.getModel().getValueAt(row, 5).toString();

       int quantity=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter quantity")); 
//       JOptionPane.showMessageDialog(null, id+" "+name+" "+quantity);
       
       createOrderTable(id, name, price, quantity);
    }

//    public void btnDel_Click(ActionEvent e) {
////       int column = 0;
//       int row = jTable1Order.getSelectedRow();
//       
//       System.out.print(dataOrder[row][0]);
//       Object[][]copy=dataOrder.clone();
//       dataOrder=new Object[copy.length-1][4];
//       for(int i=0;i<copy.length;i++){
//            if(i>=row){
//                dataOrder[i][0]=copy[i+1][0];
//                dataOrder[i][1]=copy[i+1][1];
//                dataOrder[i][2]=copy[i+1][2];            
//                dataOrder[i][3]=copy[i+1][3];
//            }
//       }
//       String[] titleOrder = {"VegID", "Name", "Price","Quantity"};
//       DefaultTableModel modelOrder = new DefaultTableModel(dataOrder, titleOrder);
//       jTable1Order.setModel(modelOrder);
//    }
    
    public void createOrderTable(String id, String name, String price, int quantity){
        Object[][]copy=dataOrder.clone();
        dataOrder=new Object[copy.length+1][4];
        for(int i=0;i<copy.length;i++){
            dataOrder[i][0]=copy[i][0];
            dataOrder[i][1]=copy[i][1];
            dataOrder[i][2]=copy[i][2];            
            dataOrder[i][3]=copy[i][3];
        }
        dataOrder[copy.length][0]=id;
        dataOrder[copy.length][1]=name;
        dataOrder[copy.length][2]=price;        
        dataOrder[copy.length][3]=quantity;

        String[] titleOrder = {"VegID", "Name", "Price","Quantity"};
        DefaultTableModel modelOrder = new DefaultTableModel(dataOrder, titleOrder);
        jTable1Order.setModel(modelOrder);
    }
    public void btnEdit_Click(ActionEvent e) throws SQLException {
    }

    public void btnFind_Click(ActionEvent e) {
        List<Vegetable> find = vegBLL.find(jtxtFind.getText().trim()+"");
        System.out.print(find);
        Object[][] data = vegBLL.converVegetable(find);
        String[] title = {"VegID", "Name", "Unit", "Amount", "Images", "Price"};
        DefaultTableModel model = new DefaultTableModel(data, title);
        jTable1.setModel(model);
    }

    public void btnRefresh_Click(ActionEvent e) throws SQLException {
        
    }
    
    public void btnSave_Click(ActionEvent e){
        OrderBLL oB=new OrderBLL();
        OrderDetailBLL odB=new OrderDetailBLL();
        Order o=new Order();
        long now = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(now);
        customer=customerBLL.getCustomer(3);
        int total=0;
        for(int i=0;i<dataOrder.length;i++){
            total+=Float.parseFloat(dataOrder[i][2].toString());
        }
        
        o.setDate(date);
        o.setNote(JOptionPane.showInputDialog(null,"Note something"));
        o.setTotal(total);
        o.setCustomer(customer);

        Serializable orderIdAdded=oB.newOrder(o);
        System.out.println("created id: " + orderIdAdded);
        Order orderRes=oB.getOrder(Integer.parseInt(orderIdAdded.toString()));
        
        for(int i=0;i<dataOrder.length;i++){
            OrderDetail od=new OrderDetail();
            Vegetable veg=vegBLL.getVeg(Integer.parseInt(dataOrder[i][0].toString()));
            
            od.setVegetable(veg);            
            od.setOrder(orderRes);
            od.setPrice(Float.parseFloat(dataOrder[i][2].toString()));
            od.setQuantity(Integer.parseInt(dataOrder[i][3].toString()));

            odB.newOrderDetail(od);
        }
        JOptionPane.showMessageDialog(null, "Order saved");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");

    }
    
    JScrollPane jScrollPane1;
    JScrollPane jScrollPane1Order;
    JComboBox cbCategory;
    JTable jTable1 = new JTable();
    JTable jTable1Order=new JTable();
    JLabel title, lbStatus, lbFind;
    JPanel jpcenter, jptop, jpleft, jpbot;
    JButton jbtnAdd, jbtnUpdate, jbtnEdit, jbtnFind, jbtnRefresh, jbtnSave, jbtnDel;
    JTextField jtxtFind;

    
}
