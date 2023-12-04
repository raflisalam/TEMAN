package com.raflisalam.appteman.fitur2;

import android.os.Parcel;
import android.os.Parcelable;

public class Fitur2 implements Parcelable {
    int image;
    private String namaPenyakit;
    private String gejalaPenyakit;
    private String penyebabPenyakit;
    private String caraPencegahanPenyakit;

    public Fitur2(){

    }

    protected Fitur2(Parcel in) {
        namaPenyakit = in.readString();
        gejalaPenyakit = in.readString();
        penyebabPenyakit = in.readString();
        caraPencegahanPenyakit = in.readString();
        image = in.readInt();
    }

    public static final Creator<Fitur2> CREATOR = new Creator<Fitur2>() {
        @Override
        public Fitur2 createFromParcel(Parcel in) {
            return new Fitur2(in);
        }

        @Override
        public Fitur2[] newArray(int size) {
            return new Fitur2[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public String getGejalaPenyakit() {
        return gejalaPenyakit;
    }

    public void setGejalaPenyakit(String gejalaPenyakit) {
        this.gejalaPenyakit = gejalaPenyakit;
    }

    public String getPenyebabPenyakit() {
        return penyebabPenyakit;
    }

    public void setPenyebabPenyakit(String penyebabPenyakit) {
        this.penyebabPenyakit = penyebabPenyakit;
    }

    public String getCaraPencegahanPenyakit() {
        return caraPencegahanPenyakit;
    }

    public void setCaraPencegahanPenyakit(String caraPencegahanPenyakit) {
        this.caraPencegahanPenyakit = caraPencegahanPenyakit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
