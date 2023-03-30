package com.example.abude.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abude.R;
import com.example.abude.model.RiwayatModel;

import java.util.ArrayList;

// STEP 4

public class RiwayatPembelianAdapter extends RecyclerView.Adapter<RiwayatPembelianAdapter.RiwayatPembelianViewHolder> {

    // STEP 5 , Bikin ArrayList
    private ArrayList<RiwayatModel> riwayatModels;

    // STEP 6
    public RiwayatPembelianAdapter(ArrayList<RiwayatModel> list) {
        this.riwayatModels = list;
    }

    // STEP 7, deklarasikan .xml untuk view
    @NonNull
    @Override
    public RiwayatPembelianAdapter.RiwayatPembelianViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.riwayat_item, parent, false);
        return new RiwayatPembelianViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatPembelianAdapter.RiwayatPembelianViewHolder holder, int position) {

        // STEP 11
        RiwayatModel riwayatModel = riwayatModels.get(position);

        // STEP 12
        holder.tvJenisKonsumen.setText(riwayatModel.getJenisKonsumen());
        holder.tvNamaProduk.setText(riwayatModel.getNamaProduk());
        holder.tvCabang.setText(riwayatModel.getCabang());
        holder.tvTotal.setText(riwayatModel.getTotal());
        holder.tvWaktu.setText(riwayatModel.getWaktu());
    }


    // STEP 8
    @Override
    public int getItemCount() {
        return riwayatModels.size();
    }

    public class RiwayatPembelianViewHolder extends RecyclerView.ViewHolder {
        // STEP 9, sesuaikan dengan kebutuhan view nya
        TextView tvJenisKonsumen;
        TextView tvNamaProduk;
        TextView tvCabang;
        TextView tvTotal;
        TextView tvWaktu;

        public RiwayatPembelianViewHolder(@NonNull View itemView) {
            super(itemView);

            // STEP 10, deklarasikan
            tvJenisKonsumen = itemView.findViewById(R.id.txt_jenis_konsumen);
            tvNamaProduk = itemView.findViewById(R.id.txt_nama_produk);
            tvCabang = itemView.findViewById(R.id.txt_cabang);
            tvTotal = itemView.findViewById(R.id.txt_total);
            tvWaktu = itemView.findViewById(R.id.txt_waktu);
        }
    }
}
