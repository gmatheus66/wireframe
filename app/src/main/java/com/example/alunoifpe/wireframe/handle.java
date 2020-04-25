package com.example.alunoifpe.wireframe;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class handle {

    public static  String stringFromStream(InputStream is){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null)
                sb.append(line).append("\n");

            reader.close();
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static String stringFromAsset(Context context, String assetFileName){
        AssetManager am = context.getAssets();

        try {
            InputStream is = am.open(assetFileName);
            String result = handle.stringFromStream(is);
            is.close();
            return  result;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
