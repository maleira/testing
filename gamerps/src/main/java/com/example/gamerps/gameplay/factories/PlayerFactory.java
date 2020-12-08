package com.example.gamerps.gameplay.factories;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.gamerps.gameplay.element.Player;
import com.example.gamerps.gameplay.engine.RandomWeaponStrategy;
import com.example.gamerps.gameplay.engine.RockWeaponStrategy;

public class PlayerFactory implements IGamePlayAbstractFactory<List<Player>> {
    public static final String PLAYER_FACTORY_2_PLAYERS_RANDOM_AND_ROCK = "2_PLAYERS_RANDOM_AND_ROCK";

    @Override
    public List<Player> create(String type) {
        if (type.equalsIgnoreCase(PLAYER_FACTORY_2_PLAYERS_RANDOM_AND_ROCK)) {
            final Player player1 = new Player(1, new RandomWeaponStrategy());
            final Player player2 = new Player(2, new RockWeaponStrategy());
            return Arrays.asList(player1, player2);
        }

        return Collections.emptyList();
    }
}
