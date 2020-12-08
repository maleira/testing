package com.example.gamerps.gameplay.factories;

import java.util.Arrays;
import java.util.List;

import com.example.gamerps.gameplay.element.Player;
import com.example.gamerps.gameplay.element.Weapon;
import com.example.gamerps.gameplay.engine.WinnerCalculatorStandardRpc;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GamePlayFactoryProviderTest {
    @Test
    public void givenGamePlayAbstractFactory_WhenGettingObjects_ThenSuccessful() {
        IGamePlayAbstractFactory abstractFactory;

        // Creating a 2 Players (Random + Rock) and Standard Winner Rules
        abstractFactory = GamePlayFactoryProvider.getFactory(GamePlayFactoryProvider.GAMEPLAY_PROVIDER_PLAYER_FACTORY);
        final List<Player> playerList = (List<Player>) abstractFactory
                .create(PlayerFactory.PLAYER_FACTORY_2_PLAYERS_RANDOM_AND_ROCK);

        abstractFactory = GamePlayFactoryProvider.getFactory(GamePlayFactoryProvider.GAMEPLAY_PROVIDER_WINNER_RULES_FACTORY);
        final WinnerCalculatorStandardRpc winnerCalculator = (WinnerCalculatorStandardRpc) abstractFactory
                .create(WinnerRulesFactory.STANDARD_WINNER_RULES_RPC);

        // Assert PlayerFactory creation
        Assertions.assertThat(playerList.size()).isEqualTo(2);
        Assertions.assertThat(playerList.size()).isEqualTo(2);
        Assertions.assertThat(playerList.get(0).getLastWeapon()).isNull();
        Assertions.assertThat(playerList.get(1).getLastWeapon()).isNull();
        playerList.get(1).executeWeaponStrategy();
        Assertions.assertThat(playerList.get(1).getLastWeapon()).isEqualTo(Weapon.ROCK);

        // Assert WinnerRuleFactory creation
        Player playerRock = Mockito.mock(Player.class);
        Player playerPaper = Mockito.mock(Player.class);
        Mockito.when(playerRock.getLastWeapon()).thenReturn(Weapon.ROCK);
        Mockito.when(playerPaper.getLastWeapon()).thenReturn(Weapon.PAPER);

        final List<Player> playerWinners = winnerCalculator.calculateWinner(Arrays.asList(playerRock, playerPaper));
        Assertions.assertThat(playerWinners.size()).isEqualTo(1);
        Assertions.assertThat(playerWinners.get(0)).isEqualTo(playerPaper);
    }
}
