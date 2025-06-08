package org.gfg.util;

public class StringUtil {

    public static boolean isBlank(String s){
        return s == null || s.isEmpty();
    }

    public static boolean isNoBlank(String s){
        if (s!=null && s.length()>0){
            return true;
        }
        return false;
    }


}
