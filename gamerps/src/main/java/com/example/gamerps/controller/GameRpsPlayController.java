package com.example.gamerps.controller;

import java.util.List;

import com.example.gamerps.gameplay.engine.IGamePlayEngine;
import com.example.gamerps.gameplay.state.GameRoundResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * GamePlay Rps View Controller.
 */
@Controller
public class GameRpsPlayController {
    public static final String GAME_BOARD_VIEW_NAME = "gameRpsBoard";
    public static final String SCORE_SUMMARY_VIEW_NAME = "rpsScoreSummary";

    public static final String START_NEW_GAME_ACTION_URI = "startNewGame";
    public static final String PLAY_ROUND_GAME_ACTION_URI = "playRoundRps";
    public static final String SCORE_SUMMARY_GAME_ACTION_URI = "rpsScoreSummary";

    public static final String GAME_SESSION_ID_FIELD_NAME = "gameSessionId";
    public static final String GAME_SESSION_RECORDS_ENTITY_NAME = "gameSessionRounds";

    public static final String SCORE_SUMMARY_ROUNDS_NUMBER_NAME = "roundsTotal";
    public static final String SCORE_SUMMARY_PLAYER1_WIN_NAME = "player1WinTotal";
    public static final String SCORE_SUMMARY_PLAYER2_WIN_NAME = "player2WinTotal";
    public static final String SCORE_SUMMARY_DRAW_NAME = "drawTotal";

    final Logger logger = LoggerFactory.getLogger(GameRpsPlayController.class);

    @Autowired
    private IGamePlayEngine gamePlayEngine;

    @GetMapping("/" + START_NEW_GAME_ACTION_URI)
    public String startNewGame(Model model) {
        // Create new Game Session
        final String gameSessionId = gamePlayEngine.createNewGameSession();
        logger.info("New gameSessionId: {}", gameSessionId);
        final List<GameRoundResult> gameSessionRecords = gamePlayEngine.getGameRoundResults(gameSessionId);
        model.addAttribute(GAME_SESSION_ID_FIELD_NAME, gameSessionId);
        model.addAttribute(GAME_SESSION_RECORDS_ENTITY_NAME, GameRpsPlayViewHelper.transformGameRoundResults(gameSessionRecords));
        return GAME_BOARD_VIEW_NAME;
    }

    @PostMapping("/" + PLAY_ROUND_GAME_ACTION_URI)
    public String playRoundRps(@RequestParam("gameSessionId") final String gameSessionId, Model model) throws Exception {
        logger.info("New PlayRound Rps from gameSessionId: {}", gameSessionId);
        gamePlayEngine.playRound(gameSessionId);
        final List<GameRoundResult> gameSessionRecords = gamePlayEngine.getGameRoundResults(gameSessionId);
        model.addAttribute(GAME_SESSION_ID_FIELD_NAME, gameSessionId);
        model.addAttribute(GAME_SESSION_RECORDS_ENTITY_NAME, GameRpsPlayViewHelper.transformGameRoundResults(gameSessionRecords));
        return GAME_BOARD_VIEW_NAME;
    }

    @GetMapping("/" + SCORE_SUMMARY_GAME_ACTION_URI)
    public String rpsScoreSummary(Model model) {
        logger.debug("Rendering Score Summary");
        final List<GameRoundResult> gameSessionRecords = gamePlayEngine.getFullGameRoundResults();
        model.addAttribute(SCORE_SUMMARY_ROUNDS_NUMBER_NAME, gameSessionRecords.size());
        model.addAttribute(SCORE_SUMMARY_PLAYER1_WIN_NAME, GameRpsPlayViewHelper.getTotalPlayerWin(1, gameSessionRecords));
        model.addAttribute(SCORE_SUMMARY_PLAYER2_WIN_NAME, GameRpsPlayViewHelper.getTotalPlayerWin(2, gameSessionRecords));
        model.addAttribute(SCORE_SUMMARY_DRAW_NAME, GameRpsPlayViewHelper.getTotalDraw(gameSessionRecords));
        return SCORE_SUMMARY_VIEW_NAME;
    }

}
