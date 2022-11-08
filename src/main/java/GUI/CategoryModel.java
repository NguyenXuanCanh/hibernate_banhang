/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import hibernatebanhang.DAL.Category;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author caothanh
 */
public class CategoryModel extends DefaultComboBoxModel<Category>{
    
    public CategoryModel(Category[] listCate)
    {
        super(listCate);
    }
}
