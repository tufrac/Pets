package com.wibej.pets.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wibej.pets.BestFivePets;
import com.wibej.pets.R;
import com.wibej.pets.adapter.PetAdapter;
import com.wibej.pets.pojo.Pet;
import com.wibej.pets.pojo.PetsData;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetsFragment extends Fragment {

    private RecyclerView allPets;
    private PetsData petsInfo = new PetsData();
    ArrayList<Pet> petsList;

    public PetsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pets, container, false);

        allPets = (RecyclerView) v.findViewById(R.id.rvPets);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        GridLayoutManager glm = new GridLayoutManager(this, 2);

        allPets.setLayoutManager(llm);
        petsList = petsInfo.getPetsList();
        initAdapter();

        // Inflate the layout for this fragment
        return v;
    }

    public void initAdapter(){
        PetAdapter adaptador = new PetAdapter(petsList, getActivity());
        allPets.setAdapter(adaptador);
    }

}
