package com.example.gamerps.gameplay.engine;

import com.example.gamerps.gameplay.element.Weapon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RockWeaponStrategyTest {

    @Test
    public void ensure_Rock_Weapons_Strategy_Is_Returning_Rock() {
        final RockWeaponStrategy rockWeaponStrategy = new RockWeaponStrategy();
        Assertions.assertThat(rockWeaponStrategy.chooseWeapon()).isEqualTo(Weapon.ROCK);
    }
}
