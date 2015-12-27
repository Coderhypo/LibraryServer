package net.ihypo.database;

import net.ihypo.models.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by hypo on 15-12-27.
 */
public class BookDao implements IDAO<Book> {
    @Override
    public Book get(Integer id) {

        Session session = HibernateSessionFactory.currentSession();
        String HQL = "FROM Book b WHERE b.bookId=" + id;
        Query query = session.createQuery(HQL);

        Book rnt;

        if (query.list().size() == 0){
            rnt =  null;
        }else {
            rnt = (Book) query.list().get(0);
        }

        HibernateSessionFactory.closeSession();

        return rnt;
    }

    @Override
    public Boolean add(Book one) {

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
    public Boolean delete(Book one) {

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
    public Boolean update(Book one) {

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
    public List<Book> query(String HQL) {

        Session session = HibernateSessionFactory.currentSession();

        Query query = session.createQuery(HQL);

        List<Book> rnt = query.list();

        HibernateSessionFactory.closeSession();

        return rnt;
    }
}
