package com.ctgu.jiujiu_usedcar.config;

public class RandomStringUtil {
 
    /**
     * 生成随机字符串
     *
     * @param stringLength:生成的字符串长度
     * @return
     */
    public static String getRandomString(int stringLength) {
        String string = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringLength; i++) {
            int index = (int) Math.floor(Math.random() * string.length());//向下取整0-25
            sb.append(string.charAt(index));
        }
        return sb.toString();
    }
}