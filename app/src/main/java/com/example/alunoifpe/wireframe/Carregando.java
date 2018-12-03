package com.example.alunoifpe.wireframe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Carregando extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carregando);
        Handler handler = new Handler();
        Intent intent = getIntent();
        final String nivel = intent.getStringExtra("nivel");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                comecarJogo(nivel);
            }
        }, 2000);
    }

    private void comecarJogo(String nivel) {
        if (nivel.equals("facil")) {
            Intent intent = new Intent(this, JogarFacil.class);
            startActivity(intent);
            finish();
        } else if (nivel.equals("medio")) {
            Intent intent = new Intent(this, JogarMedio.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, JogarDificil.class);
            startActivity(intent);
            finish();
        }
    }
}
