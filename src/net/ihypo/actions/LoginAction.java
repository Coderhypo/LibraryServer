package net.ihypo.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * 提供登录相关API的实现
 * Created by hypo on 15-12-29.
 */
public class LoginAction extends ActionSupport{

    /** 作为API的返回结果的返回值 */
    private Map json;

    /** 管理员登录API的实现 */
    public String managerLogin(){

        return SUCCESS;
    }

    /** 读者登录API的实现 */
    public String readerLogin(){

        return SUCCESS;
    }

    public Map getJson() {
        return json;
    }

    public void setJson(Map json) {
        this.json = json;
    }
}
