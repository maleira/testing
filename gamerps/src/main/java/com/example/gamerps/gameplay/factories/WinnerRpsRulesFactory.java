package com.example.gamerps.gameplay.factories;

import com.example.gamerps.gameplay.engine.IWinnerCalculator;
import com.example.gamerps.gameplay.engine.WinnerCalculatorStandardRpc;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Rock-paper-scissors Factory to generate the Winner Rules in the game.
 */
public class WinnerRpsRulesFactory extends AbstractFactoryBean<IWinnerCalculator> {

    public WinnerRpsRulesFactory() {
        setSingleton(false);
    }

    @Override
    public Class<?> getObjectType() {
        return IWinnerCalculator.class;
    }

    @Override
    protected IWinnerCalculator createInstance() {
        return new WinnerCalculatorStandardRpc();
    }
}
