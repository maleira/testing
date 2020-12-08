package com.example.gamerps.gameplay.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;

import com.example.gamerps.gameplay.element.Player;
import com.example.gamerps.gameplay.element.RoundGameResult;
import com.example.gamerps.gameplay.factories.PlayersRpsFactory;
import com.example.gamerps.gameplay.state.GameRoundResult;
import com.example.gamerps.gameplay.state.GameRpsRecords;
import com.example.gamerps.gameplay.state.PlayerRoundResult;
import org.springframework.stereotype.Service;

/**
 * Gameplay RPS engine. It could work with more than 2 players.
 *
 */
@Service
public class GamePlayRpsEngine implements IGamePlayEngine {

    @Resource(name = "&playerFactory")
    private PlayersRpsFactory playerFactory;

    @Resource(name = "winnerRulesFactory")
    private IWinnerCalculator winnerCalculator;

    // We will store the GameRpsRecords in this Map
    private Map<String, GameRpsRecords> gameRpsRecords = new HashMap<>();

    @Override
    public void playRound(final String gameSessionId) throws Exception {
        final GameRpsRecords gameRpsRecord = gameRpsRecords.get(gameSessionId);
        if (gameRpsRecord != null) {
            final List<Player> playerList = playerFactory.getObject().getPlayers();
            playerList.forEach(Player::executeWeaponStrategy);
            final List<Player> winners = winnerCalculator.calculateWinner(playerList);
            gameRpsRecord.addGameRound(generateGameRoundResult(playerList, winners));
        } else {
            throw new IllegalArgumentException("Unidentified gameSessionId control");
        }
    }

    @Override
    public List<GameRoundResult> getGameRoundResults(final String gameSessionId) {
        return gameRpsRecords.get(gameSessionId).getGameRoundsPlayedResult();
    }

    @Override
    public String createNewGameSession() {
        // I know I can improve this key generation to take care of Thread Safe and to avoid duplicates,
        // but it is enought for testing purpose.
        final String gameSessionId = UUID.randomUUID().toString();
        gameRpsRecords.put(gameSessionId, new GameRpsRecords());
        return gameSessionId;
    }

    /**
     * Transform ina Game round result the current round.
     *
     * @param playerList participating players
     * @param winners winning players
     * @return GameRoundResult result of the current round.
     */
    private GameRoundResult generateGameRoundResult(final List<Player> playerList, final List<Player> winners) {
        final GameRoundResult gameRoundResult = new GameRoundResult();
        if (winners.isEmpty()) {
            // This is draw
            playerList.forEach(player -> gameRoundResult.addPlayersResult(new PlayerRoundResult(player.getId(), player.getLastWeapon(), RoundGameResult.DRAW)));
        } else {
            // Winners
            winners.forEach(player -> gameRoundResult.addPlayersResult(new PlayerRoundResult(player.getId(), player.getLastWeapon(), RoundGameResult.WIN)));
            // Losers
            playerList
                    .stream()
                    .filter(player -> !winners.contains(player))
                    .forEach(player -> gameRoundResult.addPlayersResult(new PlayerRoundResult(player.getId(), player.getLastWeapon(), RoundGameResult.LOSE)));
        }

        return gameRoundResult;
    }
}
