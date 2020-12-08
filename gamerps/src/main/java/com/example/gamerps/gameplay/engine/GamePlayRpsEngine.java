package com.example.gamerps.gameplay.engine;

import java.util.List;

import com.example.gamerps.gameplay.element.Player;
import com.example.gamerps.gameplay.factories.GamePlayFactoryProvider;
import com.example.gamerps.gameplay.factories.PlayerFactory;
import com.example.gamerps.gameplay.factories.WinnerRulesFactory;
import com.example.gamerps.gameplay.state.GameRoundResult;

/**
 * Gameplay engine instance.
 *
 */
public class GamePlayRpsEngine implements IGamePlayEngine {

    @Override
    public GameRoundResult playRound() {
        final PlayerFactory playerFactory = (PlayerFactory) GamePlayFactoryProvider
                .getFactory(GamePlayFactoryProvider.GAMEPLAY_PROVIDER_PLAYER_FACTORY);

        final List<Player> players = playerFactory
                .create(PlayerFactory.PLAYER_FACTORY_2_PLAYERS_RANDOM_AND_ROCK);

        final WinnerRulesFactory winnerRuleFactory = (WinnerRulesFactory) GamePlayFactoryProvider
                .getFactory(GamePlayFactoryProvider.GAMEPLAY_PROVIDER_WINNER_RULES_FACTORY);

        final IWinnerCalculator winnerRules = winnerRuleFactory
                .create(WinnerRulesFactory.STANDARD_WINNER_RULES_RPC);

        return executePlayRound(players, winnerRules);
    }

    /**
     * Execute a playRound and generate a GameRoundResult.
     *
     * @param players list of player are playing the round.
     * @param winnerRules Rules will apply to declare the winner.
     * @return GameRoundResult.
     */
    private GameRoundResult executePlayRound(final List<Player> players, final IWinnerCalculator winnerRules) {
        players.stream().forEach(Player::executeWeaponStrategy);
        final List<Player> winners = winnerRules.calculateWinner(players);
        return new GameRoundResult();
    }
}
