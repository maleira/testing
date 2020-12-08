package com.example.gamerps.gameplay.state;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameRpsRecordsTest {
    private List<GameRoundResult> gameRoundsPlayedResult;

    @BeforeEach
    public void setUp() {
        gameRoundsPlayedResult = Arrays.asList(new GameRoundResult(), new GameRoundResult());
    }

    @Test
    public void ensure_GameRecords_Rounds_Are_Properly_Added() {
        final IGameRecords gameSession = new GameRpsRecords();
        gameRoundsPlayedResult.forEach(gameSession::addGameRound);
        Assertions.assertThat(gameSession.getGameRoundsPlayedResult()).isNotNull();
        Assertions.assertThat(gameSession.getGameRoundsPlayedResult()).containsAll(gameRoundsPlayedResult);
    }

    @Test
    public void ensure_GameRecords_Rounds_Played_Are_Cannot_Be_Externally_Modified() {
        final IGameRecords gameSession = new GameRpsRecords();
        gameRoundsPlayedResult.forEach(gameSession::addGameRound);
        List<GameRoundResult> currentGameRoundsPlayedResult = gameSession.getGameRoundsPlayedResult();
        currentGameRoundsPlayedResult.remove(0);
        Assertions.assertThat(currentGameRoundsPlayedResult.size()).isEqualTo(1);
        Assertions.assertThat(gameSession.getGameRoundsPlayedResult().size()).isEqualTo(2);
        Assertions.assertThat(gameSession.getGameRoundsPlayedResult()).containsAll(gameRoundsPlayedResult);
    }
}
