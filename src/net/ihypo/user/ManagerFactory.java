package net.ihypo.user;

import net.ihypo.database.IDAO;
import net.ihypo.database.ManagerDAO;
import net.ihypo.models.Manager;

/**
 * 管理员工厂类，生产管理员并数据持久化
 * Created by hypo on 15-12-27.
 */
public class ManagerFactory extends AbstractUserFactory{

    public ManagerFactory(String userLogin, String userName, String userPass) {
        super(userLogin, userName, userPass);
    }

    /**
     * 生产方法，并持久化
     * @return 如果持久化成功则返回已经持久化的管理员对象，否则返回null
     */
    public Manager getNewManager(){
        Manager manager = new Manager(super.getUserLogin(), super.getUserName(), super.getUserPass());

        // 数据持久化
        IDAO dao = new ManagerDAO();
        dao.add(manager);

        return manager;
    }
}
