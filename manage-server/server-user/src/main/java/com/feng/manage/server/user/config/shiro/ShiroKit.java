package com.feng.manage.server.user.config.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.Random;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 14:23
 * @Description: shiro工具类
 */
public class ShiroKit {

    /**
     * 加盐参数
     */
    public final static String HASH_ALGORITHM_NAME = "MD5";
    /**
     * 循环次数
     */
    public final static int HASH_ITERATIONS = 1024;


    public final static int SALT_LENGTH = 4;


    /**
     * 生成新密码
     *
     * @param password 明文密码
     * @param salt     密码盐
     * @return
     */
    public static String generatePassword(String password, String salt) {
        SimpleHash hash = new SimpleHash(ShiroKit.HASH_ALGORITHM_NAME, password, new Md5Hash(salt), ShiroKit.HASH_ITERATIONS);
        return hash.toString();
    }

    /**
     * 生成密码盐
     *
     * @return
     */
    public static String generateSalt() {
        return generateSalt(SALT_LENGTH);
    }

    /**
     * 生成密码盐
     *
     * @param length
     * @return
     */
    public static String generateSalt(int length) {
        String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(35);
            salt.append(source.charAt(idx));
        }
        return salt.toString();
    }

    public static void main(String[] args) {

        System.out.println(generatePassword("123456", "haha"));

    }
}
