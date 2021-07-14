package com.moringaschool.samaritan2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.g_samaritan.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class stateProvinceAdapter  extends RecyclerView.Adapter<stateProvinceAdapter.stateProvinceViewHolder> {
//
    private List<GsamaritanResponse> mSamaritan;
//    private Context mContext;

    public stateProvinceAdapter(Context context, List<GsamaritanResponse> msamaritan){
//        mContext = context;
        mSamaritan = msamaritan;
    }


    @Override
    public stateProvinceViewHolder onCreateViewHolder(  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent .getContext()).inflate(R.layout.state_province,parent,false);
        stateProvinceViewHolder ViewHolder = new stateProvinceViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder( stateProvinceAdapter.stateProvinceViewHolder holder, int position) {
        holder.bindstateProvinceAdapter(mSamaritan.get(position));

    }

    @Override
    public int getItemCount() {
        return mSamaritan.size();
    }

    public  class stateProvinceViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.lostImageView) ImageView lostImageView;
        @BindView(R.id.nameTextView) TextView mnameTextView;
        @BindView(R.id.countryTextView)TextView mCountyTextView;
        @BindView(R.id.setAlphaTwoCode) TextView msetAlphaTwoCode;

        private Context mContext;

        public stateProvinceViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }

        public void  bindstateProvinceAdapter(GsamaritanResponse stateProvince){
            mnameTextView.setText(stateProvince.getName());
            mCountyTextView.setText(stateProvince.getCountry());
            msetAlphaTwoCode.setText(stateProvince.getAlphaTwoCode());
        }


    }

}

