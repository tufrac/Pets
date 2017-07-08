package com.wibej.pets.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wibej.pets.R;
import com.wibej.pets.adapter.BestFivePetsAdapter;
import com.wibej.pets.adapter.PetAdapter;
import com.wibej.pets.pojo.Pet;
import com.wibej.pets.presenter.BestFivePetsFragmentViewPresenter;
import com.wibej.pets.presenter.IPetsFragmentViewPresenter;
import com.wibej.pets.presenter.PetsFragmentViewPresenter;

import java.util.ArrayList;

import static android.view.View.INVISIBLE;


/**
 * A simple {@link Fragment} subclass.
 */
public class BestFivePetsFragment extends Fragment implements IPetsFragmentView{

    private RecyclerView allPets;
//    private ImageView petLike;
    private IPetsFragmentViewPresenter presenter;

    public BestFivePetsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_best_five_pets, container, false);

        allPets = (RecyclerView) v.findViewById(R.id.rvPets);
        presenter = new BestFivePetsFragmentViewPresenter(this, getContext());
//        petLike = (ImageView) v.findViewById(R.id.petLike);
//        petLike.setVisibility(View.GONE);
//        petLike.setVisibility(View.GONE);
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
//        return null;
    }

    @Override
    public BestFivePetsAdapter createBestFivePetsAdapter(ArrayList<Pet> pets) {
        BestFivePetsAdapter adapterBestFivePets = new BestFivePetsAdapter(pets,getActivity());

        return adapterBestFivePets;
    }

    @Override
    public void initAdapterRV(PetAdapter adapter) {
        allPets.setAdapter(adapter);
    }

    @Override
    public void initAdapterBestFivePetsRV(BestFivePetsAdapter adapterBestFivePets) {
//        allPets.setAdapter(adapterBestFivePets);
    }
}
