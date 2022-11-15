package hibernatebanhang.DAL;

import java.util.List;
import org.hibernate.Session;

public class CustomersDAL {

    Session session;

    public CustomersDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List loadCustomers() {
        List<Customers> customer;
        session.beginTransaction();
        customer = session.createQuery("FROM Customers", Customers.class).list();
        session.getTransaction().commit();
        return customer;

    }
    public Customers getCustomer(int CustomersID)
    {
        Customers c = session.get(Customers.class, CustomersID);
        return c;
    }
    public void addCustomers(Customers c)
    {
       
        session.save(c);
        
    }
    public void updateCustomers(Customers c)
    {
        session.update(c);
        
    }
    public void deleteCustomers(Customers c)
    {
        session.delete(c);
    }

}
