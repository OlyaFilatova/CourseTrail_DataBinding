package com.miymayster.coursetrail_databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

import java.util.ArrayList;

/**
 * Created by Olga on 05.08.2017.
 */

public class GardenInfo extends BaseObservable {
    private final String name;
    private final String location;
    private final String size;
    private final String type;
    private boolean seen;
    //public final ObservableBoolean seen;

    public static final int SEEN_PROPERTY_ID = 1;


    public GardenInfo(String name, String location, String size, String type, boolean seen){
        this.name = name;
        this.location = location;
        this.size = size;
        this.type = type;
        this.seen = seen;
        //this.seen = new ObservableBoolean(seen);
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public String getSize(){
        return size;
    }
    public String getType(){
        return type;
    }
    @Bindable
    public boolean getSeen(){
        return seen;
    }
    public void setSeen(boolean seen){
        this.seen = seen;
        notifyPropertyChanged(BR.seen);
    }

}
