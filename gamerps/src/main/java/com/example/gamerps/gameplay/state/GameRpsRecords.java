package com.example.gamerps.gameplay.state;

import java.util.ArrayList;
import java.util.List;

/**
 * GameRecords implementation to cover the Rock-paper-scissors game.
 */
public class GameRpsRecords implements IGameRecords {

    private final List<GameRoundResult> gameRoundsPlayedResult;

    public GameRpsRecords() {
        this.gameRoundsPlayedResult = new ArrayList<>();
    }

    @Override
    public List<GameRoundResult> getGameRoundsPlayedResult() {
        // we will return a copy list to avoid external access
        return new ArrayList<>(gameRoundsPlayedResult);
    }

    @Override
    public void addGameRound(GameRoundResult gameRoundResult) {
        gameRoundsPlayedResult.add(gameRoundResult);
    }
}
