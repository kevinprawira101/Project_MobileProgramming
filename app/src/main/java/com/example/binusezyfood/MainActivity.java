package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void toDrink(View view) {
        Intent intent = new Intent(this, DrinkActivity.class);
        startActivity(intent);
    }

    public void toMyOrder(View view){
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}