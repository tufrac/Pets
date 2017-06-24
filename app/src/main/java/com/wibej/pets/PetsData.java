package com.wibej.pets;

import java.util.ArrayList;

/**
 * Created by tufrac on 6/23/17.
 */

public class PetsData {
    private ArrayList<Pet> petsList;

    public PetsData() {

    }

    public ArrayList<Pet> getPetsList() {
        initPetsList();
        return petsList;
    }

    public ArrayList<Pet> getFivePetList(){
        petsList = new ArrayList<Pet>();

        petsList.add(new Pet("Pet1", 3, R.drawable.akitapuppy));
        petsList.add(new Pet("Pet4", 9, R.drawable.conejo));
        petsList.add(new Pet("Pet5", 7, R.drawable.cow));
        petsList.add(new Pet("Pet7", 6, R.drawable.hippo));
        petsList.add(new Pet("Pet10", 9, R.drawable.rat));

        return petsList;
    }


    public PetsData(ArrayList<Pet> petsList) {
        this.petsList = petsList;
    }

    public void initPetsList(){
        petsList = new ArrayList<Pet>();

        petsList.add(new Pet("Pet1", 3, R.drawable.akitapuppy));
        petsList.add(new Pet("Pet2", 0, R.drawable.cat));
        petsList.add(new Pet("Pet3", 0, R.drawable.cocker_spaniel));
        petsList.add(new Pet("Pet4", 9, R.drawable.conejo));
        petsList.add(new Pet("Pet5", 7, R.drawable.cow));
        petsList.add(new Pet("Pet6", 0, R.drawable.dog));
        petsList.add(new Pet("Pet7", 6, R.drawable.hippo));
        petsList.add(new Pet("Pet8", 0, R.drawable.lion));
        petsList.add(new Pet("Pet9", 0, R.drawable.rabbit));
        petsList.add(new Pet("Pet10", 9, R.drawable.rat));
        petsList.add(new Pet("Pet11", 0, R.drawable.sheep));
        petsList.add(new Pet("Pet12", 0, R.drawable.turtle));
        petsList.add(new Pet("Pet13", 0, R.drawable.tux1));
        petsList.add(new Pet("Pet14", 0, R.drawable.tuxlinux));
    }

}
