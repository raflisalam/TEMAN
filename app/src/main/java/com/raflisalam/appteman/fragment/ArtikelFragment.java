package com.raflisalam.appteman.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raflisalam.appteman.R;
import com.raflisalam.appteman.artikel.AdapterArtikel1;
import com.raflisalam.appteman.artikel.AdapterArtikel2;
import com.raflisalam.appteman.artikel.Artikel1;
import com.raflisalam.appteman.artikel.Artikel2;
import com.raflisalam.appteman.artikel.DataArtikel1;
import com.raflisalam.appteman.artikel.DataArtikel2;

import java.util.ArrayList;

public class ArtikelFragment extends Fragment {

    private RecyclerView rvArtikel1, rvArtikel2;
    private ArrayList<Artikel1> listArtikel1 = new ArrayList<>();
    private ArrayList<Artikel2> listArtikel2 = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artikel, container, false);

        rvArtikel1 = view.findViewById(R.id.rvArtikel1);
        rvArtikel2 = view.findViewById(R.id.rvArtikel2);

        rvArtikel1.setHasFixedSize(true);
        rvArtikel2.setHasFixedSize(true);

        listArtikel1.addAll(DataArtikel1.getListData());
        listArtikel2.addAll(DataArtikel2.getListData());

        recyclerArtikel1();
        recyclerArtikel2();




        return view;
    }

    private void recyclerArtikel2() {
        rvArtikel2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        AdapterArtikel2 adapterArtikel2 = new AdapterArtikel2(listArtikel2);
        rvArtikel2.setAdapter(adapterArtikel2);
    }

    private void recyclerArtikel1() {
        rvArtikel1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        AdapterArtikel1 adapterArtikel1 = new AdapterArtikel1(listArtikel1);
        rvArtikel1.setAdapter(adapterArtikel1);
    }
}