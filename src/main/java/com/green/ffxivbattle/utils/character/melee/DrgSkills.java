package com.green.ffxivbattle.utils.character.melee;

public class DrgSkills {

    public int jumpSkill(int attack){
        return attack*210/100 + attack;
    }

    public int geirskogulSkill(int attack){
        return attack*300/100 + attack;
    }

    public int stardiverSkill(int attack){
        return attack*600/100 + attack;
    }

}
