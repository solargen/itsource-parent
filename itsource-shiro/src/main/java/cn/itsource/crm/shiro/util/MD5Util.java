package cn.itsource.crm.shiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util {

    public static final String SALT = "itsource";

    /**
     * 加密
     * @param source
     * @return
     */
    public static String encrypt(String source){
        SimpleHash simpleHash = new SimpleHash("MD5",source,SALT,10);
        return simpleHash.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("admin"));
    }

}
