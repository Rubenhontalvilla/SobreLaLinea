package com.example.sobrelalinea;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class chat extends AppCompatActivity {


    private TextView tv_nombre;
    private RecyclerView rv_chat;
    private EditText et_mensaje;
    private ImageButton btn_enviar;

    private List<Mensaje> lstMensajes;
    private AdapterRVMensajes mAdapterRVMensajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        tv_nombre = (TextView) findViewById(R.id.tvNombre);
        rv_chat = (RecyclerView) findViewById(R.id.rv_chat);
        et_mensaje = (EditText) findViewById(R.id.et_mensaje);
        btn_enviar = (ImageButton) findViewById(R.id.btn_enviar);

        lstMensajes = new ArrayList<>();
        mAdapterRVMensajes = new AdapterRVMensajes(lstMensajes);
        rv_chat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv_chat.setAdapter(mAdapterRVMensajes);
        rv_chat.setHasFixedSize(true);


        FirebaseFirestore.getInstance().collection("Chat")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException error) {
                        for (DocumentChange mDocumentChange : queryDocumentSnapshots.getDocumentChanges()) {
                            if (mDocumentChange.getType() == DocumentChange.Type.ADDED) {
                                lstMensajes.add(mDocumentChange.getDocument().toObject(Mensaje.class));
                                mAdapterRVMensajes.notifyDataSetChanged();
                                rv_chat.smoothScrollToPosition(lstMensajes.size());
                            }
                        }
                    }
                });

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}