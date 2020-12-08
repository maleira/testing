package com.example.gamerps.gameplay.factories;

import com.example.gamerps.gameplay.engine.IWinnerCalculator;
import com.example.gamerps.gameplay.engine.WinnerCalculatorStandardRpc;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinnerCalculatorFactoryTest {

    @Test
    public void test_Create_2_Players_Random_And_Rock() {
        final WinnerRulesFactory winnerRulesFactory = new WinnerRulesFactory();
        final WinnerCalculatorStandardRpc winnerRules = (WinnerCalculatorStandardRpc) winnerRulesFactory
                .create(WinnerRulesFactory.STANDARD_WINNER_RULES_RPC);
        Assertions.assertThat(winnerRules).isNotNull();
    }

    @Test
    public void null_If_Create_Not_Found_Factory() {
        final WinnerRulesFactory winnerRulesFactory = new WinnerRulesFactory();
        final IWinnerCalculator winnerRules = winnerRulesFactory.create("test");
        Assertions.assertThat(winnerRules).isNull();
    }
}
