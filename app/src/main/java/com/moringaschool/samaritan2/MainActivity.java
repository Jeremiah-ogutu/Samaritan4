package com.moringaschool.samaritan2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.ErrorTextView) TextView mErrorTextView;

    @BindView(R.id.samaritanRecyclerView) RecyclerView msamaritanRecyclerView;

    private stateProvinceAdapter mAdapter;
    private List<GsamaritanResponse> msamaritan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getstateProvince();
    }

    public void getstateProvince(){

        SamaritanApi myClient = SamaritanClient.getClient();
        Call<GsamaritanResponse> call = myClient.getLostItems(Constants.G_SAMARITAN_BASE_URL);

        call.enqueue(new Callback<GsamaritanResponse>() {
            @Override
            public void onResponse(Call<GsamaritanResponse> call, Response<GsamaritanResponse> response) {
                hideProgressBar();
                if(response.isSuccessful()){
                    msamaritan = response.body().GsamaritanResponse;
                    mAdapter= new stateProvinceAdapter(MainActivity.this,msamaritan);
                    msamaritanRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    msamaritanRecyclerView.setLayoutManager(layoutManager);
                    msamaritanRecyclerView.setHasFixedSize(true);

                    showGsamaritanResponse();
                }
                else {
                    showFaliureMessage();
                }
            }

            @Override
            public void onFailure(Call<GsamaritanResponse> call, Throwable t) {
                hideProgressBar();
                showFaliureMessage();

            }
        });

    }

    public void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);

    }
    public void showGsamaritanResponse(){
        msamaritanRecyclerView.setVisibility(View.VISIBLE);

    }
    public void showFaliureMessage(){
        mErrorTextView.setText("Check your internate connection");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
}