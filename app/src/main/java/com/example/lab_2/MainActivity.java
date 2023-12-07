package com.example.lab_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList <String> content = new ArrayList<String>();
    private RecyclerView numbersList;
    private NumdersAdapter numdersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbersList = findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        numbersList.setLayoutManager(layoutManager);

        numbersList.setHasFixedSize(true);

        numdersAdapter = new NumdersAdapter(generateContent());
        numbersList.setAdapter(numdersAdapter);
    }
    public void Add_Button (View view) {
        numdersAdapter = new NumdersAdapter(generateContent());
        numbersList.setAdapter(numdersAdapter);
    }

    private ArrayList<String> generateContent() {
        content.add("Element number ");
        return content;}
    }