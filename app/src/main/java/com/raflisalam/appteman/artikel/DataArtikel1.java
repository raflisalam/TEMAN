package com.raflisalam.appteman.artikel;

import com.raflisalam.appteman.R;

import java.util.ArrayList;

public class DataArtikel1 {
    private static String[] namaSumber = {
        "Kompas - 13 September 2020",
        "Kompas - 28 Februari 2020",
        "detikNews - 5 Februari 2021",
        "Liputan6 - 2 Juli 2021"
    };

    private static String[] judulBerita = {
        "Mengapa Tanaman Padi Penting bagi Masyarakat Indonesia?",
        "Cuaca Buruk, Hama Wereng Serang Puluhan Sektar Tanaman Padi di Jember",
        "1.074 Hektare Lahan Tanaman Padi di Klaten Terendam Banjir",
        "Semester I 2021, BUMN Pertani Salurkan Benih untuk 786 Ribu Hektare Sawah"

    };

    private static int[] imageArtikel = {
            R.drawable.artikel1_1,
            R.drawable.artikel1_2,
            R.drawable.artikel1_3,
            R.drawable.artikel1_4
    };

    public static ArrayList<Artikel1> getListData() {
        ArrayList<Artikel1> list = new ArrayList<>();
        for (int position = 0; position < namaSumber.length; position++) {
            Artikel1 artikel1 = new Artikel1();
            artikel1.setSumber(namaSumber[position]);
            artikel1.setJudulBerita(judulBerita[position]);
            artikel1.setImage(imageArtikel[position]);
            list.add(artikel1);
        }
        return list;
    }
}
