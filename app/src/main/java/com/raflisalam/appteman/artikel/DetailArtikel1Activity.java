package com.raflisalam.appteman.artikel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.raflisalam.appteman.R;
import com.raflisalam.appteman.fitur2.DetailPenyakitActivity;
import com.raflisalam.appteman.fitur2.Fitur2Activity;
import com.raflisalam.appteman.fragment.HomeFragment;
import com.raflisalam.appteman.ui.HomeActivity;

public class DetailArtikel1Activity extends AppCompatActivity {

    private ImageView imageArtikel1;
    private TextView judulBerita, sumberBerita, detailBerita;
    private ImageButton btnBack;

    public static final String DETAIL_ARTIKEL1 = "detail_artikel1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel1);

        imageArtikel1 = findViewById(R.id.detailImageArtikel1);
        judulBerita = findViewById(R.id.tvJudulBeritaArtikel1);
        sumberBerita = findViewById(R.id.tvSumberArtikel1);
        detailBerita = findViewById(R.id.tvDetailBeritaArtikel1);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailArtikel1Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        Artikel1 artikel1 = getIntent().getParcelableExtra(DETAIL_ARTIKEL1);
        if (artikel1 !=null) {
            Glide.with(this).load(artikel1.getImage()).into(imageArtikel1);
            detailBerita.setText(artikel1.getDetailBerita());
            judulBerita.setText(artikel1.getJudulBerita());
            sumberBerita.setText(artikel1.getSumber());
        }
    }
}