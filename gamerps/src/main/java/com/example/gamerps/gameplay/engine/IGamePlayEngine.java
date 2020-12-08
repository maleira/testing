package com.example.gamerps.gameplay.engine;

import com.example.gamerps.gameplay.state.GameRoundResult;

public interface IGamePlayEngine {

    /**
     * Play a round of the game.
     *
     * @return GameRound
     */
    GameRoundResult playRound();
}
