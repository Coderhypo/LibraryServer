package net.ihypo.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * 提供错误使用API时的反馈
 * Created by hypo on 15-12-29.
 */
public class ErrorAction extends ActionSupport{

    /** 作为API的返回结果的返回值 */
    private Map json;

    /** 使用API的URI错误NOT FIND */
    public String notFind(){

        return SUCCESS;
    }

    public Map getJson() {
        return json;
    }

    public void setJson(Map json) {
        this.json = json;
    }
}
