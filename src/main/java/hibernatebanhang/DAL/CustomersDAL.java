package hibernatebanhang.DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CustomersDAL {

    Session session;

    public CustomersDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List loadCustomers() {
        List<Customers> customersList;
        session.beginTransaction();
        customersList = session.createQuery("FROM Customers", Customers.class).list();
        session.getTransaction().commit();
        return customersList;

    }
    public Customers getCustomer(int CustomersID)
    {
        Customers c = session.get(Customers.class, CustomersID);
        return c;
    }
    public boolean addCustomers(Customers cus)
    {
        Transaction transaction = null;
        try {
            session.beginTransaction();
            session.save(cus);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            session.beginTransaction().rollback();
            return false;
        }
            
    }
    public boolean updateCustomers(Customers cus)
    {
        Transaction transaction = null;
        try {
            session.beginTransaction();
            session.update(cus);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            session.beginTransaction().rollback();
            return false;
        }
        
    }
    public boolean deleteCustomer(Customers cus)
    {
        Transaction transaction = null;
        try {
            session.beginTransaction();
            session.delete(cus);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            session.beginTransaction().rollback();
            return false;
        }
    }
    public List<Customers> findCustomer(String name)
    {
        List<Customers> list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Customers WHERE Fullname=:name");
        q.setParameter("name", name);
        list=  q.list();
        session.getTransaction().commit();
        return list;
    }
}
