package com.frank.chapter412.utils;

import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

public class CamelUnderlineTransformUtils {

    private static final char UNDERLINE = '_';

    /**
     * 驼峰转下划线
     * @param str
     * @return
     */
    public static String camelToUnderline(String str) {
        if (str == null || "".equals(str.trim())) {
            return "";
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线转驼峰
     * @param str
     * @return
     */
    public static String underlineToCamel(String str) {
        if (str == null || "".equals(str.trim())) return "";
        StringBuilder sb = new StringBuilder(str);
        Matcher mc = compile("_").matcher(str);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }
}