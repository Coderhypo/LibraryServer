package net.ihypo.models;

/**
 * 图书类，与数据库中的books表对应
 * Created by hypo on 15-12-26.
 */
public class Book {

    private Integer bookId;
    private String bookName;
    private String bookAuther;
    private String bookPub;
    private String ISBN;
    private Double price;
    private Integer typeId;
    private Boolean canLend;
    private Boolean isLend;

    public Book(String bookAuther, String bookName, String bookPub,
                Boolean canLend, String ISBN, Double price, Integer typeId) {
        this.bookAuther = bookAuther;
        this.bookName = bookName;
        this.bookPub = bookPub;
        this.canLend = canLend;
        this.ISBN = ISBN;
        this.price = price;
        this.typeId = typeId;
        this.isLend = false;
    }

    public Book() {
    }

    public String getBookAuther() {
        return bookAuther;
    }

    public void setBookAuther(String bookAuther) {
        this.bookAuther = bookAuther;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPub() {
        return bookPub;
    }

    public void setBookPub(String bookPub) {
        this.bookPub = bookPub;
    }

    public Boolean getCanLend() {
        return canLend;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Boolean getIsLend() {
        return isLend;
    }

    public void setIsLend(Boolean isLend) {
        this.isLend = isLend;
    }
}
