package com.example.abude.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abude.R;

import java.util.ArrayList;

public class BarangPembelianAdapter extends RecyclerView.Adapter<BarangPembelianAdapter.BarangPembelianViewHolder> {

    private final ArrayList<String> listBarang;

    public BarangPembelianAdapter(ArrayList<String> listBarang) {
        this.listBarang = listBarang;
    }

    @NonNull
    @Override
    public BarangPembelianAdapter.BarangPembelianViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent,false);
        return new BarangPembelianViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangPembelianAdapter.BarangPembelianViewHolder holder, int position) {
        holder.tvBarang.setText(listBarang.get(position));
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    public class BarangPembelianViewHolder extends RecyclerView.ViewHolder {
        TextView tvBarang;


        public BarangPembelianViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBarang = itemView.findViewById(R.id.tv_item);
        }
    }
}
