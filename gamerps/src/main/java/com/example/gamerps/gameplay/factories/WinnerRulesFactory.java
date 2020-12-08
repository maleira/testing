package com.example.gamerps.gameplay.factories;

import com.example.gamerps.gameplay.engine.IWinnerCalculator;
import com.example.gamerps.gameplay.engine.WinnerCalculatorStandardRpc;

public class WinnerRulesFactory implements IGamePlayAbstractFactory<IWinnerCalculator> {
    public static final String STANDARD_WINNER_RULES_RPC = "STANDARD_WINNER_RULES_RPC";

    @Override
    public IWinnerCalculator create(String type) {
        if (type.equalsIgnoreCase(STANDARD_WINNER_RULES_RPC)) {
            return new WinnerCalculatorStandardRpc();
        }

        return null;
    }
}
