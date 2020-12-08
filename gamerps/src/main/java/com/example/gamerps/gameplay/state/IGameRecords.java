package com.example.gamerps.gameplay.state;

import java.util.List;

public interface IGameRecords {

    /**
     * Get the Historic records of Game Rounds played in the Game records.
     *
     * @return list of Game Rounds played in the Games records.
     */
    List<GameRoundResult> getGameRoundsPlayedResult();

    /**
     * Add a new GameRoundResult in the Game records.
     *
     * @param gameRoundResult to add in the Game Rounds played list.
     */
    void addGameRound(GameRoundResult gameRoundResult);
}
