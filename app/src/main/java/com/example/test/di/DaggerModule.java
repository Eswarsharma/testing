package com.example.test.di;

import com.example.test.model.Game;

import dagger.Module;
import dagger.Provides;

@Module
public class DaggerModule {

    private final String playerOne;
    private final String playerTwo;

    public DaggerModule(String playerOne, String playerTwo)
    {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    @Provides
    Game createGame()
    {
        return new Game(playerOne, playerTwo);
    }

}
