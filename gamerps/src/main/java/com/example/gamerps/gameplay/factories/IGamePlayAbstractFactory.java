package com.example.gamerps.gameplay.factories;

public interface IGamePlayAbstractFactory<T> {
    /**
     * Create the different Factories to be used in the GamePlayEngine.
     *
     * @param type of element
     * @return Concrete Factory to be used.
     */
    T create(String type);
}
