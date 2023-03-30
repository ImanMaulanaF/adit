package com.example.abude.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abude.R;

import java.util.ArrayList;

public class NamaProdukBerandaAdapter extends RecyclerView.Adapter<NamaProdukBerandaAdapter.NamaProdukBerandaViewHolder> {
    private final ArrayList<String>listNamaProduk;

    public NamaProdukBerandaAdapter(ArrayList listNamaProduk) {
        this.listNamaProduk = listNamaProduk;
    }

    @NonNull
    @Override
    public NamaProdukBerandaAdapter.NamaProdukBerandaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        return new NamaProdukBerandaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NamaProdukBerandaAdapter.NamaProdukBerandaViewHolder holder, int position) {
        holder.tvBarang.setText(listNamaProduk.get(position));
    }

    @Override
    public int getItemCount() {
        return listNamaProduk.size();
    }

    public class NamaProdukBerandaViewHolder extends RecyclerView.ViewHolder {
        TextView tvBarang;
        public NamaProdukBerandaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBarang = itemView.findViewById(R.id.barang);
        }
    }
}
