package net.ihypo.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * 提供图书增删改查的API
 * Created by hypo on 15-12-29.
 */
public class BookAction extends ActionSupport {

    /** 作为API的返回结果的返回值 */
    private Map json;

    /** 添加图书API实现 */
    public String addBook(){

        return SUCCESS;
    }

    /** 删除图书API实现 */
    public String deleteBook(){

        return SUCCESS;
    }

    /** 更新图书API实现 */
    public String updateBook(){

        return SUCCESS;
    }

    /** 查询图书API实现 */
    public String getBook(){

        return SUCCESS;
    }

}
