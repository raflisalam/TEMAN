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

public class AdapterFiturHome extends RecyclerView.Adapter<AdapterFiturHome.Fitur2Home> {

    private ArrayList<Fitur2> listFitur2;
    private ClickDetailHome clickDetailHome;

    public void setClickDetailHome(ClickDetailHome clickDetailHome) {
        this.clickDetailHome = clickDetailHome;
    }

    public AdapterFiturHome(ArrayList<Fitur2> list) {
        this.listFitur2 = list;
    }

    @NonNull
    @Override
    public AdapterFiturHome.Fitur2Home onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_penyakitpadihome, parent, false);
        return new Fitur2Home(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFiturHome.Fitur2Home holder, int position) {
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
                clickDetailHome.clickDetailHome(listFitur2.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFitur2.size();
    }

    public class Fitur2Home extends RecyclerView.ViewHolder {
        ImageView img;
        TextView namaPenyakit, gejalaPenyakit, penyebabPenyakit, caraPencegahanPenyakit;

        public Fitur2Home(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imagePenyakit);
            namaPenyakit = itemView.findViewById(R.id.namaPenyakit);
            gejalaPenyakit = itemView.findViewById(R.id.tvGejalaPenyakit);
            penyebabPenyakit = itemView.findViewById(R.id.tvPenyebabPenyakit);
            caraPencegahanPenyakit = itemView.findViewById(R.id.tvCaraPencegahanPenyakit);
        }
    }

    public interface ClickDetailHome {
        void clickDetailHome(Fitur2 data);
    }
}
