
package hibernatebanhang.DAL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class VegetableDAL {
    
    Session session;
    SessionFactory sf = HibernateUtils.getSessionFactory();
    
    public VegetableDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    public Vegetable getVegetable(int vegetableID)
    {
        Vegetable obj;
        session.beginTransaction();
        obj = session.get(Vegetable.class, vegetableID);
        session.getTransaction().commit();
        return obj;
        
    }
    public List<Vegetable> getVegetablebyName(String name)
    {
        List<Vegetable> list;
         session.beginTransaction();
        Query q = session.createQuery("FROM Vegetable WHERE VegetableName = :Name");
        q.setParameter("Name", name);
        list=  q.list();
        session.getTransaction().commit();
        return list;
    }
    public boolean hasVegetable(String name)
    {
        if(this.getVegetablebyName(name).size() > 0) return true;
        return false;
    }
    public List getVegetableInCategory(int categoryID)
    {
        List list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Vegetable WHERE CatagoryID = :categoryID");
        q.setParameter("categoryID", categoryID);
        list = q.list();
        session.getTransaction().commit();
        return list;
    }
     public List<Vegetable> find(String name)
    {
        List<Vegetable> list;
         session.beginTransaction();
        Query q = session.createQuery("FROM Vegetable WHERE VegetableName like :Name");
        q.setParameter("Name", '%'+name+'%');
        list=  q.list();
        session.getTransaction().commit();
        return list;
    }
    public ArrayList<Vegetable> loadVegetable() {
        ArrayList<Vegetable> vegetable;
        session.beginTransaction();
        vegetable = (ArrayList<Vegetable>) session.createQuery("FROM Vegetable", Vegetable.class).list();
        session.getTransaction().commit();
        return vegetable;

    }
    public boolean addVegetable(Vegetable obj)
    {
        try
       {
           sf.getCurrentSession().beginTransaction();
           sf.getCurrentSession().save(obj);
           sf.getCurrentSession().getTransaction().commit();
           return true;
       }
       catch(HibernateException e)
       {
           sf.getCurrentSession().getTransaction().rollback();
           return false;
       }
        
    }
    public boolean updateVegetable(Vegetable obj)
    {
        try
       {
           sf.getCurrentSession().beginTransaction();
           sf.getCurrentSession().update(obj);
           sf.getCurrentSession().getTransaction().commit();
           return true;
       }
       catch(HibernateException e)
       {
           sf.getCurrentSession().getTransaction().rollback();
           return false;
       }
//        session.update(obj);
    }
    public boolean deleteVegetable(Vegetable obj)
    {
       try
       {
           sf.getCurrentSession().beginTransaction();
           sf.getCurrentSession().delete(obj);
           sf.getCurrentSession().getTransaction().commit();
           return true;
       }
       catch(HibernateException e)
       {
           sf.getCurrentSession().getTransaction().rollback();
           return false;
       }
    }
    
    public static void main(String args[])
    {
        VegetableDAL dal = new VegetableDAL();
//        CategoryDAL catDAL = new CategoryDAL();
//        
//        
//        Vegetable obj = new Vegetable();
//        
//        obj.setVegetableName("lemon");
//        obj.setAmount(50);
//        obj.setUnit("Kg");
//        obj.setCatagory((Category) catDAL.getCategorybyName("Fruit"));
//        obj.setPrice(50000.00);
//        obj.setImage("");
        
        

//        System.out.println(dal.addVegetable(obj));
            System.out.println(dal.find(""));
           
    }
}
