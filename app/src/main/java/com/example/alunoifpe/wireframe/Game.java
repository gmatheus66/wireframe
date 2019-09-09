package com.example.alunoifpe.wireframe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends AppCompatActivity implements View.OnClickListener {


    private ImageButton oldCardButton;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public Estado estado;
    public int resource[] = new int[]{
        R.mipmap.calunga,
        R.mipmap.capela_bjesus,
        R.mipmap.capela_rosario,
        R.mipmap.comes_damiao,
        R.mipmap.coroa_aviao,
        R.mipmap.refugio,
        R.mipmap.sitio_marcos,
        R.mipmap.velho_faceta
    };
    private String nivel;
    private int linhas;
    private int colunas;

    private int color_Green = Color.parseColor("#42f448");
    private int color_Red = Color.parseColor("#f42c22");

    private ArrayList<ImageButton> matriz = new ArrayList<ImageButton>();
    private ArrayList<ImageButton> cards;

    DisplayMetrics metr =  new DisplayMetrics();

    Point size = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent =  getIntent();
        nivel = intent.getStringExtra("nivel");

        getWindowManager().getDefaultDisplay().getMetrics(metr);
        Display display = getWindowManager().getDefaultDisplay();

        int width = metr.widthPixels;
        int height = metr.heightPixels;

        System.out.println("width -> " + width);
        System.out.println("heigth -> " + height);

        //Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2
        System.out.println("Build -> " + Build.VERSION.SDK_INT);
        System.out.println("B -> " + Build.VERSION_CODES.JELLY_BEAN_MR1);

        estado = Estado.NAO_VIRADA;
        //TableLayout tabela = findViewById(R.id.tableLayout);
        //tabela.removeAllViews();

        final int NUMBER_CARDS = nivel() * 2;
        cards = new ArrayList<>(NUMBER_CARDS);


        for (int i = 0; i < NUMBER_CARDS; i++){
            ImageButton image = new ImageButton(Game.this);
            image.setImageResource(R.mipmap.ic_costas);
            image.setAdjustViewBounds(true);
            image.setOnClickListener(this);
            image.setTag(new CardInfo(resource[i % nivel()]));
            cards.add(image);
        }

        Collections.shuffle(cards);


        GridLayout grid = new GridLayout(this);
        grid.setAlignmentMode((Integer) 1 );

        for (int i = 0; i < linhas;i++ ){
            for (int z = 0 ; z < colunas; z++){
                GridLayout.Spec linha = GridLayout.spec(i);
                GridLayout.Spec coluna = GridLayout.spec(z);

                GridLayout.LayoutParams lp = new GridLayout.LayoutParams(linha,coluna);

                ImageView iv = new ImageView(this);

                iv.setImageResource(R.drawable.ic_launcher_background);

                grid.addView(iv,lp);
            }
        }

        setContentView(grid);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, colunas);


        recyclerView.setLayoutManager(layoutManager);

        String[] myData;
        //mAdapter = new Adapter();

        recyclerView.setAdapter(mAdapter);


        /*
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(LinearLayout.HORIZONTAL);
        linearlayout.setLayoutParams(new LinearLayout.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

        int cardIndex = 0;

        TableLayout table = new TableLayout(Game.this);
        table.setLayoutParams(new TableLayout.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,AbsListView.LayoutParams.WRAP_CONTENT));

        for (int i = 0; i < linhas; i++){
            TableRow row =  new TableRow(Game.this);
            row.setPadding(1,1,1,1);
            row.setWeightSum(5f);

            TableLayout.LayoutParams params =  new TableLayout.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT, 1f);

            for (int j = 0; j < colunas; j++){

                TableRow.LayoutParams  card = new TableRow.LayoutParams();
                row.addView(cards.get(cardIndex));



                if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR1 || width < 768){
                    row.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                }else{
                    row.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                }

                //row.setBackgroundColor(Color.parseColor("#bfbbae"));
                cardIndex++;

            }
            row.setLayoutParams(params);
            tabela.addView(row);

        }

        tabela.setStretchAllColumns(true);
        tabela.setGravity(Gravity.CENTER);
        */

        Collections.shuffle(cards);


        for (ImageButton i : cards){

            for (int z = 0 ; z < matriz.size(); z++){
                System.out.println(matriz.get(z) + "  " + z);
            }
            i.setBackgroundColor(Color.WHITE);
        }

    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, MenuNiveis.class) );
        //finishAffinity();
        return;

    }


    @Override
    public void onClick(View v) {




            /*
            ViewGroup group = (ViewGroup) this.getWindow().getDecorView();

            group.getChildCount();
            View vv = group.getChildAt(0);

            if (vv instanceof  View) {

            }
            */

            //System.out.println(cards.listIterator() );
            //System.out.println(cards.get(0).hasOnClickListeners()); //retorna true a cada clique

        if (v instanceof ImageButton) {
            Context context = getApplicationContext();
            final ImageButton newCardButton = (ImageButton) v;
            final CardInfo newCardInfo = (CardInfo) newCardButton.getTag();

                for (ImageButton i : cards){
                    i.setBackgroundColor(Color.WHITE);
                }


                if (estado == Estado.NAO_VIRADA) {

                    animation(newCardButton,newCardInfo);


                    oldCardButton = newCardButton;

                    oldCardButton.setEnabled(false);



                    estado = Estado.VIRADA;

                } else if (estado == Estado.VIRADA) {


                    animation(newCardButton,newCardInfo);

                    if (oldCardButton != newCardButton) {


                        if (((CardInfo) oldCardButton.getTag()).getResource() == newCardInfo.getResource()) {
                            newCardButton.setImageResource(newCardInfo.getResource());
                            newCardButton.setClickable(false);
                            oldCardButton.setClickable(false);
                            oldCardButton.setBackgroundColor(color_Green);
                            newCardButton.setBackgroundColor(color_Green);



                            CharSequence text = "Você Acertou!!";
                            int duration = Toast.LENGTH_SHORT;

                            /*oldCardButton.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    oldCardButton = null;

                                }
                            },3000);
                            */


                            //new Timer().schedule(new TimerTask() {
                                //@Override
                              //  public void run() {
                                //oldCardButton.setBackgroundColor(Color.WHITE);
                                //  newCardButton.setBackgroundColor(Color.WHITE);
                             //   }
                            //},2000);



                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            oldCardButton.setImageResource(R.mipmap.ic_costas);
                            oldCardButton.setEnabled(true);
                            newCardButton.setImageResource(newCardInfo.getResource());

                            newCardButton.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    newCardButton.setImageResource(R.mipmap.ic_costas);
                                    //newCardButton.setBackgroundColor(Color.WHITE);

                                }
                            }, 1000);




                            CharSequence text = "Você Errou!!";
                            int duration = Toast.LENGTH_SHORT;


                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        }
                    }
                    estado = Estado.NAO_VIRADA;
                    //oldCardButton = null;
                    oldCardButton.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            oldCardButton = null;

                        }
                    },500);



                }
            }
    }


    public void animation(final ImageButton newCardButton , final CardInfo newCardInfo){

        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(newCardButton, "scaleX", 1f, 0f).setDuration(200);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(newCardButton, "scaleX", 0f, 1f).setDuration(200);

        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        for (ImageButton i : cards){
            i.setEnabled(false);

            if (i == oldCardButton && oldCardButton != newCardButton){
                oldCardButton.setBackgroundColor(Color.RED);
                newCardButton.setBackgroundColor(Color.RED);
            }



        }
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {

                super.onAnimationEnd(animation);
                newCardButton.setImageResource(newCardInfo.getResource());
                oa2.start();

                for (ImageButton i : cards){
                    i.setEnabled(true);

                }

            }
        });
        oa1.start();

        oa1.addListener(new Animator.AnimatorListener(){

            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                newCardButton.setBackgroundColor(Color.WHITE);
                oldCardButton.setBackgroundColor(Color.WHITE);
                //Toast.makeText(Game.this,"animação terminou", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });



    }

    public int nivel(){
        if(nivel.equals("facil")){
            this.colunas = 2;
            this.linhas = 3;
            return 3;
        }
        else if(nivel.equals("medio")){
            this.colunas = 3;
            this.linhas = 4;
            return 6;
        }
        else {
            this.colunas = 4;
            this.linhas = 4;
            return 8;
        }
    }
}
