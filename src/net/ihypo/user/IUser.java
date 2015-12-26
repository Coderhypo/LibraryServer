package net.ihypo.user;

/**
 * 用户接口 规定了用户的基础操作
 * Created by hypo on 15-12-26.
 */
public interface IUser {
    /**
     * 获得用户ID方法
     * @return 返回用户的ID
     */
    Integer getUserId();

    /**
     * 获得用户的登录名
     * @return 返回用户的登录名
     */
    String getUserLogin();

    /**
     * 获得用户的昵称（名称）
     * @return 返回用户名称
     */
    String getUserName();

    /**
     * 更新用户名称
     * @param userName 新用户名称
     */
    void setUserName(String userName);

    /**
     * 获得用户密码
     * @return 返回已经加密的用户密码
     */
    String getUserPass();

    /**
     * 更新用户密码
     * @param userPass 新用户密码
     */
    void setUserPass(String userPass);

    /**
     * 获得用户Token
     * @return 返回用户token
     */
    String getUserToken();

    /**
     * 获得用户权限标识符
     * @return 读者返回 READER | 管理员返回 MANAGER
     */
    String getUserRule();
}
