package com.example.gamerps.gameplay.factories;

import com.example.gamerps.gameplay.element.GamePlayers;
import com.example.gamerps.gameplay.engine.IWinnerCalculator;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rock-paper-scissors Game Factories configuration.
 */
@Configuration
public class GameRpsFactoryConfiguration {
    @Bean
    public FactoryBean<GamePlayers> playerFactory() {
        return new PlayersRpsFactory();
    }

    @Bean
    public FactoryBean<IWinnerCalculator> winnerRulesFactory() {
        return new WinnerRpsRulesFactory();
    }
}
