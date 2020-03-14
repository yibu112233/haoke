package com.haoke.util.encryptionUtil;

import java.util.Base64;

public class EncyptUtil {

    private static EncyptUtil encyptUtil ;

    public static EncyptUtil getBase64(){
        synchronized(EncyptUtil.class) {
            if (encyptUtil == null) {
                encyptUtil = new EncyptUtil();
            }
        }
           return encyptUtil;
    }
    //编码
    public String encodeByBase64(String str){
       byte[] encodeByte= Base64.getEncoder().encode(str.getBytes());
       return new String(encodeByte);
    }
    //解码
    public String decodeByBase64(String str){
        byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes());
        return new String(decodeBytes);
    }

    public static void main(String[] args) {
        EncyptUtil base64Encypt= EncyptUtil.getBase64();
        String encode=base64Encypt.encodeByBase64("12321");
        System.out.println(encode);

        String decode=base64Encypt.decodeByBase64(encode);
        System.out.println(decode);
    }
}
