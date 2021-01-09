package com.example.binusezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FinalRecyclerViewAdapter extends RecyclerView.Adapter<FinalRecyclerViewAdapter.FinalViewHolder> {

    private List<OrderList> mData;
    private Context mContext;


    public static class FinalViewHolder extends RecyclerView.ViewHolder{
        TextView order_drink_name;
        TextView order_drink_price;
        TextView order_drink_qty;


        public FinalViewHolder(@NonNull View itemView) {
            super(itemView);

            order_drink_name = (TextView) itemView.findViewById(R.id.orderList_name_id);
            order_drink_price = (TextView) itemView.findViewById(R.id.orderList_price_id);
            order_drink_qty = (TextView) itemView.findViewById(R.id.orderList_qty_id);
        }
    }

    public FinalRecyclerViewAdapter(Context mContext, List<OrderList> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public FinalRecyclerViewAdapter.FinalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_final_list,parent,false);
        return new FinalRecyclerViewAdapter.FinalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FinalRecyclerViewAdapter.FinalViewHolder holder, final int position) {
        holder.order_drink_name.setText(mData.get(position).getName());
        holder.order_drink_price.setText("Rp. "+ String.valueOf(mData.get(position).getPrice()));
        holder.order_drink_qty.setText(String.valueOf(mData.get(position).getQty()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
