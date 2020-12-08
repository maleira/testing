package com.example.gamerps.gameplay.state;

import java.util.ArrayList;
import java.util.List;

public class GameRoundResult {

    private List<PlayerRoundResult> playersResults = new ArrayList<>();

    public List<PlayerRoundResult> getPlayersResults() {
        return playersResults;
    }

    public void setPlayersResults(final List<PlayerRoundResult> playersResults) {
        this.playersResults = playersResults;
    }

    public void addPlayersResult(final PlayerRoundResult playerRoundResult) {
        playersResults.add(playerRoundResult);
    }
}
