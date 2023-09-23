package com.example.keralalottery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Lottery lottery = getItem(position);

        //Inflating the View
        MyViewHolder myViewHolder;
        final View result;
        if (convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.lottery_list_layout,
                    parent,
                    false
            );

        //Finding the Views
            myViewHolder.lotteryPrice = (TextView) convertView.findViewById(R.id.price);
            myViewHolder.lotteryImage = (ImageView) convertView.findViewById(R.id.imageView3);

            result = convertView;

            convertView.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }
        myViewHolder.lotteryPrice.setText(lottery.getLotteryPrize());
        myViewHolder.lotteryImage.setImageResource(lottery.getLotteryImage());

        return result;
    }
}
