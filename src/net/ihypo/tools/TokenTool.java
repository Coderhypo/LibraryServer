package net.ihypo.tools;

import net.ihypo.user.IUser;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by hypo on 15-12-26.
 */
public class TokenTool {

    /**
     * 计算获得用户的Token
     * @param user token所属用户
     * @return     返回用户的token
     */
    public static String getToken(IUser user){

        String token = user.getUserLogin() + user.getUserPass() + user.getUserRule();
        token +=  new Random().nextLong();
        MessageDigest md5= null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64en = new BASE64Encoder();
        
        try {
            assert md5 != null;
            token=base64en.encode(md5.digest(token.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        token = token.substring(1,9);
        return token;
    }

    /**
     * 验证用户token是否匹配
     * @param token 输入的token
     * @param user  需要验证的用户
     * @return      返回验证结果 true：成功 | false：失败
     */
    public static Boolean verify(String token, IUser user){

        if (token.equals(user.getUserToken())){
            return true;
        }
        return false;
    }
}
