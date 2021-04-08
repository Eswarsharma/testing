package com.example.test.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.test.R;
import com.example.test.databinding.ActivityMainScreenBinding;
import com.example.test.model.Player;
import com.example.test.viewmodel.MyViewModel;

import static com.example.test.StringHelper.isNullOrEmpty;

/**
 * Main Activity
 */

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
    }

    // method to initialize the dataBinding
    private void initDataBinding()
    {
        ActivityMainScreenBinding activityMainScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_screen);
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.startGame(getResources().getString(R.string.allPlayerOne), getResources().getString(R.string.allPlayerTwo));
        activityMainScreenBinding.setViewModel(myViewModel);
        myViewModel.getWinner().observe(this, this::getWinner);
    }

    // Method to observe the winner
    private void getWinner(Player winner) {
        String winnerName = winner == null || isNullOrEmpty(winner.name) ? getString(R.string.mainActivityNoWinner) : winner.name;
        showWinnerDialog(winnerName);
    }

    // Method to display the dialog with winner name
    private void showWinnerDialog(String winnerName) {
        AlertDialog.Builder winnerDialog = new AlertDialog.Builder(this);
        winnerDialog.setCancelable(false);
        String winnerNameText = String.format(getResources().getString(R.string.mainScreenWinnerDialogTitle), winnerName);
        winnerDialog.setMessage(winnerNameText);
        winnerDialog.setPositiveButton(getResources().getString(R.string.mainActivityOkButtonWinnerDialog), onClickListener).create().show();
    }

    // dismiss the dialog and initiate the game again when ok button clicked on dialog
    private final DialogInterface.OnClickListener onClickListener = (dialog, which) -> initDataBinding();
}