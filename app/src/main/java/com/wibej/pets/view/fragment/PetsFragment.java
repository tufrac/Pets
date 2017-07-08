package com.wibej.pets.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wibej.pets.R;
import com.wibej.pets.adapter.BestFivePetsAdapter;
import com.wibej.pets.adapter.PetAdapter;
import com.wibej.pets.pojo.Pet;
import com.wibej.pets.pojo.PetsData;
import com.wibej.pets.presenter.IPetsFragmentViewPresenter;
import com.wibej.pets.presenter.PetsFragmentViewPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetsFragment extends Fragment implements IPetsFragmentView {

    private RecyclerView allPets;
//    ArrayList<Pet> petsList;
    private IPetsFragmentViewPresenter presenter;
    public PetsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pets, container, false);

        allPets = (RecyclerView) v.findViewById(R.id.rvPets);
        presenter = new PetsFragmentViewPresenter(this, getContext());



        // Inflate the layout for this fragment
        return v;
    }


    @Override
    public void generateVerticalLinearLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        GridLayoutManager glm = new GridLayoutManager(this, 2);

        allPets.setLayoutManager(llm);
    }

    @Override
    public void generateGridLayout() {

    }

    @Override
    public PetAdapter createAdapter(ArrayList<Pet> pets) {
        PetAdapter adapter = new PetAdapter(pets, getActivity());

        return adapter;
    }

    @Override
    public BestFivePetsAdapter createBestFivePetsAdapter(ArrayList<Pet> pets) {
        return null;
    }

    @Override
    public void initAdapterRV(PetAdapter adapter) {
        allPets.setAdapter(adapter);
    }

    @Override
    public void initAdapterBestFivePetsRV(BestFivePetsAdapter adapter) {

    }
}
