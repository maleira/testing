package com.example.gamerps.gameplay.state;

import com.example.gamerps.gameplay.element.RoundGameResult;
import com.example.gamerps.gameplay.element.Weapon;

public class PlayerRoundResult {

    private int playerId;
    private Weapon usedWeapon;
    private RoundGameResult roundGameResult;

    public PlayerRoundResult(final int playerId, final Weapon usedWeapon, final RoundGameResult roundGameResult) {
        this.playerId = playerId;
        this.usedWeapon = usedWeapon;
        this.roundGameResult = roundGameResult;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(final int playerId) {
        this.playerId = playerId;
    }

    public Weapon getUsedWeapon() {
        return usedWeapon;
    }

    public void setUsedWeapon(final Weapon usedWeapon) {
        this.usedWeapon = usedWeapon;
    }

    public RoundGameResult getRoundGameResult() {
        return roundGameResult;
    }

    public void setRoundGameResult(final RoundGameResult roundGameResult) {
        this.roundGameResult = roundGameResult;
    }
}
