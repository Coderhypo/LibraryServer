package net.ihypo.models;

import net.ihypo.tools.PasswordTool;
import net.ihypo.tools.TokenTool;
import net.ihypo.user.IUser;

/**
 * 管理员类，与数据库中managers表对应
 * Created by hypo on 15-12-26.
 */
public class Manager implements IUser {

    private Integer userId;
    private String userLogin;
    private String userName;
    private String userToken;
    private String userPass;

    public Manager(String userLogin, String userName, String userPass) {
        this.userLogin = userLogin;
        this.userName = userName;
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
        return "MANAGER";
    }

    @Override
    public void updateToken() {
        setUserToken();
    }

    private void setUserToken() {
        this.userToken = TokenTool.getToken(this);
    }
}
