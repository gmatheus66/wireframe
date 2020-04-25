package com.example.alunoifpe.wireframe;


import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class TestFragment extends DialogFragment {

    private static final String TAG = "mydialog";
    private final ArrayList<Locais> lc = new ArrayList<>();
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


    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final int n_cards = getArguments().getInt("n_cards");
        final int nivel = getArguments().getInt("nivel");
        final ArrayList<ImageButton> cards = new ArrayList<>(n_cards);
        final int seed = getArguments().getInt("seed");

        final TextView title = view.findViewById(R.id.title1);
        final TextView description = view.findViewById(R.id.description);
        final ImageView photo = view.findViewById(R.id.photo1);


        //title.setText("hayyyyyyyyyy");
        Readjson rdjson = new Readjson();


        Collections.shuffle(cards, new Random(seed));
        try {
            rdjson.lerjson(view.getContext());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //rdjson.show();
        for(Locais i :rdjson.ListLocais()){
            //System.out.println( i.getName().trim() == getArguments().getString("resource").trim());
            if (i.getName().equals(getArguments().getString("resource"))){
                //System.out.println("Entrou");
                title.setText(i.getName());
                title.setTextSize(15);
                description.setText(i.getDescription());
                //photo.setBackgroundResource(getResources().getIdentifier(i.getResource(),"mipmap", view.getContext().getPackageName() ) );
                photo.setImageResource(getResources().getIdentifier(i.getResource(),"mipmap", view.getContext().getPackageName() ));
                photo.setMinimumHeight(200);
                photo.setMinimumWidth(200);
                photo.setMaxHeight(600);
                photo.setMaxWidth(600);
            }


        }
        //System.out.println(getArguments().getInt("nivel"));
        //System.out.println(getArguments().getInt("nivel") * 2 );
        System.out.println("========================");
        //System.out.println(getArguments().getInt("resource"));
        //System.out.println(rdjson.getListLocais(getArguments().getInt("resource") ).getName() );

        //System.out.println("" + getArguments().getString("resource"));
        if (getArguments() != null) {

            Button btnDone = view.findViewById(R.id.btnDone);
            btnDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //DialogListener dialogListener = (DialogListener) getActivity();
                    //dialogListener.onFinishEditDialog(editText.getText().toString());
                    dismiss();
                }
            });
        }
    }

}
