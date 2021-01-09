package com.example.binusezyfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderFinalActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FinalRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView tv_total;

    MyApplication myApplication = (MyApplication) this.getApplication();
    List<OrderList> orderlist;
    public static int total = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderfinal);

        total = 0;
        orderlist = MyApplication.getOrderlist();
        tv_total = findViewById(R.id.total_id);

        if(orderlist.size() != 0){
            for(int i=0;i<orderlist.size();i++){
                total += (orderlist.get(i).getPrice()*orderlist.get(i).getQty());
            }
        }

        tv_total.setText(String.valueOf(total));

        buildRecyclerView();
    }

    private void buildRecyclerView() {

        mRecyclerView = findViewById(R.id.recyclerview3_id);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new FinalRecyclerViewAdapter(this, orderlist);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void toMain(View view){
        orderlist.removeAll(orderlist);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
