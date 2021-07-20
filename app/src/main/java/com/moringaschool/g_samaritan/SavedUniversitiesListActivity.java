package com.moringaschool.g_samaritan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.g_samaritan.models.Universities;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedUniversitiesListActivity extends AppCompatActivity {
    private DatabaseReference mUniversitiesReference;
    private FirebaseRecyclerAdapter<Universities, FirebaseUniversityViewHolder> mFirebaseAdapter;

    @BindView(R.id.samaritanRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.ErrorTextView)
    TextView mTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samaritan_main);
        ButterKnife.bind(this);

        mUniversitiesReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_UNIVERSITIES);
        setUpFirebaseAdapter();
        hideProgressBar();
        showRestaurants();
    }


    private void setUpFirebaseAdapter() {
        FirebaseRecyclerOptions<Universities> options = new FirebaseRecyclerOptions.Builder<Universities>()
                .setQuery(mUniversitiesReference, Universities.class)
                .build();


        mFirebaseAdapter = new FirebaseRecyclerAdapter<Universities, FirebaseUniversityViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseUniversityViewHolder firebaseUniversityViewHolder, int position, @NonNull Universities model) {
                firebaseUniversityViewHolder.bindUniversity(model);

            }

            @NonNull
            @Override
            public FirebaseUniversityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
                return new FirebaseUniversityViewHolder(view);

            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!=null){
            mFirebaseAdapter.stopListening();
        }
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }
}