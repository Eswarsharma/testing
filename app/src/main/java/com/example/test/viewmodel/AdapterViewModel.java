//package com.example.tictactoe.viewmodel;
//
//import android.widget.TextView;
//
//import androidx.databinding.Bindable;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//import androidx.recyclerview.widget.GridLayoutManager;
//
//import com.example.tictactoe.BR;
//import com.example.tictactoe.model.Game;
//
//import java.util.HashMap;
//
//
//public class AdapterViewModel extends ViewModel {
//
//    private GridLayoutManager gridLayoutManager;
//    public MutableLiveData<TextView> cell;
//    public Game game;
//
//    @Bindable
//    public int cellPosition;
//
//    @Bindable
//    public String text;
//
//    public AdapterViewModel(String player1, String player2, GridLayoutManager gridLayoutManager)
//    {
//         game = new Game(player1, player2);
//         cell = new MutableLiveData<>();
//         this.gridLayoutManager = gridLayoutManager;
//    }
//
////    public HashMap<Integer, String> onCellClicked()
////    {
////        HashMap<Integer, String> hashMap = new HashMap<>();
////        return ;
////    }
//
//    public int getCellPosition() {
//        return cellPosition;
//    }
//
//    public void setCellPosition(int cellPosition) {
//        this.cellPosition = cellPosition;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//}
