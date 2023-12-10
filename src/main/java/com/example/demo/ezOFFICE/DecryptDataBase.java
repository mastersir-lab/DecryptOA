package com.example.demo.ezOFFICE;

import com.example.demo.ezOFFICE.AESEncryptor;

public class DecryptDataBase  {
    public static String whDecryptCon(String passwd) throws Exception {
        String str2 = passwd;
        try {
            String res = AESEncryptor.decrypt("whir2014", str2.substring("{AES}".length()));
            return res;
        } catch (Exception e) {
            return " [-] 解密失败！";
        }
    }
//    public static void main(String[] args) throws Exception {
//        String x = whDecrypt("{AES}57AAE56A1A1239836179190485A2F927");
//        System.out.println(x);
//    }
}