package com.wibej.pets;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.wibej.pets.view.fragment.PetPerfilFragment;
import com.wibej.pets.view.fragment.PetsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar tbPets;
    private TabLayout tlPets;
    private ViewPager vpPets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        tbPets = (Toolbar) findViewById(R.id.tbPets);
        tlPets = (TabLayout) findViewById(R.id.tlPets);
        vpPets = (ViewPager) findViewById(R.id.vpPets);

        setUpViewPager();

        if (tlPets != null){
            setSupportActionBar(tbPets);
        }


    }

    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new PetsFragment());
        fragments.add(new PetPerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        vpPets.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tlPets.setupWithViewPager(vpPets);
        tlPets.getTabAt(0).setIcon(R.drawable.home_icon);
        tlPets.getTabAt(1).setIcon(R.drawable.dog_face_icon);
    }



//    Menu Settings

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFivePets:
                Intent intentBestFive = new Intent(this, BestFivePets.class);
                startActivity(intentBestFive);
                break;
            case R.id.mContact:
                Intent intentContact = new Intent(this, Contact.class);
                startActivity(intentContact);
                break;
            case R.id.mAbout:
                Intent intentAbout = new Intent(this, AboutMe.class);
                startActivity(intentAbout);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
