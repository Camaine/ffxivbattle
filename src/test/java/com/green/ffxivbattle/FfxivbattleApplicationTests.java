package com.green.ffxivbattle;

import com.green.ffxivbattle.utils.AES256;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FfxivbattleApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void dataEncryptTest(){
        AES256 aes256 = new AES256();
        try {
            System.out.println("ENCRYPT : " + aes256.encrypt("test"));
        }catch (Exception e){
            System.out.println("ENCRYPT : FAIL : " + e.getMessage());
        }

    }

    @Test
    void dataDecryptTest(){
        AES256 aes256 = new AES256();
        try {
            System.out.println("DECRYPT : " + aes256.decrypt("6WBSAFH7mi7Xmu275NuLhQ=="));
        }catch (Exception e){
            System.out.println("DECRYPT : FAIL : " + e.getMessage());
        }

    }


}
