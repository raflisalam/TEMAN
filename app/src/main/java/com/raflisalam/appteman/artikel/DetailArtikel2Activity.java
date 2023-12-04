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
import com.raflisalam.appteman.fragment.ArtikelFragment;
import com.raflisalam.appteman.fragment.HomeFragment;
import com.raflisalam.appteman.ui.HomeActivity;

public class DetailArtikel2Activity extends AppCompatActivity {

    private ImageView imageArtikel2;
    private TextView judulBerita, sumberBerita, detailBerita, taglineBerita;
    private ImageButton btnBack;

    public static final String DETAIL_ARTIKEL2 = "detail_artikel2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel2);

        imageArtikel2 = findViewById(R.id.detailImageArtikel2);
        judulBerita = findViewById(R.id.tvJudulBeritaArtikel2);
        sumberBerita = findViewById(R.id.tvSumberArtikel2);
        taglineBerita = findViewById(R.id.tvTaglineArtikel2);
        detailBerita = findViewById(R.id.tvDetailBeritaArtikel2);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailArtikel2Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        Artikel2 artikel2 = getIntent().getParcelableExtra(DETAIL_ARTIKEL2);
        if (artikel2 !=null) {
            Glide.with(this).load(artikel2.getImage()).into(imageArtikel2);
            judulBerita.setText(artikel2.getJudulBerita());
            sumberBerita.setText(artikel2.getSumber());
            detailBerita.setText(artikel2.getDetailBerita());
            taglineBerita.setText(artikel2.getTagline());
        }
    }
}