package net.ihypo.models;

import net.ihypo.tools.PasswordTool;
import net.ihypo.tools.TokenTool;
import net.ihypo.user.IUser;

/**
 * 读者类，与数据库中readers对应
 * Created by hypo on 15-12-26.
 */
public class Reader implements IUser{

    private Integer userId;
    private String userLogin;
    private String userName;
    private String userToken;
    private String userPass;
    private Double debt;

    public Reader(String userLogin, String userName, String userPass) {
        this.userLogin = userLogin;
        this.userName = userName;
        this.debt = 0.0;
        setUserPass(userPass);
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserLogin() {
        return userLogin;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = PasswordTool.getPass(userPass);
        setUserToken();
    }

    public String getUserToken() {
        return userToken;
    }

    public String getUserRule(){
        return "READER";
    }

    @Override
    public void updateToken() {
        setUserToken();
    }

    private void setUserToken() {
        this.userToken = TokenTool.getToken(this);
    }

    public Double getDebt() {
        return debt;
    }

    public void setDebt(Double debt) {
        this.debt = debt;
    }
}
