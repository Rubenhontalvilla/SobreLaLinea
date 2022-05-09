package com.example.sobrelalinea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRVMensajes extends RecyclerView.Adapter<AdapterRVMensajes.MensajeHolder> {

    private List<Mensaje> lstMensajes;

    public AdapterRVMensajes(List<Mensaje> lstMensajes) {
        this.lstMensajes = lstMensajes;
    }

    @NonNull
    @Override
    public MensajeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_mensaje, viewGroup, false);
        return new MensajeHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeHolder mensajeHolder, int i) {

        mensajeHolder.tvNombre.setText(lstMensajes.get(i).getName());
        mensajeHolder.tvMensaje.setText(lstMensajes.get(i).getMessage());
    }

    @Override
    public int getItemCount() {
        return lstMensajes.size();
    }

    class MensajeHolder extends RecyclerView.ViewHolder{


        private TextView tvNombre;
        private TextView tvMensaje;

        public MensajeHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tv_nombre);
            tvMensaje = itemView.findViewById(R.id.tv_mensaje);
        }
    }
}
