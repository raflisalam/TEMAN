package com.raflisalam.appteman.fragment;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.raflisalam.appteman.Fitur1Activity;
import com.raflisalam.appteman.R;
import com.raflisalam.appteman.artikel.AdapterArtikel1;
import com.raflisalam.appteman.artikel.Artikel1;
import com.raflisalam.appteman.artikel.DataArtikel1;
import com.raflisalam.appteman.fitur2.Fitur2Activity;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView rvArtikel1;
    private TextView tv1;
    private ArrayList<Artikel1> listArtikel1 = new ArrayList<>();

    Button btnFitur1, btnFitur2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvArtikel1 = view.findViewById(R.id.rvBerita);
        rvArtikel1.setHasFixedSize(true);

        btnFitur1 = view.findViewById(R.id.btnFitur1);
        btnFitur2 = view.findViewById(R.id.btnFitur2);

        listArtikel1.addAll(DataArtikel1.getListData());
        recyclerArtikel1();

        tv1 = view.findViewById(R.id.tv1);
        Bundle extras = getActivity().getIntent().getExtras();
        String username;

        if (extras != null) {
            username = extras.getString("username");
            tv1.setText(username);
        }

        btnFitur1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Fitur1Activity.class);
                startActivity(intent);
            }
        });

        btnFitur2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Fitur2Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void recyclerArtikel1() {
        rvArtikel1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        AdapterArtikel1 adapterArtikel1 = new AdapterArtikel1(listArtikel1);
        rvArtikel1.setAdapter(adapterArtikel1);
    }
}