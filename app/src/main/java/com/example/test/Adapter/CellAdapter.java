//package com.example.tictactoe.Adapter;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.tictactoe.R;
//import com.example.tictactoe.model.Cell;
//import com.example.tictactoe.viewmodel.MyViewModel;
//
//import java.util.List;
//
//public class CellAdapter extends RecyclerView.Adapter<CellAdapter.MyViewHolder> {
//
//    private static final String TAG = "CellAdapter";
//    Context context;
//    MyViewModel myViewModel;
//    GridLayoutManager gridLayoutManager;
//    protected PositionListener positionListener;
//
//    public CellAdapter(Context context, GridLayoutManager gridLayoutManager, PositionListener positionListener)
//    {
//        this.context = context;
//        this.gridLayoutManager = gridLayoutManager;
//        this.positionListener = positionListener;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.my_cell, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                positionListener.onClick(position);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return 9;
//    }
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView textView;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.idTVCourse);
//        }
//    }
//
//    public interface PositionListener
//    {
//        void onClick(int position);
//    }
//
//}
