package com.example.test.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import static com.example.test.StringHelper.isNullOrEmpty;


/**
 * This class is used to create and manager all the activities related to the Game
 */

public class Game {

    private static final String TAG = "Game";

    public Player player1;
    public Player player2;

    public Player currentPlayer;
    public Cell[][] cells;

    public MutableLiveData<Player> winner = new MutableLiveData<>();

    // constructor
    @Inject
    public Game(String playerOne, String playerTwo)
    {
        Log.d(TAG, "Game: " + playerOne  +  " " + playerTwo) ;
        cells = new Cell[3][3];
        player1 = new Player(playerOne, "X"); // assign X for player 1
        player2 = new Player(playerTwo,"O"); // assign O for player 2
        currentPlayer = player1; // player 1 will be current by default
    }

    /**
     *
     * @return true,
     * if 3 rows have same values, or
     * if 3 column have same values, or
     * if 2 diagonals have same values, or
     * if all cells have values but not equal , no one is winner in this case
     */

    public boolean hasGameEnded() {
        if (isHorizontalCellsSame() || isVerticalCellsSame() || isDiagonalCellsSame()) {
            winner.setValue(currentPlayer);
            return true;
        }

        if (isBoardFull()) {
            winner.setValue(null);
            return true;
        }
        return false;
    }

    /**
     * Checks whether values of any row out of 3 is same
     * @return
     */
    public boolean isHorizontalCellsSame() {
         for (int i = 0; i < 3; i++)
                if (areEqual(cells[i][0], cells[i][1], cells[i][2]))
                    return true;

            return false;
    }

    /**
     * Checks whether values of any column out of 3 is same
     * @return
     */
    public boolean isVerticalCellsSame() {
        for (int i = 0; i < 3; i++)
                if (areEqual(cells[0][i], cells[1][i], cells[2][i]))
                    return true;
            return false;
    }

    /**
     * checks whether values of any diagonal is same
     * @return
     */
    public boolean isDiagonalCellsSame() {
        return areEqual(cells[0][0], cells[1][1], cells[2][2]) ||
                    areEqual(cells[0][2], cells[1][1], cells[2][0]);
    }

    /**
     * Checks whether the all the cells have values
     * @return
     */
    public boolean isBoardFull() {
        for (Cell[] row : cells)
            for (Cell cell : row)
                if (cell == null || cell.isEmpty())
                    return false;
        return true;
    }

    //method to check the equality of values of cell
    private boolean areEqual(Cell... cells) {
        if (cells == null || cells.length == 0)
            return false;

        for (Cell cell : cells)
            if (cell == null || isNullOrEmpty(cell.player.value))
                return false;

        Cell compare = cells[0];
        for (int i = 1; i < cells.length; i++)
            if (!compare.player.value.equals(cells[i].player.value))
                return false;

        return true;
    }

    /**
     * Method to switch between Player 1 and Player 2
     * if currentPlayer is equal to player1 , player 1 will be assigned
     * else, player2 will be assigned to currentPlayer
     * using ternary operator
     */
    public void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    /**
     * Method to clear the cells to start new game
     * Below method will be called after clicking on the Done button shown in Winner dialog
     */
    public void clearBoard()
    {
        player1 = null;
        player2 = null;
        currentPlayer = null;
        cells = null;
    }

}
