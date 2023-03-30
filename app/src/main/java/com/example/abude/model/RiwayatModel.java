package com.example.abude.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

// STEP 2

public class RiwayatModel implements Parcelable {
    // Lanjutin sendiri

    // STEP 3
    private String jenisKonsumen;
    private String namaProduk;
    private String cabang;
    private String total;
    private String waktu;

    public String getCabang() {
        return cabang;
    }

    public void setCabang(String cabang) {
        this.cabang = cabang;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getJenisKonsumen() {
        return jenisKonsumen;
    }

    public void setJenisKonsumen(String jenisKonsumen) {
        this.jenisKonsumen = jenisKonsumen;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.jenisKonsumen);
    }

    public RiwayatModel() {

    }

    protected RiwayatModel(Parcel in) {
        jenisKonsumen = in.readString();
    }

    public static final Creator<RiwayatModel> CREATOR = new Creator<RiwayatModel>() {
        @Override
        public RiwayatModel createFromParcel(Parcel in) {
            return new RiwayatModel(in);
        }

        @Override
        public RiwayatModel[] newArray(int size) {
            return new RiwayatModel[size];
        }
    };
}
