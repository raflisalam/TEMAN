package com.raflisalam.appteman.fitur2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raflisalam.appteman.R;

import java.util.ArrayList;

public class Fitur2Activity extends AppCompatActivity {

    private RecyclerView rvFitur2;
    private ArrayList<Fitur2> listFitur2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitur2);

        rvFitur2 = findViewById(R.id.rvPenyakitPadi);
        rvFitur2.setHasFixedSize(true);

        listFitur2.addAll(DataPenyakitPadi.getListData());
        recyclerFitur2();
    }

    private void recyclerFitur2() {
        rvFitur2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        AdapterFitur2 adapterFitur2 = new AdapterFitur2(listFitur2);
        rvFitur2.setAdapter(adapterFitur2);

        adapterFitur2.setOnItemClickCallback(new AdapterFitur2.OnItemClickCallback() {
            @Override
            public void onItemClicked(Fitur2 data) {
                Intent intent = new Intent(Fitur2Activity.this, DetailPenyakitActivity.class);
                intent.putExtra(DetailPenyakitActivity.DETAIL_EXTRA, data);
                startActivity(intent);
            }
        });
    }
}
