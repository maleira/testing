package com.example.gamerps.gameplay.engine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.gamerps.gameplay.element.GamePlayers;
import com.example.gamerps.gameplay.element.Player;
import com.example.gamerps.gameplay.element.RoundGameResult;
import com.example.gamerps.gameplay.factories.PlayersRpsFactory;
import com.example.gamerps.gameplay.state.GameRoundResult;
import com.example.gamerps.gameplay.state.PlayerRoundResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GamePlayRpsEngineTest {

    @Mock
    private PlayersRpsFactory playerFactory;

    @Mock
    private IWinnerCalculator winnerCalculator;

    @InjectMocks
    private GamePlayRpsEngine gamePlayRpsEngine;

    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() throws Exception {
        player1 = new Player(1, new RandomWeaponStrategy());
        player2 = new Player(2, new RockWeaponStrategy());
        final GamePlayers gamePlayers = new GamePlayers(Arrays.asList(player1, player2));
        final List<Player> winnerList = Collections.singletonList(player1);
        Mockito.when(playerFactory.getObject()).thenReturn(gamePlayers);
        Mockito.when(winnerCalculator.calculateWinner(gamePlayers.getPlayers())).thenReturn(winnerList);
    }

    @Test
    public void ensure_GameSession_Is_Properly_Generated() {
        final String gameSessionId = gamePlayRpsEngine.createNewGameSession();
        Assertions.assertThat(gameSessionId).isNotNull();
        Assertions.assertThat(gamePlayRpsEngine.getGameRoundResults(gameSessionId)).isEmpty();
    }

    @Test
    public void ensure_playRound_Add_The_Proper_GameRoundResult_To_GameRpsRecords() throws Exception {
        final String gameSessionId = gamePlayRpsEngine.createNewGameSession();
        gamePlayRpsEngine.playRound(gameSessionId);
        List<GameRoundResult> results = gamePlayRpsEngine.getGameRoundResults(gameSessionId);
        Assertions.assertThat(results).isNotEmpty();
        Assertions.assertThat(results.size()).isEqualTo(1);
        List<PlayerRoundResult> playerResults = results.get(0).getPlayersResults();
        Assertions.assertThat(playerResults.size()).isEqualTo(2);
        final List<PlayerRoundResult> winnerPlayerResult = playerResults.stream()
                .filter(playerRoundResult -> playerRoundResult.getRoundGameResult().equals(RoundGameResult.WIN))
                .collect(Collectors.toList());
        final List<PlayerRoundResult> loserPlayerResult = playerResults.stream()
                .filter(playerRoundResult -> playerRoundResult.getRoundGameResult().equals(RoundGameResult.LOSE))
                .collect(Collectors.toList());
        Assertions.assertThat(winnerPlayerResult.size()).isEqualTo(1);
        Assertions.assertThat(winnerPlayerResult.get(0).getPlayerId()).isEqualTo(player1.getId());
        Assertions.assertThat(loserPlayerResult.size()).isEqualTo(1);
        Assertions.assertThat(loserPlayerResult.get(0).getPlayerId()).isEqualTo(player2.getId());
    }
}
