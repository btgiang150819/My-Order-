package com.example.myorder;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyHolder>{
    private  List<Food> foodList;
    private OnMoney onMoney;


    public FoodAdapter(List<Food> foodList, OnMoney onMoney) {
        this.foodList = foodList;
        this.onMoney = onMoney;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.avt.setImageResource(foodList.get(position).getAvt());
        holder.name.setText(foodList.get(position).getName());
        holder.quantum.setText(String.valueOf(foodList.get(position).getQuantum()));
        String s = "$" + foodList.get(position).getAmount();
        holder.amount.setText(s);
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodList.get(position).setQuantum(foodList.get(position).getQuantum()+1);
                holder.quantum.setText(String.valueOf(foodList.get(position).getQuantum()));

                if(onMoney != null){
                    onMoney.setMoney(foodList.get(position).getAmount());
                }
            }
        });
        holder.sub.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if (foodList.get(position).getQuantum() > 0) {
                    foodList.get(position).setQuantum(foodList.get(position).getQuantum() - 1);
                    holder.quantum.setText(String.valueOf(foodList.get(position).getQuantum()));
                    float temp = 0 - foodList.get(position).getAmount();
                    if (onMoney != null) {
                        onMoney.setMoney(temp);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    static class  MyHolder extends RecyclerView.ViewHolder {
        ImageView avt;
        TextView name, quantum, amount, add, sub;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            avt = itemView.findViewById(R.id.avt);
            name = itemView.findViewById(R.id.name_item);
            quantum = itemView.findViewById(R.id.quantum);
            amount = itemView.findViewById(R.id.amount);
            add = itemView.findViewById(R.id.increase);
            sub = itemView.findViewById(R.id.reduce);
        }
    }
}
