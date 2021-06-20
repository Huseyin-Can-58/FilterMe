package com.example.filterme.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filterme.R;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {

    Context context;
    List<Integer> colorList;
    ColorAdapterListener listener;

    public ColorAdapter(Context context, ColorAdapterListener listener) {
        this.context = context;
        this.colorList = genColorList();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.color_item,parent,false);
        return new ColorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        holder.color_section.setCardBackgroundColor(colorList.get(position));
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ColorViewHolder extends RecyclerView.ViewHolder{

        public CardView color_section;

        public ColorViewHolder(View itemView){
            super(itemView);
            color_section = (CardView)itemView.findViewById(R.id.color_section);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onColorSelected(colorList.get(getAdapterPosition()));
                }
            });
        }
    }

    private List<Integer> genColorList() {

        List<Integer> colorList = new ArrayList<>();

        colorList.add(Color.parseColor("#ff0051"));
        colorList.add(Color.parseColor("#f95289"));
        colorList.add(Color.parseColor("#1e0f55"));
        colorList.add(Color.parseColor("#ffc63a"));
        colorList.add(Color.parseColor("#82d4f5"));
        colorList.add(Color.parseColor("#d3ffce"));
        colorList.add(Color.parseColor("#e4e1ff"));
        colorList.add(Color.parseColor("#3aaa80"));
        colorList.add(Color.parseColor("#f4af90"));
        colorList.add(Color.parseColor("#785555"));
        colorList.add(Color.parseColor("#8c0909"));
        colorList.add(Color.parseColor("#a00d0d"));
        colorList.add(Color.parseColor("#e25c00"));
        colorList.add(Color.parseColor("#0346fe"));
        colorList.add(Color.parseColor("#fc9904"));
        colorList.add(Color.parseColor("#73c303"));
        colorList.add(Color.parseColor("#e857c3"));

        return colorList;
    }

    public interface ColorAdapterListener{
        void onColorSelected(int color);
    }
}
