package com.miymayster.coursetrail_databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.miymayster.coursetrail_databinding.databinding.ActivityBindInLayoutBinding;

import java.util.ArrayList;

public class BindInLayoutActivity extends AppCompatActivity {

    ActivityBindInLayoutBinding mBinding;
    ArrayList<GardenInfo> gardens;
    GardenInfo garden;
    int chosenGarden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.action_bind_in_layout);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind_in_layout);
        gardens = new ArrayList<>();

        gardens.add(new GardenInfo("The Garden of Cosmic Speculation",
                "2 Lower Portrack Cottages, Holywood, Dumfries DG2 0RW, UK",
                "30 acre (12 hectare)",
                "sculpture garden", false));

        gardens.add(new GardenInfo("Keukenhof Gardens",
                "2160 AB, Stationsweg 166, 2161 AM Lisse, Netherlands",
                "32 hectares (79 acres)",
                "floral displays", true));

        gardens.add(new GardenInfo("Nong Nooch Tropical Botanical Garden",
                "Na Jomtien 6 Tambon Na Chom Thian, Amphoe Sattahip, Chang Wat Chon Buri 20250, Thailand",
                "500-acre",
                "botanical garden", false));
        chosenGarden = 0;

        mBinding.setGarden(gardens.get(chosenGarden));
        mBinding.setGardenListener(new GardenListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bind_in_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_next){
            chosenGarden ++;
            if(chosenGarden > gardens.size() - 1){
                chosenGarden = 0;
            }
            mBinding.setGarden(gardens.get(chosenGarden));
            return true;
        }else if(id == R.id.action_previous){
            chosenGarden --;
            if (chosenGarden < 0) {
                chosenGarden = gardens.size() - 1;
            }
            mBinding.setGarden(gardens.get(chosenGarden));
            return true;
        }else if(id == R.id.action_open_bind_in_java){
            Intent intent = new Intent(this, BindInJavaActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
