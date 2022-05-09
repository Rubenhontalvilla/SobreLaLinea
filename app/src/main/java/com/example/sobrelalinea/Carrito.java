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


    TextView tvCantProductos;
    Button btnVerCarro;
    RecyclerView rvListaProductos;
    AdaptadorProductos adaptador;

    List<Producto> listaProductos = new ArrayList<>();
    List<Producto> carroCompras = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        getSupportActionBar().hide();

        tvCantProductos = findViewById(R.id.tvCantProductos);
        btnVerCarro = findViewById(R.id.btnVerCarrito);
        rvListaProductos = findViewById(R.id.rvListaProductos);
        rvListaProductos.setLayoutManager(new GridLayoutManager(Carrito.this, 1));

        listaProductos.add(new Producto("1", "Producto 1", "Descripcion del Producto 1", 50.0));
        listaProductos.add(new Producto("2", "Producto 2", "Descripcion del Producto 2", 80.0));
        listaProductos.add(new Producto("3", "Producto 3", "Descripcion del Producto 3", 40.0));
        listaProductos.add(new Producto("4", "Producto 4", "Descripcion del Producto 4", 20.0));
        listaProductos.add(new Producto("5", "Producto 5", "Descripcion del Producto 5", 56.0));

        adaptador = new AdaptadorProductos(Carrito.this, tvCantProductos, btnVerCarro, listaProductos, carroCompras);
        rvListaProductos.setAdapter(adaptador);

    }
}