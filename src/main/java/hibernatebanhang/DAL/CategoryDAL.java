package hibernatebanhang.DAL;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CategoryDAL {

    Session session;
    SessionFactory sf = HibernateUtils.getSessionFactory();

    public CategoryDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List loadCategory() {
        List<Category> category;
        session.beginTransaction();
        category = session.createQuery("FROM Category", Category.class).list();
        session.getTransaction().commit();
        return category;

    }
    public Category getCategory(int CatagoryID)
    {
        try//cái này phải xài f
        {
            sf.getCurrentSession().beginTransaction();
            return (Category) sf.getCurrentSession().get(Category.class, CatagoryID);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
    public List<Category> getCategorybyName(String name)
    {
        List<Category> list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Category WHERE Name = :Name");
        q.setParameter("Name", name);
        list =  q.list();
        session.getTransaction().commit();
        return list;
    }
    public List<Category> find(String name)
    {
        List<Category> list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Category WHERE Name like :Name");
        q.setParameter("Name", '%'+name+'%');
        list=  q.list();
        session.getTransaction().commit();
        return list;
    }
    public boolean addCategory(Category c)
    {
       try
       {
           sf.getCurrentSession().beginTransaction();
           sf.getCurrentSession().save(c);
           sf.getCurrentSession().getTransaction().commit();
           return true;
       }
       catch(Exception e)
       {
           sf.getCurrentSession().getTransaction().rollback();
           return false;
       }
        //session.saveOrUpdate(c);
        
    }
    public boolean updateCategory(Category c)
    {
        try
       {
           sf.getCurrentSession().beginTransaction();
           sf.getCurrentSession().update(c);
           sf.getCurrentSession().getTransaction().commit();
           return true;
       }
       catch(Exception e)
       {
           System.out.println(e);
           sf.getCurrentSession().getTransaction().rollback();
           return false;
       }
//        session.update(c);
        
    }
    public boolean deleteCategory(Category c)
    {
        try
       {
           sf.getCurrentSession().beginTransaction();
           sf.getCurrentSession().delete(c);
           sf.getCurrentSession().getTransaction().commit();
           return true;
       }
       catch(Exception e)
       {
           sf.getCurrentSession().getTransaction().rollback();
           System.out.println(e);
           return false;
       }   
 
           
    }
    public static void main(String[] args) {
        CategoryDAL dal = new CategoryDAL();
        Category cate = new Category();
        cate.setCatagoryID(17);
        cate.setName("add");
        cate.setDescription("demo Update DAL");
        System.out.println(dal.find("a"));
        
 
    }
}
