package com.example.starter;

import android.os.Bundle;

import com.example.starter.network.DataService;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataService dataService = new DataService();
    }
}