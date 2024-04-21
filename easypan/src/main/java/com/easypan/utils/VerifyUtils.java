package com.easypan.utils;


import com.easypan.entity.enums.*;

import java.io.*;
import java.util.regex.*;

public class VerifyUtils {

    public static boolean verify(String regex, String value) {
        if (StringTools.isEmpty(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean verify(VerifyRegexEnum regex, String value) {
        return verify(regex.getRegex(), value);
    }

    public static void main(String[] args) {
        System.out.println(new File("E:\\代码生成\\..\\workspace-java").exists());

    }
}

