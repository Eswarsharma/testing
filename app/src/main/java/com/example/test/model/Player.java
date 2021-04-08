package com.example.test.model;

import javax.inject.Inject;

/**
 * This class is used to create a player and assign either the value X or O
 * Also, to track the current player
 */

public class Player {

    public String name;
    public String value;

    // constructor
    @Inject
    public Player(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

}
