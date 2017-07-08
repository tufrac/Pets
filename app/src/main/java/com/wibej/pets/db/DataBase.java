package com.wibej.pets.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wibej.pets.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by tufrac on 7/7/17.
 */

public class DataBase extends SQLiteOpenHelper {
    private Context context;

    public DataBase(Context context) {
        super(context, ConstantsDataBase.DATABASE_NAME, null, ConstantsDataBase.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTablePet = "CREATE TABLE " + ConstantsDataBase.TABLE_PET + "(" + "" +
                ConstantsDataBase.TABLE_PET_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantsDataBase.TABLE_PET_NAME       + " TEXT, " +
                ConstantsDataBase.TABLE_PET_PHOTO      + " INTEGER" +
                ")";

        String queryCreateTableLikePet = "CREATE TABLE " + ConstantsDataBase.TABLE_LIKE_PET + "(" + "" +
                ConstantsDataBase.TABLE_LIKE_PET_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantsDataBase.TABLE_LIKE_PET_ID_PET       + " INTEGER, " +
                ConstantsDataBase.TABLE_LIKE_PET_RANK      + " INTEGER, " +
                "FOREIGN KEY (" + ConstantsDataBase.TABLE_LIKE_PET_ID_PET + ") " +
                "REFERENCES " + ConstantsDataBase.TABLE_PET + "(" + ConstantsDataBase.TABLE_PET_ID + ")" +
                ")";


        db.execSQL(queryCreateTablePet);
        db.execSQL(queryCreateTableLikePet);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantsDataBase.TABLE_PET);
        db.execSQL("DROP TABLE IF EXIST " + ConstantsDataBase.TABLE_LIKE_PET);

        onCreate(db);

    }

    public ArrayList<Pet> getAllPets(){
        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantsDataBase.TABLE_PET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery(query, null);
        while (data.moveToNext()){
            Pet currentPet = new Pet();
            currentPet.setId(data.getInt(0));
            currentPet.setName(data.getString(1));
            currentPet.setPhoto(data.getInt(2));
//            currentPet.
            String queryLikes = "SELECT COUNT("+ConstantsDataBase.TABLE_LIKE_PET_RANK+") as likes " +
                                " FROM " + ConstantsDataBase.TABLE_LIKE_PET +
                                " WHERE " + ConstantsDataBase.TABLE_LIKE_PET_ID_PET + "=" + currentPet.getId();

            Cursor registerLike = db.rawQuery(queryLikes, null);
            if(registerLike.moveToNext()){
                currentPet.setRanking(registerLike.getInt(0));
            }else{
                currentPet.setRanking(0);
            }
            pets.add(currentPet);
        }
        db.close();

        return pets;
    }

    public ArrayList<Pet> getFivePets(){
        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantsDataBase.TABLE_PET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery(query, null);
        while (data.moveToNext()){
            Pet currentPet = new Pet();
            currentPet.setId(data.getInt(0));
            currentPet.setName(data.getString(1));
            currentPet.setPhoto(data.getInt(2));
//            currentPet.
            String queryLikes = "SELECT COUNT("+ConstantsDataBase.TABLE_LIKE_PET_RANK+") as likes " +
                    " FROM " + ConstantsDataBase.TABLE_LIKE_PET +
                    " WHERE " + ConstantsDataBase.TABLE_LIKE_PET_ID_PET + "=" + currentPet.getId();

            Cursor registerLike = db.rawQuery(queryLikes, null);
            if(registerLike.moveToNext()){
                currentPet.setRanking(registerLike.getInt(0));
            }else{
                currentPet.setRanking(0);
            }
            if(currentPet.getRanking() > 0){
                pets.add(currentPet);
            }

        }
        db.close();

        return pets;
    }

    public void insertPet(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantsDataBase.TABLE_PET, null, contentValues);
        db.close();
    }

    public void insertLikePet(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantsDataBase.TABLE_LIKE_PET, null, contentValues);
        db.close();
    }

    public String getPetLike(Pet pet){
        int likes = 0;

        String query = "SELECT COUNT("+ ConstantsDataBase.TABLE_LIKE_PET_RANK +")" +
                        " FROM " + ConstantsDataBase.TABLE_LIKE_PET +
                        " WHERE " + ConstantsDataBase.TABLE_LIKE_PET_ID_PET + "=" + pet.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery(query, null);
        if(data.moveToNext()){
            likes = data.getInt(0);
        }
        db.close();

        return String.valueOf(likes);
    }
}
