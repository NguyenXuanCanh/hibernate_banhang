package GUI;


import BLL.CategoryBLL;
import BLL.VegetableBLL;
import hibernatebanhang.DAL.Category;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author caothanh
 */
public class VegetableForm extends JFrame implements ActionListener {

    VegetableBLL vegBLL = new VegetableBLL();
    CategoryBLL cateBLL = new CategoryBLL();
    int page = 1;

    VegetableForm() {
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
            java.util.logging.Logger.getLogger(VegetableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VegetableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VegetableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VegetableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        VegetableForm f = new VegetableForm();

        f.setVisible(true);
    }

    private void init() {
        this.setTitle("Vegetable");
        this.setSize(800, 600);
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
        jbtnNext = new JButton("Next");
        
        jbtnFind.addActionListener((ActionEvent e) -> {
            btnFind_Click(e);
        });
        jbtnRefresh.addActionListener((ActionEvent e) -> {
            try {
                btnRefresh_Click(e);
            } catch (SQLException ex) {
                Logger.getLogger(VegetableForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.loadCategory();
        jptop.add(jbtnFind);
        jptop.add(jbtnRefresh);
        jptop.add(jbtnNext);
        jptop.add(cbCategory);

        this.getContentPane().add(jptop, BorderLayout.NORTH);
    }

    private void addJPCenter() {
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(jTable1);
        this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
    }

    private void addJPRight() {
        jpcenter = new JPanel();
        jpcenter.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        jbtnAdd = new JButton("Add new");
        jbtnAdd.addActionListener((ActionEvent e) -> {
            btnAdd_Click(e);
        });
        jbtnEdit = new JButton("Edit");
        jbtnEdit.addActionListener((ActionEvent e) -> {
            try {
                btnEdit_Click(e);
            } catch (SQLException ex) {
                Logger.getLogger(VegetableForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        jpcenter.add(jbtnAdd);
        jpcenter.add(jbtnEdit);
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
       
    }

    public void btnEdit_Click(ActionEvent e) throws SQLException {

        
    }

    public void btnFind_Click(ActionEvent e) {
        

    }

    public void btnRefresh_Click(ActionEvent e) throws SQLException {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");

    }
    JScrollPane jScrollPane1;
    JComboBox cbCategory;
    JTable jTable1 = new JTable();
    JLabel title, lbStatus, lbFind;
    JPanel jpcenter, jptop, jpleft, jpbot;
    JButton jbtnAdd, jbtnUpdate, jbtnEdit, jbtnFind, jbtnRefresh, jbtnNext;
    JTextField jtxtFind;

    
}
