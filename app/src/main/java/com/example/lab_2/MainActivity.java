package com.example.lab_2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText input_product;
    Button button_add;
    private ArrayList<String> content = new ArrayList<String>();
    private RecyclerView productsList;
    private ProductsAdapter productsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productsList = findViewById(R.id.recycler_view);
        input_product = findViewById(R.id.input_name_product);
        button_add = findViewById(R.id.add_button);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        productsList.setLayoutManager(layoutManager);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_product = input_product.getText().toString();
                content.add(name_product);
                productsAdapter = new ProductsAdapter(content);
                productsList.setAdapter(productsAdapter);
                input_product.getText().clear();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(button_add.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
    }

    public void Clear_Button(View view) {
        content.clear();
        productsAdapter = new ProductsAdapter(content);
        productsList.setAdapter(productsAdapter);
    }
}