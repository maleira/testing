package com.example.gamerps.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.gamerps.gameplay.element.RoundGameResult;
import com.example.gamerps.gameplay.state.GameRoundResult;
import com.example.gamerps.gameplay.state.PlayerRoundResult;
import com.example.gamerps.view.GameRoundResultView;
import com.example.gamerps.view.PlayerActionView;

public class GameRpsPlayViewHelper {
    private static final String PLAYER_PREFIX_NAME = "Player";
    private static final String ROUND_RESULT_DRAW_LABEL = "Draw";
    private static final String ROUND_RESULT_WIN_LABEL = "Wins";

    private GameRpsPlayViewHelper() {
    }

    /**
     * Transform a list of GameRoundResult to a list of GameRoundResultView.
     *
     * @return list of GameRoundResultView.
     */
    public static List<GameRoundResultView> transformGameRoundResults(final List<GameRoundResult> gameRoundResults) {
        return gameRoundResults
                .stream()
                .map(GameRpsPlayViewHelper::transformGameRoundResults)
                .collect(Collectors.toList());
    }

    /**
     * Transform a GameRoundResult to a GameRoundResultView.
     *
     * @return GameRoundResultView.
     */
    private static GameRoundResultView transformGameRoundResults(final GameRoundResult gameRoundResult) {
        final GameRoundResultView gameRoundResultView = new GameRoundResultView();
        final List<PlayerActionView> playerActionViewList = new ArrayList<>();
        final List<PlayerRoundResult> playersResults = gameRoundResult.getPlayersResults();

        playersResults.forEach(playerRoundResult -> playerActionViewList.add(
                new PlayerActionView(PLAYER_PREFIX_NAME + " " + playerRoundResult.getPlayerId(),
                    playerRoundResult.getUsedWeapon().toString())));

        // Ordering the List by Name
        playerActionViewList.sort(Comparator.comparing(PlayerActionView::getPlayerName));

        gameRoundResultView.setPlayerActionViewList(playerActionViewList);

        final List<PlayerRoundResult> winners = playersResults
                .stream()
                .filter(playerRoundResult -> playerRoundResult.getRoundGameResult().equals(RoundGameResult.WIN)).collect(Collectors.toList());
        if (winners.isEmpty()) {
            // DRAW
            gameRoundResultView.setRoundResult(ROUND_RESULT_DRAW_LABEL);
        } else {
            // WIN
            final String result = winners.stream().map(winner -> PLAYER_PREFIX_NAME + " " + winner.getPlayerId())
                    .collect(Collectors.joining(",")) + " " + ROUND_RESULT_WIN_LABEL;
            gameRoundResultView.setRoundResult(result);
        }
        return gameRoundResultView;
    }

    /**
     * Get the ammount of player win.
     *
     * @param playerId id to identify the player
     * @param gameRoundResults list of GameRoundResultView.
     * @return ammount of player win.
     */
    public static long getTotalPlayerWin(final int playerId, final List<GameRoundResult> gameRoundResults) {
        return gameRoundResults
                .stream()
                .map(GameRoundResult::getPlayersResults)
                .flatMap(List::stream)
                .filter(playerRoundResult ->
                        playerRoundResult.getPlayerId() == playerId
                                && playerRoundResult.getRoundGameResult().equals(RoundGameResult.WIN))
                .count();
    }

    /**
     * Get the ammount of drow in the game.
     *
     * @param gameRoundResults list of GameRoundResultView.
     * @return ammount of draw.
     */
    public static long getTotalDraw(final List<GameRoundResult> gameRoundResults) {
        return gameRoundResults
                .stream()
                .map(GameRoundResult::getPlayersResults)
                .flatMap(List::stream)
                .filter(playerRoundResult ->
                        playerRoundResult.getPlayerId() == 1
                                && playerRoundResult.getRoundGameResult().equals(RoundGameResult.DRAW))
                .count();
    }
}
