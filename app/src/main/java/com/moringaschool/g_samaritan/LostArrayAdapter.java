package com.moringaschool.g_samaritan;

import android.content.Context;
import android.widget.ArrayAdapter;

public class LostArrayAdapter extends ArrayAdapter {
    private String[] mCuisines;
    private Context mContext;
    private String[] mLost;

    public  LostArrayAdapter(Context mContext, int resource, String[] mLost, String[] mCuisines){
        super(mContext, resource);
        this.mContext = mContext;
        this.mLost = mLost;
        this.mCuisines =mCuisines;

    }

    @Override
    public Object getItem(int position){
        String lost = mLost[position];
        String cuisine =mCuisines[position];
        return String.format("%S \nServes great: %S",lost,cuisine);
    }
    @Override
    public int getCount(){
        return mLost.length;
    }

}
