package com.example.binusezyfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DrinkDetailActivity extends AppCompatActivity {

    private TextView tvname, tvprice;
    private ImageView img;

    List<OrderList> orderlist;
    MyApplication myApplication = (MyApplication) this.getApplication();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinkdetail);

        orderlist = myApplication.getOrderlist();

        tvname = (TextView) findViewById(R.id.drinknameid);
        tvprice = (TextView) findViewById(R.id.drinkpriceid);
        img = (ImageView) findViewById(R.id.order_img_id);

        Intent intent = getIntent();
        String Drink_Name = intent.getExtras().getString("DrinkName");
        String Drink_Price = intent.getExtras().getString("DrinkPrice");
        int image = intent.getExtras().getInt("ImageID");

        tvname.setText(Drink_Name);
        tvprice.setText(Drink_Price);
        img.setImageResource(image);

    }

    public void toOrder(View view) {
        TextView order_tvname = (TextView) findViewById(R.id.drinknameid);
        TextView order_tvprice = (TextView) findViewById(R.id.drinkpriceid);
        EditText etqty = (EditText) findViewById(R.id.qty_id);
        int nextId = myApplication.getNextId();
        OrderList  newOrderList = new OrderList(order_tvname.getText().toString(), Integer.parseInt(order_tvprice.getText().toString()), Integer.parseInt(etqty.getText().toString()));

        orderlist.add(newOrderList);
        myApplication.setNextId(nextId++);

        Intent intent = new Intent(this, DrinkActivity.class);
        startActivity(intent);
    }

    public void toMyOrder(View view){
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}
