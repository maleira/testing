package com.example.gamerps.gameplay.element;

import java.util.List;

public class GamePlayers {
    private List<Player> players;

    public GamePlayers(final List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(final List<Player> players) {
        this.players = players;
    }
}
