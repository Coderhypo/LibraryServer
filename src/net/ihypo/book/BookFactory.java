package net.ihypo.book;

import net.ihypo.database.BookDao;
import net.ihypo.database.IDAO;
import net.ihypo.models.Book;

/**
 * 图书工厂方法 生产图书并持久化
 * Created by hypo on 15-12-27.
 */
public class BookFactory {

    private String bookName;
    private String bookAuther;
    private String bookPub;
    private String ISBN;
    private Double price;
    private Integer typeId;
    private Boolean canLend;

    public BookFactory(String bookAuther, String bookName, String bookPub,
                       Boolean canLend, String ISBN, Double price, Integer typeId) {
        setBookAuther(bookAuther);
        setBookName(bookName);
        setBookPub(bookPub);
        setCanLend(canLend);
        setISBN(ISBN);
        setPrice(price);
        setTypeId(typeId);
    }

    public Book getBook(){

        Book book =  new Book(bookAuther,bookName,bookPub,canLend,ISBN,price,typeId);

        // 数据持久化
        IDAO dao = new BookDao();
        dao.add(book);

        return book;
    }

    private void setBookAuther(String bookAuther) {

        this.bookAuther = bookAuther.substring(0,30);
    }

    private void setBookName(String bookName) {
        this.bookName = bookName.substring(0,20);
    }

    private void setBookPub(String bookPub) {
        this.bookPub = bookPub.substring(0,40);
    }

    private void setCanLend(Boolean canLend) {
        if (canLend == null){

            this.canLend = true;
        }else {

            this.canLend = canLend;
        }
    }

    private void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    private void setPrice(Double price) {
        if (price < 0){

            this.price = 0.0;
        }else {

            this.price = price;
        }
    }

    private void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
