package com.moringaschool.g_samaritan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.moringaschool.g_samaritan.FirebaseUniversityViewHolder;
import com.moringaschool.g_samaritan.R;
import com.moringaschool.g_samaritan.SavedUniversitiesListActivity;
import com.moringaschool.g_samaritan.Util.ItemTouchHelperAdapter;
import com.moringaschool.g_samaritan.Util.OnStartDragListener;
import com.moringaschool.g_samaritan.models.Universities;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseUniversityListAdapter extends FirebaseRecyclerAdapter<Universities, FirebaseUniversityViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ArrayList<Universities> university = new ArrayList<>();
//    private Query mRef;

    private ChildEventListener mChildEventListener;


    public  FirebaseUniversityListAdapter(FirebaseRecyclerOptions<Universities> options, Query ref, SavedUniversitiesListActivity onStartDragListener, Context context){
        super(options);
        mRef = ref.getRef();
//        mOnStartDragListener = onStartDragListener;
        mContext = context;



        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull  DataSnapshot dataSnapshot, @Nullable  String previousChildName) {
                university.add(dataSnapshot.getValue(Universities.class));
            }



            @Override
            public void onChildChanged(@NonNull  DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }

    @Override
    protected void onBindViewHolder(@NonNull  FirebaseUniversityViewHolder firebaseUniversityViewHolder, int position, @NonNull  Universities model) {
        firebaseUniversityViewHolder.bindUniversity(model);



    }


    @NonNull

    @Override
    public FirebaseUniversityViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.samaritan_list_item_drag,parent,false);
        return new FirebaseUniversityViewHolder(view);

    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(university, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        setIndexInForebase();
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        university.remove(position);
        getRef(position).removeValue();

    }

    private void setIndexInForebase() {
        for(Universities restaurant: university){
            int index = university.indexOf(restaurant);
            DatabaseReference mReference = getRef(index);
            restaurant.setIndex(Integer.toString(index));
            mReference.setValue(restaurant);
        }
    }
    @Override
    public void stopListening(){
        super.stopListening();
        mRef.removeEventListener(mChildEventListener);
    }

}
