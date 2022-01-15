package com.green.ffxivbattle;

import com.green.ffxivbattle.service.CharacterStatDefineService;
import com.green.ffxivbattle.utils.AES256;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CharacterStatDefineTests {

    private Log log = LogFactory.getLog(getClass());

    @Autowired
    private CharacterStatDefineService characterStatDefineService;

    @Test
    void characterStatDefineTest(){
        log.info("####PLAYER 1 STAT###");
        characterStatDefineService.defineRandomStat("테스터1");
        log.info("####PLAYER 2 STAT###");
        characterStatDefineService.defineRandomStat("테스터2");

    }

}
