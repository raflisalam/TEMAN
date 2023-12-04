package com.raflisalam.appteman.fitur2;

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

public class AdapterFitur2 extends RecyclerView.Adapter<AdapterFitur2.Fitur2Holder> {

    private ArrayList<Fitur2> listFitur2;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public AdapterFitur2(ArrayList<Fitur2> list) {
        this.listFitur2 = list;
    }

    @NonNull
    @Override
    public Fitur2Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_penyakitpadi, parent, false);
        return new Fitur2Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterFitur2.Fitur2Holder holder, int position) {
        Fitur2 fitur2 = listFitur2.get(position);
        Glide.with(holder.itemView.getContext())
                .load(fitur2.getImage())
                .apply(new RequestOptions())
                .into(holder.img);
        holder.namaPenyakit.setText(fitur2.getNamaPenyakit());
        holder.gejalaPenyakit.setText(fitur2.getGejalaPenyakit());
        holder.penyebabPenyakit.setText(fitur2.getPenyebabPenyakit());
        holder.caraPencegahanPenyakit.setText(fitur2.getCaraPencegahanPenyakit());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listFitur2.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFitur2.size();
    }

    public class Fitur2Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView namaPenyakit, gejalaPenyakit, penyebabPenyakit, caraPencegahanPenyakit;

        public Fitur2Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgPreview);
            namaPenyakit = itemView.findViewById(R.id.tvNamaPenyakit);
            gejalaPenyakit = itemView.findViewById(R.id.tvGejalaPenyakit);
            penyebabPenyakit = itemView.findViewById(R.id.tvPenyebabPenyakit);
            caraPencegahanPenyakit = itemView.findViewById(R.id.tvCaraPencegahanPenyakit);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Fitur2 data);
    }
}
