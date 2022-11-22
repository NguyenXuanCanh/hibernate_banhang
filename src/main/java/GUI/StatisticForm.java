/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huynh
 */
public class StatisticForm extends javax.swing.JFrame {

    /**
     * Creates new form StatisticForm
     */
    public StatisticForm() {
        initComponents();
    }
    
    Date now = new Date();
    String formatSetMonth = new SimpleDateFormat("MM").format(now);
    String formatSetYear = new SimpleDateFormat("yyyy").format(now);
    String formatMonth = new SimpleDateFormat("MM/yyyy").format(now);
    String monthNow = formatMonth.formatted(now);
    String setMonthNow = formatSetMonth.formatted(now); 
    String setYearNow = formatSetYear.formatted(now);
    String monthSelect = setMonthNow;
    String yearSelect = setYearNow;

    List<statis> resultList = new ArrayList<statis>();
    DefaultTableModel model = new DefaultTableModel();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbHeading = new javax.swing.JLabel();
        lbStatistic = new javax.swing.JLabel();
        cbStatictis = new javax.swing.JComboBox<>();
        cbMonth = new javax.swing.JComboBox<>();
        lbMonth = new javax.swing.JLabel();
        cbYear = new javax.swing.JComboBox<>();
        lbYear = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbBestSeller = new javax.swing.JLabel();
        lbBestTop1 = new javax.swing.JLabel();
        lbBestTop2 = new javax.swing.JLabel();
        lbBestTop3 = new javax.swing.JLabel();
        lbSlowlyTop1 = new javax.swing.JLabel();
        lbSlowlyTop2 = new javax.swing.JLabel();
        lbSlowlyTop3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbHeading.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHeading.setText("Business Statistic");

        lbStatistic.setText("Statistic By:");

        cbStatictis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Statistic", "Product" }));
        cbStatictis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatictisActionPerformed(evt);
            }
        });

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonthActionPerformed(evt);
            }
        });

        lbMonth.setText("Month:");

        cbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024" }));
        cbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbYearActionPerformed(evt);
            }
        });

        lbYear.setText("Year: ");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Category Name", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        lbBestSeller.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbBestSeller.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBestSeller.setText("Best Seller Of Category");
        lbBestSeller.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbBestTop1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbBestTop1.setText("Top 1: ");

        lbBestTop2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbBestTop2.setText("Top 2: ");

        lbBestTop3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbBestTop3.setText("Top 3: ");

        lbSlowlyTop1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSlowlyTop1.setText("Total Import Price: ");

        lbSlowlyTop2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSlowlyTop2.setText("Total Export Price: ");

        lbSlowlyTop3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSlowlyTop3.setText("Gross profit:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBestSeller, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbStatistic)
                        .addGap(0, 0, 0)
                        .addComponent(cbStatictis, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(lbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbBestTop3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                .addComponent(lbBestTop2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbSlowlyTop3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbSlowlyTop2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbSlowlyTop1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbBestTop1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnSearch)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbStatictis, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbBestSeller)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbBestTop1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbBestTop2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbBestTop3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbSlowlyTop1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSlowlyTop2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSlowlyTop3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbYearActionPerformed
        yearSelect = cbYear.getSelectedItem().toString();
        lbStatistic.setText("Business Statistic : " + monthSelect + "/" + yearSelect);
        try {
            displayList(monthSelect + "/" + yearSelect);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }//GEN-LAST:event_cbYearActionPerformed

    private void cbStatictisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatictisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatictisActionPerformed

    private void cbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonthActionPerformed
        monthSelect = cbMonth.getSelectedItem().toString();
        lbStatistic.setText("Business Statistic : " + monthSelect + "/" + yearSelect);
        try {
                displayList(monthSelect + "/" + yearSelect);
        } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }
    }//GEN-LAST:event_cbMonthActionPerformed

    private void displayList(String monthNow) throws ParseException {
        List<statis> listToTal = new ArrayList<statis>();
        model.setRowCount(0);
        resultList = bdBLL.statisticByProduct(monthNow);
        int k = 0;
        if(resultList.size() == 0) {
            JOptionPane.showMessageDialog(null, "No data!");
            return;
        }
        while(k < resultList.size()) {
            statis sta = new statis(resultList.get(k).getName(), resultList.get(k).getAmount());
            listToTal.add(sta);
            statis s = resultList.get(k);
            model.addRow(new Object [] {
                model.getRowCount()+1, s.getName(), s.getAmount() 
            });
            k++;
        }
        // sort amount
        Collections.sort(listToTal, statis.amountComparator);
        // top product trend
        lbBestTop1.setText(listToTal.get(0).getName());
        lbBestTop2.setText(listToTal.get(1).getName());
        lbBestTop3.setText(listToTal.get(2).getName());

        // top product not trend
        lbSlowlyTop1.setText(listToTal.get(listToTal.size() - 3).getName());
        lbSlowlyTop2.setText(listToTal.get(listToTal.size() - 2).getName());
        lbSlowlyTop3.setText(listToTal.get(listToTal.size() - 1).getName());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatisticForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbStatictis;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbBestSeller;
    private javax.swing.JLabel lbBestTop1;
    private javax.swing.JLabel lbBestTop2;
    private javax.swing.JLabel lbBestTop3;
    private javax.swing.JLabel lbHeading;
    private javax.swing.JLabel lbMonth;
    private javax.swing.JLabel lbSlowlyTop1;
    private javax.swing.JLabel lbSlowlyTop2;
    private javax.swing.JLabel lbSlowlyTop3;
    private javax.swing.JLabel lbStatistic;
    private javax.swing.JLabel lbYear;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
