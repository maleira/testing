package com.example.gamerps.gameplay.element;

import com.example.gamerps.gameplay.engine.IWeaponStrategy;

public class Player {
    private int id;
    private Weapon lastWeapon;
    private IWeaponStrategy weaponStrategy;

    public Player(final int id, final IWeaponStrategy weaponStrategy) {
        this.id = id;
        this.weaponStrategy = weaponStrategy;
    }

    public int getId() {
        return id;
    }

    public Weapon getLastWeapon() {
        return lastWeapon;
    }

    public void executeWeaponStrategy() {
        this.lastWeapon = weaponStrategy.chooseWeapon();
    }
}
