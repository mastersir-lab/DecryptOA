package com.example.demo.FineReport;

public class FineReportDecode {
    public static String frDecrypt(String passwd) throws Exception {
        try {
            final int[] PassWordArray = {19, 78, 10, 15, 100, 213, 43, 23};
            String Key = passwd; // 密文
            if (Key != null && Key.startsWith("___")) {
                Key = Key.substring(3);
                final StringBuilder stringBuilder = new StringBuilder();
                byte Step = 0;
                for (byte i = 0; i <= Key.length() - 4; i += 4) {
                    if (Step == PassWordArray.length) {
                        Step = 0;
                    }
                    final String str = Key.substring(i, i + 4);
                    final int num = Integer.parseInt(str, 16) ^ PassWordArray[Step];
                    stringBuilder.append((char) num);
                    Step++;
                }
                Key = stringBuilder.toString();
            }
            return Key;
        }catch (Exception e){
            return " [-] 解密失败！";
        }
    }

//    public static void main(String[] args) throws Exception {
//        String aa = frDecrypt("___0072002a00670066000a");
//        System.out.println(aa);
//    }
}