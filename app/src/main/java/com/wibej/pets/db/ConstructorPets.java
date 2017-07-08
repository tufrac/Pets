package com.wibej.pets.db;

import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract;

import com.wibej.pets.R;
import com.wibej.pets.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by tufrac on 7/6/17.
 */

public class ConstructorPets {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorPets(Context context) {
        this.context = context;
    }

    public ArrayList<Pet> getData(){
        DataBase db = new DataBase(context);
        insertPets(db);
        return db.getAllPets();
    }

    public ArrayList<Pet> getBestFivePets(){
        DataBase db = new DataBase(context);
        return db.getFivePets();
    }
    public void insertPets(DataBase db){
        ContentValues cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 1");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.akitapuppy);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 2");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.cat);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 3");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.cocker_spaniel);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 4");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.conejo);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 5");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.cow);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 6");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.dog);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 7");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.hippo);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 8");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.lion);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 9");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.rabbit);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 10");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.rat);

        db.insertPet(cv);


        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 11");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.sheep);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 12");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.turtle);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 13");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.tux1);

        db.insertPet(cv);

        cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_PET_NAME, "Pet 14");
        cv.put(ConstantsDataBase.TABLE_PET_PHOTO, R.drawable.tuxlinux);

        db.insertPet(cv);
    }

    public void setPetLike(Pet pet){
        DataBase db = new DataBase(context);
        ContentValues cv = new ContentValues();
        cv.put(ConstantsDataBase.TABLE_LIKE_PET_ID_PET, pet.getId());
        cv.put(ConstantsDataBase.TABLE_LIKE_PET_RANK, LIKE);
        db.insertLikePet(cv);
    }

    public String getPetLike(Pet pet){
        DataBase db = new DataBase(context);

        return db.getPetLike(pet);
    }
}
