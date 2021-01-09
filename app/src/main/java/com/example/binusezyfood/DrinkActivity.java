package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrinkActivity extends AppCompatActivity{

    List<Drink> listdrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        listdrink = new ArrayList<>();
        listdrink.add(new Drink("Air Mineral",4000,R.drawable.air_mineral));
        listdrink.add(new Drink("Jus Apel",10000,R.drawable.apple_juice));
        listdrink.add(new Drink("Jus Mangga",11000,R.drawable.mango_juice));
        listdrink.add(new Drink("Jus Alpukat",14000,R.drawable.avocado_juice));
        listdrink.add(new Drink("Jus Jeruk",10000,R.drawable.orange_juice));
        listdrink.add(new Drink("Jus Semangka",10000,R.drawable.watermelon_juice));
        listdrink.add(new Drink("Jus Strawberry",12000,R.drawable.strawberry));
        listdrink.add(new Drink("Jus Tomat",10000,R.drawable.tomato_juice));
        listdrink.add(new Drink("Aneka Soda",7000,R.drawable.soda));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,listdrink);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }

    public void toMyOrder(View view){
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

}
