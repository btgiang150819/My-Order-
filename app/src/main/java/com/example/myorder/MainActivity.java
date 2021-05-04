package com.example.myorder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    RecyclerView mList_order;
    List<Food> mList_food;
    TextView mVAT, mSUm;
    float sum , vat;
    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        mList_food.forEach(element->{
            sum += element.getAmount()*element.getQuantum();
        });
        vat = (float) (Math.round(sum*0.1*10.0)/10.0);
        sum = (float) (Math.round((vat + sum)*10.0)/10.0);
        mVAT.setText("$" + vat);
        mSUm.setText("$"+ sum);
        FoodAdapter foodAdapter = new FoodAdapter(mList_food, new OnMoney() {
            @Override
            public void setMoney(float temp) {
                sum = sum + temp;
                vat = (float) (Math.round(sum*0.1*10.0)/10.0);
                sum = (float) (Math.round((vat + sum)*10.0)/10.0);
                mVAT.setText("$" + vat);
                mSUm.setText("$"+ sum);
            }

        });
        mList_order.setAdapter(foodAdapter);
        mList_order.setLayoutManager(new LinearLayoutManager(this));

    }
    private void Anhxa(){
        sum=0;
        mVAT = findViewById(R.id.vat);
        mSUm = findViewById(R.id.sum_money);
        mList_order = findViewById(R.id.list_order);
        mList_food = new ArrayList<>();

        mList_food.add(new Food(R.drawable.canhga, "Cánh gà", 1, (float) 25.1));
        mList_food.add(new Food(R.drawable.chicken, "Đùi gà", 1, (float) 30.8));
        mList_food.add(new Food(R.drawable.hotdog, "Hot dog", 1, 20));
        mList_food.add(new Food(R.drawable.pizza, "Pizza", 1, 50));
        mList_food.add(new Food(R.drawable.download, "Ham", 1, 24));
    }
}