package com.example.gamerps.gameplay.engine;

import com.example.gamerps.gameplay.element.Weapon;

public class RockWeaponStrategy implements IWeaponStrategy {
    @Override
    public Weapon chooseWeapon() {
        return Weapon.ROCK;
    }
}
