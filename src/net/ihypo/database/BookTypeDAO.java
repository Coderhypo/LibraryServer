package net.ihypo.database;

import net.ihypo.models.BookType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by hypo on 15-12-27.
 */
public class BookTypeDAO implements IDAO<BookType> {
    @Override
    public BookType get(Integer id) {

        Session session = HibernateSessionFactory.currentSession();
        String HQL = "FROM BookType b WHERE b.typeId=" + id;
        Query query = session.createQuery(HQL);

        BookType rnt;

        if(query.list().size() == 0){
            rnt = null;
        }else {
            rnt = (BookType) query.list().get(0);
        }

        HibernateSessionFactory.closeSession();

        return rnt;
    }

    @Override
    public Boolean add(BookType one) {

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
    public Boolean delete(BookType one) {

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
    public Boolean update(BookType one) {

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
    public List<BookType> query(String HQL) {

        Session session = HibernateSessionFactory.currentSession();

        Query query = session.createQuery(HQL);
        List<BookType> rnt = query.list();

        HibernateSessionFactory.closeSession();

        return rnt;
    }
}
