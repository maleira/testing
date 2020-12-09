package com.example.gamerps.gameplay.engine;

import java.util.List;

import com.example.gamerps.gameplay.state.GameRoundResult;

public interface IGamePlayEngine {

    /**
     * Play a round of the Rock-paper-scissors game.
     *
     * @param gameSessionId Game Session Id.
     * @throws Exception if error or gameSessionId not found.
     */
    void playRound(String gameSessionId) throws Exception;

    /**
     * Retrieve the list of Game Rounds Result to the GameId.
     *
     * @param gameSessionId Game Session Id.
     * @return list of Game Rounds Result.
     */
    List<GameRoundResult> getGameRoundResults(String gameSessionId);

    /**
     * Retrieve the full list of Game Rounds Result.
     *
     * @return list of all Game Rounds Result.
     */
    List<GameRoundResult> getFullGameRoundResults();

    /**
     * Create a new Game Session in the system.
     * @return Game Session Id.
     */
    String createNewGameSession();
}
