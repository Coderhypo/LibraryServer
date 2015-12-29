package net.ihypo.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * 提供图书分类相关API的实现
 * Created by hypo on 15-12-29.
 */
public class BookTypeAction extends ActionSupport{

    /** 作为API的返回结果的返回值 */
    private Map json;

    /** 添加图书分类API实现 */
    public String addBookType(){

        return SUCCESS;
    }

    /** 删除图书分类API实现 */
    public String deleteBookType(){

        return SUCCESS;
    }

    /** 更新图书分类API实现 */
    public String updateBookType(){

        return SUCCESS;
    }

    /** 查询图书分类API实现 */
    public String getBookType(){

        return SUCCESS;
    }
}
