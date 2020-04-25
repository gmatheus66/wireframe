package com.example.alunoifpe.wireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONException;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Readjson rd = new Readjson();

        try {
            rd.lerjson(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ImageView img = findViewById(R.id.image);
        Random r = new Random();
        img.setImageResource(getResources().getIdentifier(rd.getListLocais(r.nextInt(8)).getResource(),"mipmap", getPackageName() ));
    }

    public void jogar(View view){
        Intent intent = new Intent(this, MenuNiveis.class);
        startActivity(intent);
    }
    public void sobre(View v){
        Intent intent = new Intent(this,Sobre.class);
        startActivity(intent);
    }



    public void sair (View view) {
        this.finish();
    }
}
