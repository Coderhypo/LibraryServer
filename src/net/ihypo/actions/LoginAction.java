package net.ihypo.actions;

import com.opensymphony.xwork2.ActionSupport;
import net.ihypo.database.IDAO;
import net.ihypo.database.ManagerDAO;
import net.ihypo.models.Manager;
import net.ihypo.tools.PasswordTool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提供登录相关API的实现
 * Created by hypo on 15-12-29.
 */
public class LoginAction extends ActionSupport{

    private String login;
    private String pass;

    /** 作为API的返回结果的返回值 */
    private Map json;

    /** 管理员登录API的实现 */
    public String managerLogin(){

        IDAO dao = new ManagerDAO();
        String HQL = "FROM Manager m WHERE m.userLogin=" + login;
        List<Manager> list = dao.query(HQL);

        if(list.size() != 0) {

            Manager manager = list.get(0);

            if(PasswordTool.verify(pass, manager)){

                // 更新token
                manager.updateToken();
                dao.update(manager);

                json = new HashMap<>();
                json.put("status", "200");
                json.put("userid", manager.getUserId());
                json.put("username", manager.getUserName());
                json.put("token", manager.getUserToken());

                return SUCCESS;
            }
        }

        json = new HashMap<>();
        json.put("status","403");
        json.put("message","登录名或密码错误");

        return SUCCESS;
    }

    /** 读者登录API的实现 */
    public String readerLogin(){

        return SUCCESS;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Map getJson() {
        return json;
    }

    public void setJson(Map json) {
        this.json = json;
    }
}
