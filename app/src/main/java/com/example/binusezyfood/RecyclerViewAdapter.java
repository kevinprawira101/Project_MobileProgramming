package com.example.binusezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Drink> mData;

    public RecyclerViewAdapter(Context mContext, List<Drink> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_drink_name.setText(mData.get(position).getName());
        holder.iv_drink_img.setImageResource(mData.get(position).getImg_id());
        holder.tv_drink_price.setText("Rp. "+ String.valueOf(mData.get(position).getPrice()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DrinkDetailActivity.class);
                intent.putExtra("DrinkName",mData.get(position).getName());
                intent.putExtra("DrinkPrice",String.valueOf(mData.get(position).getPrice()));
                intent.putExtra("ImageID",mData.get(position).getImg_id());

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_drink_name;
        ImageView iv_drink_img;
        TextView tv_drink_price;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_drink_name = (TextView) itemView.findViewById(R.id.drink_name_id);
            iv_drink_img = (ImageView) itemView.findViewById(R.id.drink_img_id);
            tv_drink_price = (TextView) itemView.findViewById(R.id.drink_price_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }

}
