package com.example.sobrelalinea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Carrito extends AppCompatActivity {



    List<Producto> carritoCompra;

    AdaptadorCarrito adaptador;

    RecyclerView rvListaCarrito;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        getSupportActionBar().hide();

        carritoCompra = (List<Producto>) getIntent().getSerializableExtra("CarritoCompras");

        rvListaCarrito = findViewById(R.id.rvListaCarrito);
        rvListaCarrito.setLayoutManager(new GridLayoutManager(Carrito.this, 1));
        tvTotal = findViewById(R.id.tvTotal);

        adaptador = new AdaptadorCarrito(Carrito.this, carritoCompra, tvTotal);
        rvListaCarrito.setAdapter(adaptador);


    }
}