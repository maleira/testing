package com.example.gamerps.gameplay.factories;

/**
 * Factory Provider to create the GamePlayEngine elements.
 */
public class GamePlayFactoryProvider {
    public static final String GAMEPLAY_PROVIDER_PLAYER_FACTORY = "PLAYER_FACTORY";
    public static final String GAMEPLAY_PROVIDER_WINNER_RULES_FACTORY = "WINNER_RULES_FACTORY";

    private GamePlayFactoryProvider() {
    }

    public static IGamePlayAbstractFactory getFactory(final String choice){

        if(GAMEPLAY_PROVIDER_PLAYER_FACTORY.equalsIgnoreCase(choice)){
            return new PlayerFactory();
        }
        else if(GAMEPLAY_PROVIDER_WINNER_RULES_FACTORY.equalsIgnoreCase(choice)){
            return new WinnerRulesFactory();
        }

        return null;
    }
}
