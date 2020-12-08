package com.example.gamerps.gameplay.engine;

import java.util.Arrays;
import java.util.List;

import com.example.gamerps.gameplay.element.Player;
import com.example.gamerps.gameplay.element.Weapon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WinnerCalculatorStandardRpcTest {
    private Player playerRock;
    private Player playerPaper;
    private Player playerScissor;

    private final WinnerCalculatorStandardRpc winnerCalculator = new WinnerCalculatorStandardRpc();

    @BeforeEach
    public void setUp() {
        playerRock = Mockito.mock(Player.class);
        playerPaper = Mockito.mock(Player.class);
        playerScissor = Mockito.mock(Player.class);
        Mockito.when(playerRock.getLastWeapon()).thenReturn(Weapon.ROCK);
        Mockito.when(playerPaper.getLastWeapon()).thenReturn(Weapon.PAPER);
        Mockito.when(playerScissor.getLastWeapon()).thenReturn(Weapon.SCISSORS);
    }

    @Test
    public void ensure_Winner_Is_PlayerRock_Against_PlayerScissors() {
        final List<Player> playerWinners = winnerCalculator.calculateWinner(Arrays.asList(playerRock, playerScissor));
        Assertions.assertThat(playerWinners.size()).isEqualTo(1);
        Assertions.assertThat(playerWinners.get(0)).isEqualTo(playerRock);
    }

    @Test
    public void ensure_Winner_Is_PlayerPaper_Against_PlayerRock() {
        final List<Player> playerWinners = winnerCalculator.calculateWinner(Arrays.asList(playerPaper, playerRock));
        Assertions.assertThat(playerWinners.size()).isEqualTo(1);
        Assertions.assertThat(playerWinners.get(0)).isEqualTo(playerPaper);
    }

    @Test
    public void ensure_Winner_Is_PlayerScissor_Against_PlayerPaper() {
        final List<Player> playerWinners = winnerCalculator.calculateWinner(Arrays.asList(playerScissor, playerPaper));
        Assertions.assertThat(playerWinners.size()).isEqualTo(1);
        Assertions.assertThat(playerWinners.get(0)).isEqualTo(playerScissor);
    }

    @Test
    public void ensure_Winner_Are_Both_When_Drow() {
        final Player playerRock2 = Mockito.mock(Player.class);
        Mockito.when(playerRock2.getLastWeapon()).thenReturn(Weapon.ROCK);
        Assertions.assertThat(winnerCalculator.calculateWinner(Arrays.asList(playerRock, playerRock2))).isEmpty();
    }

    @Test
    public void ensure_Drow_When_All_Weapons_In_Play() {
        Assertions.assertThat(winnerCalculator.calculateWinner(Arrays.asList(playerRock, playerScissor, playerPaper))).isEmpty();
    }
}
