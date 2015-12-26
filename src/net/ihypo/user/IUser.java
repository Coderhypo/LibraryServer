package net.ihypo.user;

/**
 * Created by hypo on 15-12-26.
 */
public interface IUser {
    Integer getUserId();
    String getUserLogin();
    String getUserName();
    void setUserName(String userName);
    String getUserPass();
    void setUserPass(String userPass);
    String getUserToken();
    String getUserRule();
}
