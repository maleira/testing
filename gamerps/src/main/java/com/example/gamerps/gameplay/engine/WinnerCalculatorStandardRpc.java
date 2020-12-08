package com.example.gamerps.gameplay.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.gamerps.gameplay.element.Player;
import com.example.gamerps.gameplay.element.Weapon;

/**
 * Standard Winner calculator to Rock-paper-scissors game.
 *
 */
public class WinnerCalculatorStandardRpc implements IWinnerCalculator {
    @Override
    public List<Player> calculateWinner(List<Player> players) {
        final List<Weapon> weaponsInPlay = getDifferentPlayerWeaponsList(players);
        if (weaponsInPlay.size() == 2) {
            // We can calculate the Weapon Winner
            final Weapon weaponWinner = calculateWeaponWinner(weaponsInPlay.get(0), weaponsInPlay.get(1));
            return getPlayersWithWinnerWeapon(players, weaponWinner);
        } else {
            // There are no winners but drow
            // If weaponsInPlay.size() == 1 then all players have the same weapon
            // If weaponsInPlay.size() == 3 then all players have the different weapons (no winners)
            return new ArrayList<>();
        }
    }

    /**
     * Select the winner players from the players array.
     *
     * @param players player list
     * @param weaponWinner weapon winner
     * @return list of player winners.
     */
    private List<Player> getPlayersWithWinnerWeapon(final List<Player> players, final Weapon weaponWinner) {
        return players.stream()
                .filter(player -> player.getLastWeapon().equals(weaponWinner))
                .collect(Collectors.toList());
    }

    /**
     * Calculate the weapon winner between 2 Rock-paper-scissors weapons.
     *
     * @param weapon1 first weapon.
     * @param weapon2 second weapon.
     * @return Weapon winner.
     */
    private Weapon calculateWeaponWinner(final Weapon weapon1, final Weapon weapon2) {
        if (weapon1.equals(Weapon.ROCK)) {
            return weapon2.equals(Weapon.SCISSORS) ? weapon1 : weapon2;
        } else if (weapon1.equals(Weapon.PAPER)) {
            return weapon2.equals(Weapon.ROCK) ? weapon1 : weapon2;
        } else {
            return weapon2.equals(Weapon.PAPER) ? weapon1 : weapon2;
        }
    }

    /**
     * Get the List of Weapons used by the players without duplicates.
     *
     * @param players players in the game.
     * @return list of Different Weapons.
     */
    private List<Weapon> getDifferentPlayerWeaponsList(final List<Player> players) {
        return players.stream()
                .map(Player::getLastWeapon)
                .distinct()
                .collect(Collectors.toList());
    }
}
