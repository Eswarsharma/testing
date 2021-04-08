package com.example.test.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.test.R;

public class SecondActivity extends AppCompatActivity {

//    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_second);
//        binding.recyclerView.setLayoutManager(new GridLayoutManager(SecondActivity.this, 3));
////        binding.recyclerView.setAdapter(new CellAdapter(SecondActivity.this));
    }
}