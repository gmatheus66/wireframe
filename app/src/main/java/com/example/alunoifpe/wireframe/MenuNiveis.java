package com.example.alunoifpe.wireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONException;

import java.util.Random;

public class MenuNiveis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.niveis_menu);

        Readjson rd = new Readjson();

        try {
            rd.lerjson(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ImageView img = findViewById(R.id.imageMenu);
        Random r = new Random();
        img.setImageResource(getResources().getIdentifier(rd.getListLocais(r.nextInt(8)).getResource(),"mipmap", getPackageName() ));
    }

    Intent intent = getIntent();

    public void nivelFacil(View view){
        //String nivel = "facil";
        Intent intent = new Intent(this, Carregando.class);
        intent.putExtra("nivel", "facil");
        startActivity(intent);
    }

    public void nivelMedio(View view){
        //String nivel = "medio";
        Intent intent = new Intent(this, Carregando.class);
        intent.putExtra("nivel", "medio");
        startActivity(intent);
    }

    public void nivelDificil(View view){
        //String nivel = "dificil";
        Intent intent = new Intent(this, Carregando.class);
        intent.putExtra("nivel", "dificil");
        startActivity(intent);
    }

    public void sair (View view) {
        this.finish();
    }
}
