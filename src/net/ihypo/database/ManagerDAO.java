package net.ihypo.database;

import net.ihypo.models.Manager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by hypo on 15-12-27.
 */
public class ManagerDAO implements IDAO<Manager> {
    @Override
    public Manager get(Integer id) {

        Session session = HibernateSessionFactory.currentSession();
        String HQL = "FROM Manager m WHERE m.userId=" + id;
        Query query = session.createQuery(HQL);

        Manager rnt;

        if(query.list().size() == 0){
            rnt = null;
        }else {
            rnt = (Manager) query.list().get(0);
        }

        HibernateSessionFactory.closeSession();

        return rnt;
    }

    @Override
    public Boolean add(Manager one) {

        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();

        try {

            session.save(one);
            transaction.commit();
        }catch (Exception e){

            System.err.println(e.getMessage());
            transaction.rollback();
            return false;
        }finally {

            HibernateSessionFactory.closeSession();
        }

        return true;
    }

    @Override
    public Boolean delete(Manager one) {

        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();

        try {

            session.delete(one);
            transaction.commit();
        }catch (Exception e){

            System.err.println(e.getMessage());
            transaction.rollback();
            return false;
        }finally {

            HibernateSessionFactory.closeSession();
        }

        return true;
    }

    @Override
    public Boolean update(Manager one) {

        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();

        try {

            session.update(one);
            transaction.commit();
        }catch (Exception e){

            System.err.println(e.getMessage());
            transaction.rollback();
            return false;
        }finally {

            HibernateSessionFactory.closeSession();
        }

        return true;
    }

    @Override
    public List<Manager> query(String HQL) {

        Session session = HibernateSessionFactory.currentSession();

        Query query = session.createQuery(HQL);
        List<Manager> rnt = query.list();

        HibernateSessionFactory.closeSession();

        return rnt;
    }
}
