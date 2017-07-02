package com.wibej.pets.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wibej.pets.R;
import com.wibej.pets.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by tufrac on 7/1/17.
 */

public class ProfilePetAdapter extends RecyclerView.Adapter<ProfilePetAdapter.PetViewHolder>{

    ArrayList<Pet> petsList;
    Activity activity;

    public ProfilePetAdapter(ArrayList<Pet> petsList, Activity activity) {
        this.petsList = petsList;
        this.activity = activity;
    }

    @Override
    public ProfilePetAdapter.PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_profile_pet, parent, false);

        return new ProfilePetAdapter.PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProfilePetAdapter.PetViewHolder petViewHolder, int position) {
        final Pet pet = petsList.get(position);
        petViewHolder.imgPet.setImageResource(pet.getPhoto());
        petViewHolder.tvRank.setText(pet.getRankingString());
    }

    @Override
    public int getItemCount() {
        return petsList.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPet;
        private TextView tvRank;

        public PetViewHolder(View itemView) {
            super(itemView);
            imgPet      = (ImageView) itemView.findViewById(R.id.imgPet);
            tvRank      = (TextView) itemView.findViewById(R.id.tvRank);
        }


    }

}
