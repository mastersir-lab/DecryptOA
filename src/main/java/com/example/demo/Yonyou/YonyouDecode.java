package com.example.demo.Yonyou;

public class YonyouDecode {
    public static String Decode(String passwd) throws Exception {
        try {
            String password = passwd;
            String customKey = "1231234234";
            long key = 1231234234L;
            if (customKey != null) {
                key = Long.parseLong(customKey);
            }
            Encode encoder = new Encode();
            String plainText = encoder.decode(password, key);
            return plainText;
        }catch (Exception e){
            return " [-] 解密失败！";
        }
    }


//    public static void main(String[] args) throws Exception {
//        String aa = Decode("jlehfdffcfmohiag");
//        System.out.println(aa);
//    }
}




