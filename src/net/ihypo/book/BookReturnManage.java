package net.ihypo.book;

import net.ihypo.database.BookDao;
import net.ihypo.database.IDAO;
import net.ihypo.database.LendLogDAO;
import net.ihypo.models.Book;
import net.ihypo.models.LendLog;
import net.ihypo.user.ReaderDebtManage;

import java.util.List;

/**
 * 图书归还管理类，提供图书归还的相关方法
 * Created by hypo on 15-12-27.
 */
public class BookReturnManage {

    private Integer bookId;

    public BookReturnManage(Integer bookId) {
        this.bookId = bookId;
    }

    public String returnBook(){

        // 确认图书 更新图书信息
        if (!bookVerify()){
            return "图书信息确认失败，归还失败！";
        }

        // 更新归还记录 并更新用户延迟罚款
        String HQL = "FROM LendLog l WHERE l.bookId=" + this.bookId
                + " AND l.returnTime=NULL";
        IDAO dao = new LendLogDAO();
        List<LendLog> list =  dao.query(HQL);

        for(LendLog lendLog : list){

            // 更新归还记录并持久化
            Double debt = lendLog.returnBook();
            dao.update(lendLog);

            // 追缴欠款
            ReaderDebtManage debtManage = new ReaderDebtManage(debt, lendLog.getUserId());
            debtManage.updateUserDebt();
        }

        return null;
    }

    private Boolean bookVerify(){

        IDAO dao = new BookDao();

        Book book = (Book) dao.get(bookId);

        // 图书存在即可归还
        if (book != null){

            // 更新图书信息为未借出状态
            book.setIsLend(false);
            dao.update(book);

            return true;
        }

        return false;
    }
}
