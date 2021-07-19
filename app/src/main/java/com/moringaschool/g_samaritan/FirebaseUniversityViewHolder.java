package com.moringaschool.g_samaritan;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.g_samaritan.models.Universities;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseUniversityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseUniversityViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindUniversity(Universities samaritan){
        TextView tittleTextView = (TextView)mView.findViewById(R.id.textViewTitle);
        TextView bodyTextView = (TextView)mView.findViewById(R.id.textViewBody);

        tittleTextView.setText(samaritan.getName());
        bodyTextView.setText(samaritan.getCountry());

    }


    @Override
    public void onClick(View v) {
        final ArrayList<Universities> samaritan = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getInstance().getReference(Constants.FIREBASE_CHILD_UNIVERSITIES);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    samaritan.add(snapshot.getValue(Universities.class));

                }

                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext,LostActivity.class);
                intent.putExtra("position",itemPosition + "");
                intent.putExtra("universities", Parcels.wrap(samaritan));


                mContext.startActivity(intent);

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });

    }
}
