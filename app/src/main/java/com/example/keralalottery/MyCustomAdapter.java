package com.example.keralalottery;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Lottery> {
    private ArrayList<Lottery> lotteryArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Lottery> lotteryArrayList, Context context) {
        super(context, R.layout.lottery_list_layout);
        this.lotteryArrayList = lotteryArrayList;
        this.context = context;
    }

    private static class MyViewHolder{
        TextView lotteryPrice;
        ImageView lotteryImage;
    }
}
