package com.example.alunoifpe.wireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuNiveis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.niveis_menu);
    }

    Intent intent = getIntent();

    public void nivelFacil(View view){
        Intent intent = new Intent(this, Carregando.class);
        startActivity(intent);
    }

    public void nivelMedio(View view){
        Intent intent = new Intent(this, Carregando.class);
        startActivity(intent);
    }

    public void nivelDificil(View view){
        Intent intent = new Intent(this, Carregando.class);
        startActivity(intent);
    }

    public void sair (View view) {
        this.finish();
    }
}
