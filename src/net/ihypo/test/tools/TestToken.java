package net.ihypo.test.tools;

import net.ihypo.models.Manager;
import net.ihypo.tools.TokenTool;
import net.ihypo.user.IUser;

/**
 * Created by hypo on 15-12-26.
 */
public class TestToken {

    private static IUser getUser(){

        IUser rnt = new Manager("LOGIN", "NAME", "PASSWORD");

        return rnt;
    }

    public static void main(String[] args){

        int n = 10;
        while(n-- != 0){

            System.out.println(TokenTool.getToken(getUser()));
        }
    }
}
