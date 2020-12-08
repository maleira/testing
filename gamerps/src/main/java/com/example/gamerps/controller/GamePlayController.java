package com.example.gamerps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * GamePlay View Controller.
 */
@Controller
public class GamePlayController {
    public static final String GAME_BOARD_VIEW_NAME = "gameBoard";
    public static final String START_NEW_GAME_ACTION_URI = "startNewGame";

    @GetMapping("/" + START_NEW_GAME_ACTION_URI)
    public String startNewGame(Model model) {
        // Create new Game Session
        return GAME_BOARD_VIEW_NAME;
    }

}
