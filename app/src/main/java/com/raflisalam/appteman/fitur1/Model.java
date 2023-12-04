package com.raflisalam.appteman.fitur1;

public class Model {

    private String namaPenyakit;
    private String deskripsi;
    private String gejalaPenyakit;
    private String caraPencegahan;

    public Model() {

    }

    public Model(String namaPenyakit, String deskripsi, String gejalaPenyakit, String caraPencegahan) {
        this.namaPenyakit = namaPenyakit;
        this.deskripsi = deskripsi;
        this.gejalaPenyakit = gejalaPenyakit;
        this.caraPencegahan = caraPencegahan;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGejalaPenyakit() {
        return gejalaPenyakit;
    }

    public void setGejalaPenyakit(String gejalaPenyakit) {
        this.gejalaPenyakit = gejalaPenyakit;
    }

    public String getCaraPencegahan() {
        return caraPencegahan;
    }

    public void setCaraPencegahan(String caraPencegahan) {
        this.caraPencegahan = caraPencegahan;
    }
}
