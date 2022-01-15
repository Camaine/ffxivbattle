package com.green.ffxivbattle.service;

import com.green.ffxivbattle.entity.CharacterStat;
import com.green.ffxivbattle.utils.AES256;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CharacterStatDefineService {

    private final Log log = LogFactory.getLog(getClass());


    public void characterStatDefine(String nickname){

        //get random stat from nickname
        //set stat in characterStat class
    }

    public void defineRandomStat(String nickname){
        AES256 aes256 = new AES256();
        CharacterStat characterStat = new CharacterStat();

        String encryptedValue = "";

        try{
            encryptedValue = aes256.encrypt(nickname);
            characterStat = setCharacterStat(characterStat,encryptedValue,nickname);
            log.info(encryptedValue);
        }catch (Exception e){
            log.error("Encrypt Error : " + e.getMessage());
        }

    }

    public CharacterStat setCharacterStat(CharacterStat characterStat, String encryptedValue, String nickname){
        characterStat.setNickname(nickname);
        characterStat.setCritical(adjustStatValue(encryptedValue.charAt(0),0));
        characterStat.setDirecthit(adjustStatValue(encryptedValue.charAt(1),0));
        characterStat.setDetermination(adjustStatValue(encryptedValue.charAt(2),0));
        characterStat.setDefense(adjustStatValue(encryptedValue.charAt(3),1));
        characterStat.setHp(adjustStatValue(encryptedValue.charAt(4),2));
        characterStat.setJob(defineRandomJob(encryptedValue.charAt(5)));
        log.info("Critical : "+ characterStat.getCritical());
        log.info("Directhit : "+ characterStat.getDirecthit());
        log.info("Determination : "+ characterStat.getDetermination());
        log.info("Defense : "+ characterStat.getDefense());
        log.info("HP : "+ characterStat.getHp());
        log.info("JOB : "+ characterStat.getJob());
        return characterStat;
    }

    public int adjustStatValue(int value, int option){
        if(option == 1){ // Defense
            return value/2;
        }

        if(option == 2){ // HP
            value = value*876;
            if(value < 50000){
                return value * 2;
            }
            return value;
        }
        return value+300;
    }

    public String defineRandomJob(int value){
        value = value%4;
        if(value == 0){
            return "DRG";
        }

        if(value == 1){
            return "SAM";
        }

        if(value == 2){
            return "BRD";
        }

        return "BLM";
    }
}
