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

public class AdapterArtikel2 extends RecyclerView.Adapter<AdapterArtikel2.Artikel2Holder> {

    private ArrayList<Artikel2> listArtikel2;

    public AdapterArtikel2(ArrayList<Artikel2> list) {
        this.listArtikel2 = list;
    }

    @NonNull
    @Override
    public Artikel2Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_artikel2, parent, false);
        return new Artikel2Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArtikel2.Artikel2Holder holder, int position) {
        Artikel2 artikel2 = listArtikel2.get(position);
        Glide.with(holder.itemView.getContext())
            .load(artikel2.getImage())
            .apply(new RequestOptions())
            .into(holder.img);
        holder.tvSumber.setText(artikel2.getSumber());
        holder.tvJudul.setText(artikel2.getJudulBerita());
        holder.tvTagline.setText(artikel2.getTagline());
    }

    @Override
    public int getItemCount() {
        return listArtikel2.size();
    }

    public class Artikel2Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvSumber, tvJudul, tvTagline;

        public Artikel2Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageArtikel2);
            tvJudul = itemView.findViewById(R.id.tvJudulBerita);
            tvTagline = itemView.findViewById(R.id.tvTagline);
            tvSumber = itemView.findViewById(R.id.tvSumber);
        }
    }
}
