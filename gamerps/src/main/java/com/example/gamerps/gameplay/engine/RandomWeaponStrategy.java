package com.example.gamerps.gameplay.engine;

import java.util.Random;

import com.example.gamerps.gameplay.element.Weapon;

public class RandomWeaponStrategy implements IWeaponStrategy {
    @Override
    public Weapon chooseWeapon() {
        final Weapon[] weaponsValues = Weapon.values();
        final Random random = makeRandom();
        return weaponsValues[random.nextInt(weaponsValues.length)];
    }

    /**
     * Make Random function to be able to test the strategy.
     *
     * @return Random value.
     */
    public Random makeRandom() {
        return new Random();
    }
}
