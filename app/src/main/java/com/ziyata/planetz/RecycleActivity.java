package com.ziyata.planetz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    // TODO 1 mengenerate butterknife untuk recycleview
    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    //TODO 2 membuat variabel array untuk menampung data nama, detail dan gambar dari String Array pada values
    String[] namaPlanet, isiPlanet;
    int[] gambarClub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        //TODO 3 Mengisi variabel array
        namaPlanet = getResources().getStringArray(R.array.nama_planet);
        isiPlanet = getResources().getStringArray(R.array.isi_planet);
        gambarClub = new int[]{R.drawable.merkurius, R.drawable.venus, R.drawable.bumi, R.drawable.mars, R.drawable.jupiter, R.drawable.saturnus,R.drawable.uranus,R.drawable.neptunus};

        //TODO 4 membuat Object adapter dan mengirim data nama,detail, dan gambar ke adapter
        Adapter adapter = new Adapter(RecycleActivity.this,gambarClub, namaPlanet, isiPlanet);
        // TODO 5 mensetting recyclerview dan mengeset recycleview dengan adapter
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecyclerView.setAdapter(adapter);
    }
}
