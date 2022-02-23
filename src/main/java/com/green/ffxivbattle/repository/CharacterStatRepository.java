package com.green.ffxivbattle.repository;

import com.green.ffxivbattle.entity.CharacterStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterStatRepository extends JpaRepository<CharacterStat, Integer> {
}
