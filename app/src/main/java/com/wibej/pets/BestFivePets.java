package com.wibej.pets;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.wibej.pets.adapter.PetAdapter;
import com.wibej.pets.pojo.Pet;
import com.wibej.pets.pojo.PetsData;
import com.wibej.pets.view.fragment.BestFivePetsFragment;

import java.util.ArrayList;

public class BestFivePets extends AppCompatActivity {
    private PetsData petsInfo = new PetsData();
    private Toolbar tbBestFivePets;
    private ViewPager vpBestFivePets;
    private TabLayout tlBestFivePets;
//    private ImageView imgRank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_five_pets);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);



        tbBestFivePets = (Toolbar) findViewById(R.id.tbBestFivePets);
        tlBestFivePets = (TabLayout) findViewById(R.id.tlBestFivePets);
        vpBestFivePets = (ViewPager) findViewById(R.id.vpBestFivePets);

        setUpViewPager();
        //Hide Rank
//        imgRank     = (ImageView) miActionBar.findViewById(R.id.tbImgRank);
//        imgRank.setVisibility(View.INVISIBLE);

        if (tlBestFivePets != null){
            setSupportActionBar(tbBestFivePets);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new BestFivePetsFragment());

        return fragments;
    }

    private void setUpViewPager(){
        vpBestFivePets.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tlBestFivePets.setupWithViewPager(vpBestFivePets);
        tlBestFivePets.getTabAt(0).setContentDescription("The best Pets");
        tlBestFivePets.getTabAt(0).setIcon(R.drawable.start_menu);
    }

}
