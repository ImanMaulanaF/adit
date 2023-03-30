package com.example.abude.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abude.R;

import java.util.ArrayList;

public class Adapter_RecyclerView_Beranda extends RecyclerView.Adapter<Adapter_RecyclerView_Beranda.ViewHolder> {

    private ArrayList<String> Jenis;
    public Adapter_RecyclerView_Beranda(ArrayList<String> languageRVModalArrayList) {
        this.Jenis = Jenis;
    }

    @NonNull
    @Override
    public Adapter_RecyclerView_Beranda.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.riwayat_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvJenisKonsumen.setText(Jenis.get(position));
    }

    @Override
    public int getItemCount() {
//        Jenis = new ArrayList<>();
//        Jenis.add("Aye");
//        Jenis.add("Dana");
        return Jenis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJenisKonsumen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJenisKonsumen = itemView.findViewById(R.id.txt_jenis_konsumen);
        }
    }
}
