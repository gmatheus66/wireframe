package com.example.alunoifpe.wireframe;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyviewHolder> {

    private String[] mdata;

    @Override
    public Adapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_game, parent,false);
        MyviewHolder vh = new MyviewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {

        holder.textView.setText(mdata[position]);

    }

    @Override
    public int getItemCount() {
        return mdata.length;
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public MyviewHolder(TextView v){
            super(v);
            textView = v;
        }
    }


    public Adapter(String[] myData){
        mdata = myData;
    }

}
