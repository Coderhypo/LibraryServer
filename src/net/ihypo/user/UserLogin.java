package net.ihypo.user;

import net.ihypo.database.IDAO;
import net.ihypo.database.ManagerDAO;
import net.ihypo.database.ReaderDAO;
import net.ihypo.models.Manager;
import net.ihypo.models.Reader;
import net.ihypo.tools.PasswordTool;

import java.util.List;

/**
 * 用户登录类
 * 因为所有请求是无状态的,靠更新的token验证权限
 * Created by hypo on 15-12-27.
 */
public class UserLogin {

    private String userLogin;
    private String userPass;
    private String rule;
    private IUser user;

    /**
     * 构造函数
     * @param rule      标志是管理员登录还是用户登录 合法取值仅为 "MANAGER" | "READER"
     * @param userLogin 用户登录名
     * @param userPass  用户明文密码
     */
    public UserLogin(String rule, String userLogin, String userPass) {
        this.rule = rule;
        this.userLogin = userLogin;
        this.userPass = userPass;
    }

    /**
     * 外部调用登录验证方法
     * @return 如果登录成功返回登录的用户对象,否则返回null
     */
    public IUser login(){
        if (verify()){

            return this.user;
        }else {
            return null;
        }
    }

    /**
     * 登录验证 并更新token
     * @return 返回是否登录验证成功
     */
    private Boolean verify(){

        IDAO dao = null;

        // 获取用户
        if(rule.equals("MANAGER")){

            String HQL = "FROM Manager m WHERE m.userLogin=" + this.userLogin;

            dao = new ManagerDAO();
            List<Manager> list = dao.query(HQL);

            if(list.size() == 0){
                return false;
            }

            this.user = list.get(0);

        }else if(rule.equals("READER")){

            String HQL = "FROM Reader r WHERE r.userLogin=" + this.userLogin;

            dao = new ReaderDAO();
            List<Reader> list = dao.query(HQL);

            if(list.size() == 0){
                return false;
            }

            this.user = list.get(0);
        }

        // 密码验证 更新token
        if(PasswordTool.verify(this.userPass, this.user)){

            // 登录成功 更新token
            user.updateToken();
            dao.update(user);

            return true;
        }

        return false;
    }
}
