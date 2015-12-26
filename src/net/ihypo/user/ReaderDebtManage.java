package net.ihypo.user;

import net.ihypo.database.IDAO;
import net.ihypo.database.ReaderDAO;
import net.ihypo.models.Reader;

/**
 * 用户延迟罚款管理类
 * Created by hypo on 15-12-27.
 */
public class ReaderDebtManage {

    private Integer userId;
    private Double debt;

    public ReaderDebtManage(Double debt, Integer userId) {

        if (debt < 0){
            debt = 0.0;
        }

        this.debt = debt;
        this.userId = userId;
    }

    public void updateUserDebt(){
        IDAO dao = new ReaderDAO();
        Reader reader = (Reader) dao.get(userId);
        Double allDebt = reader.getDebt() + this.debt;

        reader.setDebt(allDebt);
        dao.update(reader);
    }
}
