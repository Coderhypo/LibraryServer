package net.ihypo.user;

/**
 * 抽象工厂类，为读者工厂，管理员工厂类提供基础操作与数据安全性检查
 * Created by hypo on 15-12-27.
 */
public abstract class AbstractUserFactory {

    private String userLogin;
    private String userName;
    private String userPass;

    public AbstractUserFactory(String userLogin, String userName, String userPass) {
        setUserLogin(userLogin);
        setUserName(userName);
        setUserPass(userPass);
    }

    private void setUserLogin(String userLogin) {
        this.userLogin = userLogin.substring(0,20);
    }

    private void setUserName(String userName) {
        this.userName = userName.substring(0,20);
    }

    private void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    protected String getUserLogin() {
        return userLogin;
    }

    protected String getUserName() {
        return userName;
    }

    protected String getUserPass() {
        return userPass;
    }
}
