package com.raflisalam.appteman.slider;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.raflisalam.appteman.R;
import com.raflisalam.appteman.ui.LoginActivity;
import com.raflisalam.appteman.ui.RegisterActivity;

public class slide3 extends Fragment {

    Button btnBergabung;

    public slide3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slide3, container, false);

        btnBergabung = view.findViewById(R.id.btnBergabung);

        btnBergabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}