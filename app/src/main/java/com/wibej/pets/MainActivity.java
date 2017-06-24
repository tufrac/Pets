package com.wibej.pets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PetsData petsInfo = new PetsData();

    ArrayList<Pet> petsList;
    private RecyclerView allPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allPets = (RecyclerView) findViewById(R.id.rvPets);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        GridLayoutManager glm = new GridLayoutManager(this, 2);

        allPets.setLayoutManager(llm);
        petsList = petsInfo.getPetsList();
        initAdapter();

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

    }

    public void initAdapter(){
        PetAdapter adaptador = new PetAdapter(petsList, this);
        allPets.setAdapter(adaptador);
    }

    public void goBestFivePets(View v){
        Intent intent = new Intent(this, BestFivePets.class);
        startActivity(intent);
    }
}
