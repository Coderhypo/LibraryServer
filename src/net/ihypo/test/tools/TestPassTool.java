package net.ihypo.test.tools;

import net.ihypo.models.Manager;
import net.ihypo.tools.PasswordTool;
import net.ihypo.user.IUser;

/**
 * Created by hypo on 15-12-26.
 */
public class TestPassTool {

    private static IUser getUser(){

        IUser rnt = new Manager("LOGIN", "NAME", "PASSWORD");

        return rnt;
    }

    public static void main(String[] args){

        String s = "PASSWORD";

        String pass = PasswordTool.getPass(s);

        System.out.println(pass);
        System.out.println(getUser().getUserPass());
        System.out.println(PasswordTool.verify(s, getUser()));

        assert PasswordTool.verify(s, getUser());
    }
}
