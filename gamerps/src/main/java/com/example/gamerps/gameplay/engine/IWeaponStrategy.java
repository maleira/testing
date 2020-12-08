package com.example.gamerps.gameplay.engine;

import com.example.gamerps.gameplay.element.Weapon;

public interface IWeaponStrategy {

    /**
     * Strategy to model the Choose Weapon when the players play
     * @return Weapon chose.
     */
    Weapon chooseWeapon();
}
