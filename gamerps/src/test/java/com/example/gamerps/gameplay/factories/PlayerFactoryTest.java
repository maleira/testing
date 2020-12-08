package com.example.gamerps.gameplay.factories;

import java.util.List;

import com.example.gamerps.gameplay.element.Player;
import com.example.gamerps.gameplay.element.Weapon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerFactoryTest {

    @Test
    public void test_Create_2_Players_Random_And_Rock() {
        final PlayerFactory playerFactory = new PlayerFactory();
        final List<Player> playerList = playerFactory.create(PlayerFactory.PLAYER_FACTORY_2_PLAYERS_RANDOM_AND_ROCK);
        Assertions.assertThat(playerList.size()).isEqualTo(2);
        Assertions.assertThat(playerList.get(0).getLastWeapon()).isNull();
        Assertions.assertThat(playerList.get(1).getLastWeapon()).isNull();
        playerList.get(1).executeWeaponStrategy();
        Assertions.assertThat(playerList.get(1).getLastWeapon()).isEqualTo(Weapon.ROCK);
        playerList.get(0).executeWeaponStrategy();
        Assertions.assertThat(playerList.get(0).getLastWeapon()).isIn(Weapon.values());
    }

    @Test
    public void empty_If_Create_Not_Found_Factory() {
        final PlayerFactory playerFactory = new PlayerFactory();
        final List<Player> playerList = playerFactory.create("test");
        Assertions.assertThat(playerList).isEmpty();
    }
}
