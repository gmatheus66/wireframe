package com.example.alunoifpe.wireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jogar(View view){
        Intent intent = new Intent(this, Carregando.class);
        startActivity(intent);
    }

    public  void loginFacebook (View view){
        Intent intent = new Intent(this, LoginFacebook.class);
        startActivity(intent);
    }

    public void sair (View view) {
        this.finish();
    }
}
