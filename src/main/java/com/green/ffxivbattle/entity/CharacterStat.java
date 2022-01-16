package com.green.ffxivbattle.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TB_CHARACTER_INFO")
public class CharacterStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nickname", length = 20)
    private String nickname;

    @Column(name = "job", length = 10)
    private String job;

    @Column(name = "hp")
    private int hp;

    @Column(name = "attack")
    private int attack;

    @Column(name = "critical")
    private int critical;

    @Column(name = "directhit")
    private int directhit;

    @Column(name = "determination")
    private int determination;

    @Column(name = "defense")
    private int defense;

}
