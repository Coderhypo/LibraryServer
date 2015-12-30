package net.ihypo.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by hypo on 15-12-30.
 */
public class ManagerAction extends ActionSupport {

    /** 作为API的返回结果的返回值 */
    private Map json;

    /** 添加管理员API实现 */
    public String addManager(){

        return SUCCESS;
    }

    /** 删除管理员API实现 */
    public String deleteManager(){

        return SUCCESS;
    }

    /** 更新管理员信息API实现 */
    public String updateManager(){

        return SUCCESS;
    }

    /** 查询管理员信息API实现 */
    public String getManager(){

        return SUCCESS;
    }
}
