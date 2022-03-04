package com.green.ffxivbattle.utils.character.melee;

public class MeleeCmmnSkill {
    public int secondwindSkill(int attack){
        return (int)(attack*600/1000 + attack/10);
    }
}
