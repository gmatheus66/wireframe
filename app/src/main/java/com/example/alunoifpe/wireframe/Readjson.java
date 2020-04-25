package com.example.alunoifpe.wireframe;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Readjson {

    List<Locais> ListLocais = new ArrayList<>();
    Context context;

    public Locais getListLocais(int i){ return ListLocais.get(i); }

    public void setListLocais(List<Locais> listLocais){ ListLocais = listLocais; }


    public List<Locais> ListLocais(){ return  ListLocais;}
    String result = "";


    public void lerjson(Context context) throws JSONException {

        String jsonstring = handle.stringFromAsset(context, "lugares_igarassu.json");

        JSONObject jsonObject = new JSONObject(jsonstring);

        JSONArray placesarray = jsonObject.getJSONArray("places");

        for (int i = 0; i < placesarray.length(); i++){
            ListLocais.add(new Locais(placesarray.getJSONObject(i).getString("name"), placesarray.getJSONObject(i).getString("resource"), placesarray.getJSONObject(i).getString("description") ) );
        }

    }

    public Readjson() {
    }

    public void show(){
        for (Locais e : ListLocais){
            System.out.println("Locais");
            System.out.println(e.getName());
            System.out.println(e.getDescription());
            System.out.println(e.getResource());
        }


    }



}
