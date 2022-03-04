package com.green.ffxivbattle.utils.combat;

import java.util.Random;

public class Combat {

    public float critChance(int critical){
        return ((200*(critical-380)/1300)+50)/10.0f;
    }

    public float criticalDamage(int critical){
        return ((200*(critical-380)/1300)+1400)/10.0f;
    }

    public float directHitChance(int directHit){

        return (550*(directHit-380)/1300)/10.0f;
    }

    public float defenseIncomingDamage(int defense){
        return (1000-(15*defense)/1300)/10.0f;
    }

    public int autoAttackDamage(int attack){
        Random random = new Random();
        float crit = random.nextFloat();
        return (int) (attack * crit / 10 + attack);
    }
}
