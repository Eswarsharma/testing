package com.example.test.viewmodel;

import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.di.AppComponent;
import com.example.test.di.DaggerModule;
import com.example.test.model.Cell;
import com.example.test.model.Game;
import com.example.test.model.Player;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import static com.example.test.StringHelper.stringFromNumbers;

/**
 * ViewModel that binds to the activity_main_screen.xml file
 */

public class MyViewModel extends ViewModel {

    public ObservableArrayMap<String, String> cells;
    private Game game;

    // method to initialize the game with given players
    public void startGame(String playerOne, String playerTwo) {
        game = new Game(playerOne, playerTwo);
        cells = new ObservableArrayMap<>();
    }

    // called when once cell clicked out of 9 cells in GridView
    public void onClickedCellAt(int row, int column) {
        if (game.cells[row][column] == null) {
            game.cells[row][column] = new Cell(game.currentPlayer);
            // set the value into the cell. The value might be X or O based on the current player
            cells.put(stringFromNumbers(row,column), game.currentPlayer.value);

            if (game.hasGameEnded())
                game.clearBoard(); // clear the cells
            else
                game.switchPlayer();
        }
    }

    // method to return the winner
    public LiveData<Player> getWinner() {
        return game.winner;
    }
}
