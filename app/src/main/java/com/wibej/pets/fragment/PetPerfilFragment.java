package com.wibej.pets.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wibej.pets.BestFivePets;
import com.wibej.pets.R;
import com.wibej.pets.adapter.PetAdapter;
import com.wibej.pets.adapter.ProfilePetAdapter;
import com.wibej.pets.pojo.Pet;
import com.wibej.pets.pojo.PetsData;

import java.util.ArrayList;


public class PetPerfilFragment extends Fragment {

    private RecyclerView petProfile;
    private PetsData petsInfo = new PetsData();
    ArrayList<Pet> petsList;

    public PetPerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pet_perfil, container, false);

        petProfile = (RecyclerView) v.findViewById(R.id.rvPetProfile);



//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        petProfile.setLayoutManager(glm);
        petsList = petsInfo.getProfilePetsList();
        initAdapter();

        return v;
    }

    public void initAdapter(){
        ProfilePetAdapter adaptador = new ProfilePetAdapter(petsList, getActivity());
        petProfile.setAdapter(adaptador);
    }

}
