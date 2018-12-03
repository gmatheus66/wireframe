package com.example.alunoifpe.wireframe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class JogarDificil extends AppCompatActivity implements View.OnClickListener {

    private ImageButton oldCardButton;
    public Estado estado;
    public int resources[] = new int[]{
            R.mipmap.calunga,
            R.mipmap.capela_bjesus,
            R.mipmap.capela_rosario,
            R.mipmap.comes_damiao,
            R.mipmap.coroa_aviao,
            R.mipmap.refugio,
            R.mipmap.sitio_marcos,
            R.mipmap.velho_faceta
    };
    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificil_jogar);

        estado = Estado.NAO_VIRADA;
        TableLayout table = findViewById(R.id.tableLayout);
        table.removeAllViews();

        final int NUMBER_OF_CARDS = this.resources.length * 2;

        ArrayList<ImageButton> cards;
        cards = new ArrayList<>(NUMBER_OF_CARDS);

        for(int i = 0; i < 4; i++) {
            TableRow row = new TableRow(JogarDificil.this);
            for(int j = 0; j < 4; j++) {
                ImageButton image = new ImageButton(JogarDificil.this);
                image.setImageResource(R.mipmap.ic_costas);
                image.setAdjustViewBounds(true);
                image.setOnClickListener(this);
                image.setTag(new CardInfo(resources[i + j]));
                //image.setGravity(Gravity.CENTER);
                row.addView(image);
            }

            table.addView(row);
        }

        table.setStretchAllColumns(true);
        table.setGravity(Gravity.CENTER);

        Collections.shuffle(cards);

        for(ImageButton image : cards){
            table.addView(image);
        }
    }


    @Override
    public void onClick(View v) {
        if (v instanceof ImageButton) {
            Context context = getApplicationContext();
            final ImageButton newCardButton = (ImageButton) v;
            final CardInfo newCardInfo = (CardInfo) newCardButton.getTag();

            if (estado == Estado.NAO_VIRADA) {
                final ObjectAnimator oa1 = ObjectAnimator.ofFloat(newCardButton, "scaleX", 1f, 0f);
                final ObjectAnimator oa2 = ObjectAnimator.ofFloat(newCardButton, "scaleX", 0f, 1f);
                oa1.setInterpolator(new DecelerateInterpolator());
                oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        newCardButton.setImageResource(newCardInfo.getResource());
                        oa2.start();
                    }
                });
                oa1.start();
                newCardButton.setEnabled(false);
                oldCardButton = newCardButton;


                estado = Estado.VIRADA;

            } else if (estado == Estado.VIRADA) {
                final ObjectAnimator oa1 = ObjectAnimator.ofFloat(newCardButton, "scaleX", 1f, 0f);
                final ObjectAnimator oa2 = ObjectAnimator.ofFloat(newCardButton, "scaleX", 0f, 1f);
                oa1.setInterpolator(new DecelerateInterpolator());
                oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        newCardButton.setImageResource(newCardInfo.getResource());
                        oa2.start();
                    }
                });
                oa1.start();
                if (oldCardButton != newCardButton) {
                    if (((CardInfo) oldCardButton.getTag()).getResource() == newCardInfo.getResource()) {
                        newCardButton.setImageResource(newCardInfo.getResource());
                        newCardButton.setEnabled(false);
                        CharSequence  text = "Você Acertou!!";
                        int duration  = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    } else {
                        oldCardButton.setImageResource(R.mipmap.ic_costas);
                        oldCardButton.setEnabled(true);

                        newCardButton.setImageResource(newCardInfo.getResource());

                        newCardButton.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                newCardButton.setImageResource(R.mipmap.ic_costas);
                            }
                        }, 1000);
                    }
                }
                estado = Estado.NAO_VIRADA;
                oldCardButton = null;

                CharSequence  text = "Você Errou!!";
                int duration  = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
            }
        }
    }
}
