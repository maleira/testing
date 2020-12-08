package com.example.gamerps.gameplay.factories;

import java.util.List;
import javax.annotation.Resource;

import com.example.gamerps.gameplay.element.GamePlayers;
import com.example.gamerps.gameplay.element.Player;
import com.example.gamerps.gameplay.element.Weapon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerRpsFactoryTest {

    @Resource(name = "playerFactory")
    private GamePlayers gamePlayers;

    @Resource(name = "&playerFactory")
    private PlayersRpsFactory playerFactory;

    @Test
    public void test_GamePlayers_Random_And_Rock() {
        final List<Player> playerList = gamePlayers.getPlayers();
        Assertions.assertThat(playerList.size()).isEqualTo(2);
        Assertions.assertThat(playerList.get(0).getLastWeapon()).isNull();
        Assertions.assertThat(playerList.get(1).getLastWeapon()).isNull();
        playerList.get(1).executeWeaponStrategy();
        Assertions.assertThat(playerList.get(1).getLastWeapon()).isEqualTo(Weapon.ROCK);
        playerList.get(0).executeWeaponStrategy();
        Assertions.assertThat(playerList.get(0).getLastWeapon()).isIn(Weapon.values());
    }

    @Test
    public void test_Player_Factory_creation() throws Exception {
        final List<Player> playerList1 = playerFactory.createInstance().getPlayers();
        final List<Player> playerList2 = playerFactory.createInstance().getPlayers();
        Assertions.assertThat(playerList1.size()).isEqualTo(2);
        Assertions.assertThat(playerList1.get(1).getLastWeapon()).isNull();
        playerList1.get(1).executeWeaponStrategy();
        Assertions.assertThat(playerList1.get(1).getLastWeapon()).isEqualTo(Weapon.ROCK);

        Assertions.assertThat(playerList2.size()).isEqualTo(2);
        Assertions.assertThat(playerList2.get(1).getLastWeapon()).isNull();
        playerList2.get(1).executeWeaponStrategy();
        Assertions.assertThat(playerList2.get(1).getLastWeapon()).isEqualTo(Weapon.ROCK);

        Assertions.assertThat(playerList1.get(0) != playerList2.get(0));
        Assertions.assertThat(playerList1.get(1) != playerList2.get(1));
    }
}
