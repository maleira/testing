package com.example.gamerps.gameplay.engine;

import java.util.Random;

import com.example.gamerps.gameplay.element.Weapon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RandomWeaponStrategyTest {

    @Test
    public void ensure_Random_Weapons_Is_Returning_Random_Values() {
        final RandomWeaponStrategy randomWeaponStrategy = Mockito.spy(RandomWeaponStrategy.class);
        final Random random = Mockito.spy(Random.class);
        final Weapon[] weaponsValues = Weapon.values();
        Mockito.when(randomWeaponStrategy.makeRandom()).thenReturn(random);
        Mockito.when(random.nextInt(weaponsValues.length)).thenReturn(0);
        Assertions.assertThat(weaponsValues[random.nextInt(weaponsValues.length)]).isEqualTo(randomWeaponStrategy.chooseWeapon());
        Mockito.when(random.nextInt(weaponsValues.length)).thenReturn(1);
        Assertions.assertThat(weaponsValues[random.nextInt(weaponsValues.length)]).isEqualTo(randomWeaponStrategy.chooseWeapon());
        Mockito.when(random.nextInt(weaponsValues.length)).thenReturn(2);
        Assertions.assertThat(weaponsValues[random.nextInt(weaponsValues.length)]).isEqualTo(randomWeaponStrategy.chooseWeapon());
    }
}
