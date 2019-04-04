package com.aditya.alquranapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    String[]namaSurah;
    int[]gambarSurah;

    public CustomAdapter(Context context, String[] namaSurah, int[] gambarSurah) {
        super(context, R.layout.list_item,namaSurah);
        this.context = context;
        this.namaSurah = namaSurah;
        this.gambarSurah = gambarSurah;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        //Sambung layout item
        View itemView=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        //Kenalan dengan Komponen didalam list item
        TextView judul = itemView.findViewById(R.id.tvjudul);
        ImageView gambar=itemView.findViewById(R.id.ivGambar);

        //Set datanya
        judul.setText(namaSurah[position]);
        gambar.setImageResource(gambarSurah[position]);
        return itemView;
    }
}
