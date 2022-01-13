package com.green.ffxivbattle.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES256 {
    public static String alg = "AES/CBC/PKCS5Padding";
    private final String key = "0123456789101234";
    private final String iv = key.substring(0,16);

    public String encrypt(String data) throws Exception{
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(),"AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivParameterSpec);

        byte[] encrypted = cipher.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String chiperData) throws Exception{
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(),"AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE,keySpec,ivParameterSpec);

        byte[] decodedBytes = Base64.getDecoder().decode(chiperData);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted,"UTF-8");
    }

}
