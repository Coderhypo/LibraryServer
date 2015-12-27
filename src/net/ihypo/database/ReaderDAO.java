package net.ihypo.database;

import net.ihypo.models.Reader;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by hypo on 15-12-27.
 */
public class ReaderDAO implements IDAO<Reader> {
    @Override
    public Reader get(Integer id) {

        Session session = HibernateSessionFactory.currentSession();
        String HQL = "FROM Reader r WHERE r.userId=" + id;
        Query query = session.createQuery(HQL);

        Reader rnt;

        if(query.list().size() == 0){
            rnt = null;
        }else {
            rnt = (Reader) query.list().get(0);
        }

        HibernateSessionFactory.closeSession();

        return rnt;
    }

    @Override
    public Boolean add(Reader one) {

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
    public Boolean delete(Reader one) {

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
    public Boolean update(Reader one) {

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
    public List<Reader> query(String HQL) {

        Session session = HibernateSessionFactory.currentSession();

        Query query = session.createQuery(HQL);
        List<Reader> rnt = query.list();

        HibernateSessionFactory.closeSession();

        return rnt;
    }
}
