package com.mytrendin.gsonlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by csa on 06-Apr-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> {

    List<Model> recyclerdata;

    public RecyclerAdapter(List<Model> recyclerdata) {
        this.recyclerdata = recyclerdata;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle,parent,false);
        Myholder myholder=new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        Model model = recyclerdata.get(position);
        holder.color.setText(model.getColorName());
        holder.hex.setText(model.getHexValue());


    }

    @Override
    public int getItemCount() {
        return recyclerdata.size();
    }

    class Myholder extends RecyclerView.ViewHolder{

        TextView color,hex;


        public Myholder(View itemView) {
            super(itemView);
            color = (TextView) itemView.findViewById(R.id.color);
            hex = (TextView) itemView.findViewById(R.id.hex);

        }


    }
}
