package com.example.alunoifpe.wireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Acertou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acertou);
        Button btn = findViewById(R.id.btn);
        TextView tx = findViewById(R.id.parabens);
        tx.setTextSize(30);


    }

    public void onBackPressed(){
        startActivity(new Intent(this, MainActivity.class) );
        //finishAffinity();
        return;
    }

    public void again(View view){
        startActivity(new Intent(view.getContext(), MainActivity.class));
        return;
    }
}
