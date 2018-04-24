package com.lotterytechnology.lottery.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ryder
 * create at 2018/4/24 17:17
 * package name:com.lotterytechnology.lottery.utils
 * description:
 **/
public class Utils {
    /**
     * 校验手机号码
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
//        if (TextUtils.isEmpty(phone)) return false;
        Pattern p = Pattern.compile("^1\\d{10}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }


    /**
     * 校验密码格式
     *
     * @param pwd
     * @return
     */
    public static boolean verifyPwdFormat(String pwd) {
//        if (TextUtils.isEmpty(pwd)) return false;
        Pattern p = Pattern.compile("^[A-Za-z][0-9A-Za-z_]{5,15}$");
        Matcher m = p.matcher(pwd);
        return m.matches();
    }

}
