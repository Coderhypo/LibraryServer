package net.ihypo.database;

import net.ihypo.models.LendLog;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by hypo on 15-12-27.
 */
public class LendLogDAO implements IDAO<LendLog> {
    @Override
    public LendLog get(Integer id) {

        Session session = HibernateSessionFactory.currentSession();
        String HQL = "FROM LendLog l WHERE l.lendId=" + id;
        Query query = session.createQuery(HQL);

        LendLog rnt;

        if(query.list().size() == 0){
            rnt = null;
        }else {
            rnt = (LendLog) query.list().get(0);
        }

        HibernateSessionFactory.closeSession();

        return rnt;
    }

    @Override
    public Boolean add(LendLog one) {

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
    public Boolean delete(LendLog one) {

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
    public Boolean update(LendLog one) {

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
    public List<LendLog> query(String HQL) {

        Session session = HibernateSessionFactory.currentSession();

        Query query = session.createQuery(HQL);
        List<LendLog> rnt = query.list();

        HibernateSessionFactory.closeSession();

        return rnt;
    }
}
