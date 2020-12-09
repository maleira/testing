package com.example.gamerps.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent the Round information in the view.
 */
public class GameRoundResultView {

    private List<PlayerActionView> playerActionViewList = new ArrayList<>();

    private String roundResult;

    public List<PlayerActionView> getPlayerActionViewList() {
        return playerActionViewList;
    }

    public void setPlayerActionViewList(final List<PlayerActionView> playerActionViewList) {
        this.playerActionViewList = playerActionViewList;
    }

    public String getRoundResult() {
        return roundResult;
    }

    public void setRoundResult(final String roundResult) {
        this.roundResult = roundResult;
    }
}
