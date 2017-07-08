package com.wibej.pets.presenter;

import android.content.Context;

import com.wibej.pets.db.ConstructorPets;
import com.wibej.pets.pojo.Pet;
import com.wibej.pets.view.fragment.IPetsFragmentView;

import java.util.ArrayList;

/**
 * Created by tufrac on 7/6/17.
 */

public class PetsFragmentViewPresenter implements IPetsFragmentViewPresenter {

    private IPetsFragmentView iPetsFragmentView;
    private Context context;
    private ConstructorPets constructorPets;
    private ArrayList<Pet> allPets;

    public PetsFragmentViewPresenter(IPetsFragmentView iPetsFragmentView, Context context){
        this.iPetsFragmentView = iPetsFragmentView;
        this.context = context;
        getPets();
    }

    @Override
    public void getPets() {
        constructorPets = new ConstructorPets(context);
        allPets = constructorPets.getData();
        showPetsRV();
    }

    @Override
    public void showPetsRV() {
        iPetsFragmentView.initAdapterRV(iPetsFragmentView.createAdapter(allPets));
        iPetsFragmentView.generateVerticalLinearLayout();
    }
}
