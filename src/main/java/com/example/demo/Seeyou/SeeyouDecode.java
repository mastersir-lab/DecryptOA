package com.example.demo.Seeyou;

import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class SeeyouDecode {
    public static String zyDecrypt(String passwd) throws Exception {
        try {
//        String input = "/1.0/VWZ0dTIzNC8=";
            String input = passwd;
            String base64String = input.substring(5); // 去掉前五位
            byte[] decodedBytes = Base64.getDecoder().decode(base64String); // 进行base64解码
            String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
            char secondChar = input.charAt(1); // 获取解密后的字符串中的第二位字符
            int numericValue = Character.getNumericValue(secondChar);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < decodedString.length(); i++) {
                result.append((char) (decodedString.charAt(i) - numericValue));
            }
            return result.toString();
        }catch (Exception e){
            return " [-] 解密失败！";
        }
    }

}