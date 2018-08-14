package com.example.oilha.restaurantes;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class StableArrayAdapter extends ArrayAdapter<Restaurants> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public StableArrayAdapter(Context context, int textViewResourceId,
                              ArrayList<Restaurants> objects) {
        super(context, textViewResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put("a", i);
        }
    }

    @Override
    public long getItemId(int position) {
        Restaurants item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}