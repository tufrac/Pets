package com.wibej.pets.view.fragment;

import com.wibej.pets.adapter.BestFivePetsAdapter;
import com.wibej.pets.adapter.PetAdapter;
import com.wibej.pets.adapter.ProfilePetAdapter;
import com.wibej.pets.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by tufrac on 7/6/17.
 */

public interface IPetsFragmentView {

    public void generateVerticalLinearLayout();

    public void generateGridLayout();

    public PetAdapter createAdapter(ArrayList<Pet> pets);

    public BestFivePetsAdapter createBestFivePetsAdapter(ArrayList<Pet> pets);

    public void initAdapterRV(PetAdapter adapter);

    public void initAdapterBestFivePetsRV(BestFivePetsAdapter adapterBestFivePets);

}
