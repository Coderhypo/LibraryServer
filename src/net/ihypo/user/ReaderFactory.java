package net.ihypo.user;

import net.ihypo.database.IDAO;
import net.ihypo.database.ReaderDAO;
import net.ihypo.models.Reader;

/**
 * 读者工厂类，生产读者并数据持久化
 * Created by hypo on 15-12-27.
 */
public class ReaderFactory extends AbstractUserFactory{

    public ReaderFactory(String userLogin, String userName, String userPass) {
        super(userLogin, userName, userPass);
    }

    /**
     * 生产方法，并持久化
     * @return 如果持久化成功则返回已经持久化的读者对象，否则返回null
     */
    public Reader getNewReader(){
        Reader reader = new Reader(super.getUserLogin(), super.getUserName(), super.getUserPass());

        // 数据持久化
        IDAO dao = new ReaderDAO();
        dao.add(reader);

        return reader;
    }
}
