package com.example.gamerps.view;

/**
 * Class to represent the Player Action in the view.
 */
public class PlayerActionView {
    private String playerName;
    private String weapon;

    public PlayerActionView(final String playerName, final String weapon) {
        this.playerName = playerName;
        this.weapon = weapon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(final String playerName) {
        this.playerName = playerName;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(final String weapon) {
        this.weapon = weapon;
    }
}
