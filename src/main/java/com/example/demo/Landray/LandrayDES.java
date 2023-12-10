package com.example.demo.Landray;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class LandrayDES {
    public static String key = "";
    private static final String ALGORITHM_NAME = "DES";
    private static final String ALGORITHM_MODE_PADDING = "DES/ECB/PKCS5Padding";

    public static String decrypt(String encryptedText, String key) throws Exception {
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        SecretKeySpec keySpec = new SecretKeySpec(fixKeySize(key), ALGORITHM_NAME);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    private static byte[] fixKeySize(String key) {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        byte[] fixedKey = new byte[8];
        System.arraycopy(keyBytes, 0, fixedKey, 0, Math.min(keyBytes.length, 8));
        return fixedKey;
    }

    public static String llDecryptCon(String passwd,int selectnum) throws Exception {
        if(selectnum == 0){
            key = "kmssPropertiesKey";
        }else {
            key = "kmssAdminKey";
        }
        try {
            String decryptedText = decrypt(passwd, key);
            return decryptedText;
        } catch (Exception e) {
            return " [-] 解密失败！";
        }
    }


}

//    public static void main(String[] args) throws Exception {
//        //login.do  前台密码
//        LandrayDES des1 = new LandrayDES("kmssPropertiesKey");
//        System.out.println(des1.decryptString("edlR+Pow/ew="));
//        //admin.do：后台密码
//        LandrayDES des2 = new LandrayDES("kmssAdminKey");
//        System.out.println(des2.decryptString("JMK83aAgUCrm2fHdvJWIEQ=="));
//    }
