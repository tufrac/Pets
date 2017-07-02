package com.wibej.pets.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wibej.pets.pojo.Pet;
import com.wibej.pets.R;

import java.util.ArrayList;

/**
 * Created by tufrac on 6/22/17.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{

    ArrayList<Pet> petsList;
    Activity activity;

    public PetAdapter(ArrayList<Pet> petsList, Activity activity){
        this.petsList = petsList;
        this.activity = activity;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_pet, parent, false);

        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PetViewHolder petViewHolder, int position) {
        final Pet pet = petsList.get(position);
        petViewHolder.imgPet.setImageResource(pet.getPhoto());
        petViewHolder.tvPetName.setText(pet.getName());
        petViewHolder.tvRank.setText(pet.getRankingString());

        petViewHolder.petLike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a " +  pet.getName(), Toast.LENGTH_SHORT).show();
            }
        });
//        petViewHolder
    }

    @Override
    public int getItemCount() {
        return petsList.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{
        private ImageView petLike;
        private ImageView imgPet;
        private TextView tvPetName;
        private TextView tvRank;

        public PetViewHolder(View itemView) {
            super(itemView);
            petLike     = (ImageView) itemView.findViewById(R.id.petLike);
            imgPet      = (ImageView) itemView.findViewById(R.id.imgPet);
            tvPetName   = (TextView) itemView.findViewById(R.id.tvPetName);
            tvRank      = (TextView) itemView.findViewById(R.id.tvRank);
        }


    }

}
