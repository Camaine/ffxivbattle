package com.green.ffxivbattle;

import com.green.ffxivbattle.entity.CharacterStat;
import com.green.ffxivbattle.service.CharacterStatDefineService;
import com.green.ffxivbattle.utils.AES256;
import com.green.ffxivbattle.utils.combat.Combat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CombatTests {

    private Log log = LogFactory.getLog(getClass());

    @Autowired
    private CharacterStatDefineService characterStatDefineService;

    @Test
    void combatAttackChanceTest(){
        Combat combat = new Combat();

        log.info(combat.critChance(400));
        log.info(combat.criticalDamage(400));
        log.info(combat.directHitChance(400));
        log.info(combat.defenseIncomingDamage(400));

    }

    @Test
    void combatTest(){
        AES256 aes256 = new AES256();

        String player1 = "마리";
        String player2 = "와이비";

        CharacterStat characterStat1 = new CharacterStat();
        CharacterStat characterStat2 = new CharacterStat();

        Combat combat = new Combat();

        int damage = 0;

        String encryptedValue1 = "";
        String encryptedValue2 = "";

        try{
            encryptedValue1 = aes256.encrypt(player1);
            encryptedValue2 = aes256.encrypt(player2);
            characterStat1 = characterStatDefineService.setCharacterStat(characterStat1,encryptedValue1,player1);
            characterStat2 = characterStatDefineService.setCharacterStat(characterStat2,encryptedValue2,player2);
        }catch (Exception e){
            log.error("Encrypt Error : " + e.getMessage());
        }

        while(true){
            damage = combat.autoAttackDamage(characterStat2.getAttack());
            characterStat1.setHp(characterStat1.getHp()-damage);
            log.info("##"+player2+"이(가) "+player1+"에 데미지 "+damage+"/ "+player1+" HP :"+characterStat1.getHp());
            if(characterStat1.getHp() <= 0 || characterStat2.getHp() <= 0){
                log.info("##"+player2+" 승리##");
                break;
            }

            damage = combat.autoAttackDamage(characterStat1.getAttack());
            characterStat2.setHp(characterStat2.getHp()-damage);
            log.info("##"+player1+"이(가) "+player2+"에 데미지 "+damage+"/ "+player2+" HP :"+characterStat2.getHp());
            if(characterStat1.getHp() <= 0 || characterStat2.getHp() <= 0){
                log.info("##"+player1+" 승리##");
                break;
            }

        }

    }

}
