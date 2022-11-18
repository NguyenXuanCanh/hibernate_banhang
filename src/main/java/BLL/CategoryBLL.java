
package BLL;

import hibernatebanhang.DAL.Category;
import hibernatebanhang.DAL.CategoryDAL;

import java.util.List;

/**
 *
 * @author caothanh
 */
public class CategoryBLL {
    
    private CategoryDAL cateDAL;
    
    
    public CategoryBLL()
    {
        cateDAL = new CategoryDAL();
    }
    
    public List loadCategory()
    {
        List list;
        list = cateDAL.loadCategory();
        
        return list;
    }
     public List<Category> getCategorybyName(String name)
    {        
        return cateDAL.getCategorybyName(name);
    }
    public Category[] convertList1 (List<Category> list)
    {
        int rows = list.size();
        Category[] newList = new Category[rows];
        for(int i = 0; i < rows; i++)
        {
            newList[i] = list.get(i);
            
        }
        return newList;
    }
    public Category getCategorybyID(int CategoryID)
    {
        return cateDAL.getCategory(CategoryID);
    }
    public String delete(Category cate)
    {
        if(cateDAL.deleteCategory(cate))
        {
            return "Success";
        }
        else
        {
            return "Fails";
        }
    }
     public String update(Category cate)
    {
        if(cateDAL.updateCategory(cate))
        {
            return "Success";
        }
        else
        {
            return "Fails";
        }
    }
    public Object[][] convertList(List<Category> list)
    {
        int rows = list.size();
        int cols = 4;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            obj[i][0] = list.get(i).getCatagoryID();
            obj[i][1] = list.get(i).getName();
            obj[i][2] = list.get(i).getDescription();
            obj[i][3] = list.get(i).getListVegetable().size();
        }
        return obj;
    }
    public String newCategory(Category c)
    {
        if(cateDAL.addCategory(c))
        {
            return "Success";
        }
        else
        {
            return "fails";
        }
        
    }
    
    public Category getCategory(int CategoryID)
    {
        Category c = cateDAL.getCategory(CategoryID);
        return c;
    }
    public List<Category> find(String name)
    {
        return cateDAL.find(name);
    }
}
