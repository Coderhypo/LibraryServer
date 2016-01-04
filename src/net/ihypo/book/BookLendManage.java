package net.ihypo.book;

import net.ihypo.database.BookDao;
import net.ihypo.database.IDAO;
import net.ihypo.database.LendLogDAO;
import net.ihypo.database.ReaderDAO;
import net.ihypo.models.Book;
import net.ihypo.models.LendLog;
import net.ihypo.models.Reader;

import java.util.List;

/**
 * 图书借阅管理类 提供图书借阅相关方法
 * Created by hypo on 15-12-27.
 */
public class BookLendManage {

    private Integer bookId;
    private Integer userId;

    /**
     * 一个读者最多可以借阅的图书本书
     */
    private static final Integer MAXLENDBOOKNUM = 3;

    public BookLendManage(Integer bookId, Integer userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    public String lendBook(){

        // 验证用户信息以及合法性
        String verifyInfo = userVerify();
        if (verifyInfo != null){
            return verifyInfo;
        }

        // 验证图书信息以及合法性
        verifyInfo = bookVerify();
        if (verifyInfo != null){
            return verifyInfo;
        }

        //借出图书登记 并将记录持久化
        IDAO dao = new LendLogDAO();
        LendLog lendLog = new LendLog(bookId, userId);
        dao.add(lendLog);

        return null;
    }

    /**
     * 验证图书合法性 如果合法将修改图书状态
     * @return 返回不合法原因
     */
    private String bookVerify(){

        IDAO dao = new BookDao();
        Book book = (Book) dao.get(bookId);

        if(book == null){
            return "未找到相关图书，请检查录入的图书信息的正确性！";
        }

        if(!book.getCanLend()){
            return "馆藏图书不可借出！";
        }

        if(book.getIsLend()){
            return "该图书已经被借出，请先归还！";
        }

        // 更新图书状态
        book.setIsLend(true);
        dao.update(book);

        return null;
    }

    /**
     * 验证用户合法性
     * @return 返回不合法原因
     */
    private String userVerify(){

        IDAO dao = new ReaderDAO();
        Reader reader = (Reader) dao.get(userId);

        if(reader == null){
            return "未找到该读者信息，请核实！";
        }

        if(reader.getDebt() - 0.0 > 0.001){
            return "该读者尚有延迟罚款 " + String.format("%.2f元", reader.getDebt())
                    + "未缴纳，请先缴纳罚款！";
        }

        String HQL = "FROM LendLog l WHERE l.userId=" + reader.getUserId()
                + " AND l.returnTime=NULL";

        List<LendLog> list = new LendLogDAO().query(HQL);

        if(list.size() >= MAXLENDBOOKNUM){
            return "该读者已经借阅了 " + list.size() + "本图书，达到上限，不能再借阅！";
        }

        for (LendLog lendLog : list){
            if (lendLog.getDebt() - 0.0 > 0.001){
                return "该读者有图书已经超期，不能再借阅新图书！";
            }
        }

        return null;
    }
}
