package com.raflisalam.appteman.fitur2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.raflisalam.appteman.R;

public class DetailPenyakitActivity extends AppCompatActivity {

    private ImageView detailImagePenyakit;
    private TextView detailNamaPenyakit, detailPencegahanPenyakit, detailPenyebabPenyakit, detailGejalaPenyakit;
    private Button btnBack;

    public static final String DETAIL_EXTRA = "detail_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penyakit);

        detailImagePenyakit = findViewById(R.id.detailImagePenyakit);
        detailNamaPenyakit = findViewById(R.id.detailNamaPenyakit);
        detailPenyebabPenyakit = findViewById(R.id.detailPenyebabPenyakit);
        detailPencegahanPenyakit = findViewById(R.id.detailPencegahanPenyakit);
        detailGejalaPenyakit = findViewById(R.id.detailGejalaPenyakit);

        Fitur2 fitur2 = getIntent().getParcelableExtra(DETAIL_EXTRA);
        if (fitur2 !=null) {
            Glide.with(this)
                    .load(fitur2.getImage())
                    .into(detailImagePenyakit);
            detailNamaPenyakit.setText(fitur2.getNamaPenyakit());
            detailPenyebabPenyakit.setText(fitur2.getPenyebabPenyakit());
            detailGejalaPenyakit.setText(fitur2.getGejalaPenyakit());
            detailPencegahanPenyakit.setText(fitur2.getCaraPencegahanPenyakit());
        }
    }
}