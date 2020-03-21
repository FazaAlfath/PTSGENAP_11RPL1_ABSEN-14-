package com.example.login;

public class model {
    private String id;
    private String nama;
    private String kode;
    private String jenis;

    public model(String id, String nama, String kode, String jenis) {
        this.id = id;
        this.nama= nama;
        this.kode = kode;
        this.jenis= jenis;
    }

    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }

    public String getKode() {
        return kode;
    }

    public String getJenis() {
        return jenis;
    }

}
