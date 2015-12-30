package net.ihypo.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by hypo on 15-12-30.
 */
public class ReaderAction extends ActionSupport {

    /** 作为API的返回结果的返回值 */
    private Map json;

    /** 添加读者API实现 */
    public String addReader(){

        return SUCCESS;
    }

    /** 删除读者API实现 */
    public String deleteReader(){

        return SUCCESS;
    }

    /** 更新读者信息API实现 */
    public String updateReader(){

        return SUCCESS;
    }

    /** 查询读者信息API实现 */
    public String getReader(){

        return SUCCESS;
    }
}
