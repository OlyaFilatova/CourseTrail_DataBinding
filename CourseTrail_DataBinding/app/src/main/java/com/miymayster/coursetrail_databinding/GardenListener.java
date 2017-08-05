package com.miymayster.coursetrail_databinding;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Olga on 05.08.2017.
 */

public class GardenListener {
    public void methodReferenceOnClick(View view){
        Toast.makeText(view.getContext(), "Method reference", Toast.LENGTH_SHORT).show();
        Log.i(GardenListener.class.getSimpleName(), "Method reference");
    }
    public void listenerBindingOnclick(View view, GardenInfo gardenInfo){
        Toast.makeText(view.getContext(), "Listener binding", Toast.LENGTH_SHORT).show();
        Log.i(GardenListener.class.getSimpleName(), "Listener binding, " + gardenInfo.getName());
    }
    public void seenChanged(GardenInfo gardenInfo, boolean isChecked){
        gardenInfo.setSeen(isChecked);
        Log.i(GardenListener.class.getSimpleName(), "Seen " + gardenInfo.getName() + " - " + isChecked);
    }
}
