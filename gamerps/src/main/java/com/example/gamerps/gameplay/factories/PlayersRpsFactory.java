package com.example.gamerps.gameplay.factories;

import java.util.Arrays;

import com.example.gamerps.gameplay.element.GamePlayers;
import com.example.gamerps.gameplay.element.Player;
import com.example.gamerps.gameplay.engine.RandomWeaponStrategy;
import com.example.gamerps.gameplay.engine.RockWeaponStrategy;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Rock-paper-scissors Factory to generate the Players in the game.
 */
public class PlayersRpsFactory extends AbstractFactoryBean<GamePlayers> {

    public PlayersRpsFactory() {
        setSingleton(false);
    }

    @Override
    public Class<?> getObjectType() {
        return GamePlayers.class;
    }

    @Override
    protected GamePlayers createInstance() throws Exception {
        final Player player1 = new Player(1, new RandomWeaponStrategy());
        final Player player2 = new Player(2, new RockWeaponStrategy());
        return new GamePlayers(Arrays.asList(player1, player2));
    }
}
