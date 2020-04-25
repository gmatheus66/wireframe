package com.example.alunoifpe.wireframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        TextView tx = findViewById(R.id.text);

        tx.setText("Projeto de Extensão do Instituto Federal de Pernambuco - Campus Igarassu");
        tx.append(System.getProperty("line.separator"));
        tx.append(System.getProperty("line.separator"));
        tx.append("Desenvolvedores:");
        tx.append(System.getProperty("line.separator"));
        tx.append("Matheus Gonçalves Silva");
        tx.append(System.getProperty("line.separator"));
        tx.append("Guilherme da Silva Lira ");
        tx.append(System.getProperty("line.separator"));
        tx.append("Gabriel Lima Gonçalves da Silva");
        tx.append(System.getProperty("line.separator"));
        tx.append("José Gabriel Vicente das Neves da Silva");
        tx.append(System.getProperty("line.separator"));
        tx.append(System.getProperty("line.separator"));
        tx.append("Presidente do Instituto do Patrimonio Historico e Artistico Nacional (IFHAN)");
        tx.append(System.getProperty("line.separator"));
        tx.append("Kátia Santos Bogéa");
        tx.append(System.getProperty("line.separator"));
        tx.append(System.getProperty("line.separator"));
        tx.append("Superitendente do Iphan em Pernambuco");
        tx.append(System.getProperty("line.separator"));
        tx.append("Arq.a  Renata Duarte Borba");
        tx.append(System.getProperty("line.separator"));
        tx.append(System.getProperty("line.separator"));
        tx.append("Chefe do Escritorio Técnico do Iphan em Igarassu (PE)");
        tx.append(System.getProperty("line.separator"));
        tx.append("Arq. o Fábio Henrique Torres Barreiro");
        tx.append(System.getProperty("line.separator"));
        tx.append(System.getProperty("line.separator"));
        tx.append("Equipe de Apoio do Escritório Técnico e Casa do Patrimônio do Iphan de Igarassu(PE)");
        tx.append(System.getProperty("line.separator"));
        tx.append("Lex Ane Silva Cavalcanti");
        tx.append(System.getProperty("line.separator"));
        tx.append("Luana Cristina Rodrigues Jacinto");
        tx.append(System.getProperty("line.separator"));
        tx.append("Ana Beatriz Melo");
        tx.append(System.getProperty("line.separator"));
        tx.append("Marileide Dias");
        tx.append(System.getProperty("line.separator"));
        tx.append("Genésio Dácio da Silva");
        tx.append(System.getProperty("line.separator"));
        tx.append("João Batista da Silva");
        tx.append(System.getProperty("line.separator"));
        tx.append("Dinis Torres");

    }
}
