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
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                comecarJogo();
            }
        }, 2000);
    }

    Intent intent = getIntent();

    private void comecarJogo(){
        Intent intent = new Intent(this, Jogar.class);
        startActivity(intent);
        finish();
    }
}
