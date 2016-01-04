package net.ihypo.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * 借阅图书，归还图书相关操作
 * Created by hypo on 16-1-4.
 */
public class OperatorAction extends ActionSupport {

    /** 作为API的返回结果的返回值 */
    private Map json;

    /** 借阅图书API的实现 */
    public String lendBook(){

        return SUCCESS;
    }

    /** 归还图书API的实现 */
    public String returnBook(){

        return SUCCESS;
    }

    public Map getJson() {
        return json;
    }

    public void setJson(Map json) {
        this.json = json;
    }
}
