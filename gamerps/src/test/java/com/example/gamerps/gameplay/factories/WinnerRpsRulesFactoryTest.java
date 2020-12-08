package com.example.gamerps.gameplay.factories;

import javax.annotation.Resource;

import com.example.gamerps.gameplay.engine.IWinnerCalculator;
import com.example.gamerps.gameplay.engine.WinnerCalculatorStandardRpc;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WinnerRpsRulesFactoryTest {

    @Resource(name = "winnerRulesFactory")
    private IWinnerCalculator winnerCalculator;

    @Resource(name = "&winnerRulesFactory")
    private WinnerRpsRulesFactory winnerCalculatorFactory;

    @Test
    public void test_WinnerRules_is_properly_created() {
        Assertions.assertThat(winnerCalculator).isInstanceOf(WinnerCalculatorStandardRpc.class);
    }

    @Test
    public void ensure_Factory_Creation_Is_Working() {
        final IWinnerCalculator winnerCalculator1 = winnerCalculatorFactory.createInstance();
        final IWinnerCalculator winnerCalculator2 = winnerCalculatorFactory.createInstance();
        Assertions.assertThat(winnerCalculator1).isInstanceOf(WinnerCalculatorStandardRpc.class);
        Assertions.assertThat(winnerCalculator2).isInstanceOf(WinnerCalculatorStandardRpc.class);
        Assertions.assertThat(winnerCalculator1 != winnerCalculator2);
    }
}
