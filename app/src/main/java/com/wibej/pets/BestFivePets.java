package com.wibej.pets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.wibej.pets.adapter.PetAdapter;
import com.wibej.pets.pojo.Pet;
import com.wibej.pets.pojo.PetsData;

import java.util.ArrayList;

public class BestFivePets extends AppCompatActivity {
    private PetsData petsInfo = new PetsData();
    private ImageView imgRank;
    ArrayList<Pet> petsList;
    private RecyclerView allPets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_five_pets);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        //Hide Rank
//        imgRank     = (ImageView) miActionBar.findViewById(R.id.tbImgRank);
//        imgRank.setVisibility(View.INVISIBLE);

//        Recycler View Top Five
        allPets = (RecyclerView) findViewById(R.id.rvPets);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        allPets.setLayoutManager(llm);
        petsList = petsInfo.getFivePetList();
        initAdapter();

    }

    public void initAdapter(){
        PetAdapter adaptador = new PetAdapter(petsList, this);
        allPets.setAdapter(adaptador);
    }

}
