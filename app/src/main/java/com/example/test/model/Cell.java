package com.example.test.model;

import com.example.test.StringHelper;
import javax.inject.Inject;

/**
 * This class represents each cell
 */

public class Cell {

    public Player player;

    // Constructor which initializes Player class to track current player
    @Inject
    public Cell(Player player) {
        this.player = player;
    }

    // method to check empty or null of the particular cell
    public boolean isEmpty() {
        return player == null || StringHelper.isNullOrEmpty(player.value);
    }
}
