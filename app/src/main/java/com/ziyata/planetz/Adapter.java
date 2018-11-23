package com.ziyata.planetz;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    //TODO 1 membuat variabel
    Context context;
    int[] gambarClub;
    String[] namaPlanet,isiPlanet;

    public Adapter(Context context, int[] gambarClub, String[] namaPlanet, String[] isiPlanet) {
        this.context = context;
        this.gambarClub = gambarClub;
        this.namaPlanet = namaPlanet;
        this.isiPlanet = isiPlanet;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_planet,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaPlanet[i]);
        Glide.with(context).load(gambarClub[i]).into(viewHolder.imgLogo);


        //TODO Membuat onClicklistener
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent pindah = new Intent(context,DetailPlanetActivity.class);
                pindah.putExtra("np", namaPlanet[i]);
                pindah.putExtra("ip", isiPlanet[i]);
                pindah.putExtra("gc", gambarClub[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarClub.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);
        }
    }
}


