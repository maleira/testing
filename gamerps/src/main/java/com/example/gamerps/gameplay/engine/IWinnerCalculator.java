package com.example.gamerps.gameplay.engine;

import java.util.List;

import com.example.gamerps.gameplay.element.Player;

public interface IWinnerCalculator {

    /**
     * Calculate the Player or players (if more than 2 players) Winners.
     *
     * @param players player list.
     * @return list of players (if more than 2 players) Winners.
     */
    List<Player> calculateWinner(List<Player> players);
}
