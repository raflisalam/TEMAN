package com.raflisalam.appteman.fitur2;

import com.raflisalam.appteman.R;

import java.util.ArrayList;

public class DataPenyakitPadi {

    private static String[] namaPenyakit = {
            "Penyakit Blas",
            "Penyakit Hispa",
            "Bercak Daun Coklat"
    };

    private static String[] gejalaPenyakit = {
            "Perkembangan penyakit blas bentuk khas dari bercak blas adalah elips dengan ujungnya agak runcing seperti belah ketupat. Bercak yang telah berkembang, bagian tepi berwarna coklat dan bagian tengah berwarna putih keabu-abuan. Bentuk dan warna bercak bervariasi tergantung pada keadaan sekitarnya, kerentanan varietas, dan umur bercak.",
            "Kumbang dewasa makan di bagian luar epidermis atas, menyebabkan pola garis-garis putih dan paralel di sepanjang sumbu utama daun. Dalam kasus serangan yang parah, bahkan pembuluh daun dapat terpengaruh, menyebabkan munculnya bercak putih besar.",
            "Gejala yang paling umum dari penyakit ini adalah adanya bercak berwarna coklat tua, berbentuk oval sampai bulat, berukuran sebesar biji wijen, pada permukaan daun, pada pelepah atau pada gabah"
    };

    private static String[] penyebabPenyakit = {
            "Penyakit blas yang disebabkan Pyricularia grisea merupakan penyakit penting pada tanaman padi di Indonesia terutama pada padi gogo di lahan kering.",
            "Kerusakan disebabkan oleh serangga dewasa dan larva hispa padi, Dicladispa armigera. Serangga dewasa mengikis permukaan atas helai daun dan hanya menyisakan epidermis bawah.",
            "Penyakit bercak daun coklat (brown leaf spot) pada tanaman padi (oryza sativa l) ini disebabkan oleh cendawan Helminthosporium oryzae atau Drechslera oryzae (Cochliobolus miyabeanus). Konidia ini dapat di sebarkan oleh angin dan dapat terbawa benih."
    };

    private static String[] caraPencegahanPenyakit = {
            "Cara pengendalian penyakit blas dapat dilakukan dengan berbagai cara di antaranya dengan teknik budi daya, penanaman varietas tahan, dan penggunaan fungisida. Penggunaan varietas tahan merupakan cara yang paling efektif, ekonomis, dan mudah dilakukan. Namun, penggunaan teknologi ini berhadapan dengan patogen penyakit blas yang memiliki keragaman genetik dan kemampuan beradaptasi yang tinggi sehingga dengan cepat membentuk ras baru yang dapat mematahkan ketahanan varietas yang baru diperkenalkan",
            "a) Gunakan jarak tanam yang lebih rapat dengan kerapatan daun yang lebih besar yang dapat mentoleransi jumlah hispa yang lebih banyak\nb) Tanam tanaman di awal musim untuk menghindari populasi puncak\nc) Potong ujung pucuk untuk mencegah serangga bertelur\nd) Kumpulkan serangga dewasa dengan jaring penyapu, terutama di pagi hari ketika mereka kurang banyak bergerak\ne) Singkirkan segala jenis gulma dari sawah selama musim tanpa penanaman\nf) Daun dan pucuk yang terserang harus dipotong dan dibakar, atau dikubur dalam di bawah lumpur\ng) Hindari pemupukan nitrogen yang berlebihan di ladang yang terserang\nh) Lakukan rotasi tanaman untuk memutus siklus hidup hama ini",
            "a) Jarak tanam yang tidak terlalu rapat terutama saat musim hujan\nb) Jika perlu gunakan cara tanam sistem legowo\nc) Jangan gunakan urea yang berlebih dan imbangi dengan unsur K\nd) Aplikasi fungisida pada daun tanaman padi, contoh: antracol, dithane, dan fungisida kontak lain sebagai pencegahnya. Jika sudah terserang gunakan fungisida sistemik seperti score, anvil, folicur, Nativo, opus, indar dll\ne) Penanaman varietas tahan, seperti Ciherang dan Membrano\nf) Pemupukan berimbang yang lengkap, yaitu 250 kg urea, 100 kg SP36, dan 100 kg KCl per ha\ng) g)\tPenyemprotan fungisida dengan bahan aktif difenoconazol, azoxistrobin, belerang, difenokonazol, tebukonazol, karbendazim, metil tiofanat, atau klorotalonil"
    };

    private static int[] imagePenyakitPadi = {
            R.drawable.penyakitblas,
            R.drawable.penyakithispa,
            R.drawable.bercakdauncoklat
    };

    public static ArrayList<Fitur2> getListData() {
        ArrayList<Fitur2> list = new ArrayList<>();
        for (int position = 0; position < namaPenyakit.length; position++) {
            Fitur2 fitur2 = new Fitur2();
            fitur2.setNamaPenyakit(namaPenyakit[position]);
            fitur2.setGejalaPenyakit(gejalaPenyakit[position]);
            fitur2.setPenyebabPenyakit(penyebabPenyakit[position]);
            fitur2.setCaraPencegahanPenyakit(caraPencegahanPenyakit[position]);
            fitur2.setImage(imagePenyakitPadi[position]);
            list.add(fitur2);
        }
        return  list;
    }
}
