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
        characterStat.setCritical(adjustStatValue(encryptedValue.charAt(0),3));
        characterStat.setDirecthit(adjustStatValue(encryptedValue.charAt(1),4));
        characterStat.setDetermination(adjustStatValue(encryptedValue.charAt(2),5));
        characterStat.setDefense(adjustStatValue(encryptedValue.charAt(3),1));
        characterStat.setHp(adjustStatValue(encryptedValue.charAt(4),2));
        characterStat.setJob(defineRandomJob(encryptedValue.charAt(5)));
        characterStat.setAttack(adjustStatValue(encryptedValue.charAt(6),6));
        log.info("Nickname : " + characterStat.getNickname());
        log.info("Critical : "+ characterStat.getCritical());
        log.info("Directhit : "+ characterStat.getDirecthit());
        log.info("Determination : "+ characterStat.getDetermination());
        log.info("Defense : "+ characterStat.getDefense());
        log.info("Attack : "+ characterStat.getAttack());
        log.info("HP : "+ characterStat.getHp());
        log.info("JOB : "+ characterStat.getJob());
        return characterStat;
    }

    public int adjustStatValue(int value, int option){
        if(option == 1){ // Defense
            return value*46;
        }

        if(option == 2){ // HP
            value = value*876;
            if(value < 50000){
                return value * 2;
            }
            return value;
        }

        if(option == 3){ // Crit
            return value*31;
        }

        if(option == 4){ // DH
            return value*26;
        }

        if(option == 5){ // DET
            return value*21;
        }

        if(option == 6){ // ATTACK
            return value*51;
        }
        return value;
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
