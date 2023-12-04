package com.raflisalam.appteman.artikel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.raflisalam.appteman.R;

import java.util.ArrayList;

public class AdapterArtikel1 extends RecyclerView.Adapter<AdapterArtikel1.Artikel1Holder> {

    private ArrayList<Artikel1> listArtikel1;

    public AdapterArtikel1(ArrayList<Artikel1> list) {
        this.listArtikel1 = list;
    }

    @NonNull
    @Override
    public Artikel1Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_artikel1, parent, false);
        return new Artikel1Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArtikel1.Artikel1Holder holder, int position) {
        Artikel1 artikel1 = listArtikel1.get(position);
        Glide.with(holder.itemView.getContext())
            .load(artikel1.getImage())
            .apply(new RequestOptions())
            .into(holder.img);
        holder.tvSumber.setText(artikel1.getSumber());
        holder.tvJudul.setText(artikel1.getJudulBerita());
    }

    @Override
    public int getItemCount() {
        return listArtikel1.size();
    }

    public class Artikel1Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvSumber, tvJudul;

        public Artikel1Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageArtikel);
            tvJudul = itemView.findViewById(R.id.tvJudulBerita);
            tvSumber = itemView.findViewById(R.id.tvSumber);
        }
    }
}
