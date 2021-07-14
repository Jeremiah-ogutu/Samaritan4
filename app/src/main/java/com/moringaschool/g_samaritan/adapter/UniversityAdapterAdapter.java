package com.moringaschool.g_samaritan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.g_samaritan.R;
import com.moringaschool.g_samaritan.models.Universities;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class UniversityAdapterAdapter extends RecyclerView.Adapter<UniversityAdapterAdapter.PostViewHolder> {
//
    private List<Universities> universitiesList;
//    private Context mContext;

    public UniversityAdapterAdapter(Context context, List<Universities> universitiesList){
//        mContext = context;
        universitiesList = universitiesList;
    }


    @Override
    public PostViewHolder onCreateViewHolder(  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent .getContext()).inflate(R.layout.state_province,parent,false);
        PostViewHolder ViewHolder = new PostViewHolder(view);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UniversityAdapterAdapter.PostViewHolder holder, int position) {
        holder.textViewBody.setText("University Name : " + universitiesList.get(position).getName());
        holder.textViewTitle.setText("Country : " + universitiesList.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return universitiesList.size();
    }

    public  class PostViewHolder extends RecyclerView.ViewHolder{
//        @BindView(R.id.lostImageView) ImageView lostImageView;
        @BindView(R.id.textViewBody) TextView textViewBody;
        @BindView(R.id.textViewTitle)TextView textViewTitle;
//        @BindView(R.id.setAlphaTwoCode) TextView msetAlphaTwoCode;

        private Context mContext;

        public PostViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }
//
//        public void  bindstateProvinceAdapter(GsamaritanResponse stateProvince){
//            mnameTextView.setText(stateProvince.getName());
//            mCountyTextView.setText(stateProvince.getCountry());
//            msetAlphaTwoCode.setText(stateProvince.getAlphaTwoCode());
//        }


    }

}

