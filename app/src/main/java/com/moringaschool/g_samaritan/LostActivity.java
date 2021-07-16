package com.moringaschool.g_samaritan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;

import com.moringaschool.g_samaritan.models.Universities;
import com.moringaschool.g_samaritan.network.UniversityClient;
import com.moringaschool.g_samaritan.adapter.UniversityAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;


public class LostActivity extends  AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    UniversityAdapter adapter;

    List<Universities> universitiesList = new ArrayList<>();




    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);
        recyclerView = findViewById(R.id.postRecyclerView);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UniversityAdapter(universitiesList);
        recyclerView.setAdapter(adapter);

        button = findViewById(R.id.foundItembutton);

        fetchPosts();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foundItembutton();
            }
        });






        Intent intent =getIntent();
        String name= intent.getStringExtra("name");
        String county =intent.getStringExtra("county");
//

        //IP2



    }

    private void fetchPosts(){
        progressBar.setVisibility(View.VISIBLE);
        UniversityClient.getRetrofitClient().getUniversities().enqueue(new Callback<List<Universities>>() {
            @Override
            public void onResponse(Call<List<Universities>> call, Response<List<Universities>> response) {

                if(response.isSuccessful() && response.body() !=null){
                    universitiesList.addAll((Collection<? extends Universities>) response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);

                }

            }

            @Override
            public void onFailure(Call<List<Universities>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(LostActivity.this,"Error "+ t.getMessage(),Toast.LENGTH_SHORT).show();

            }


        });

    }


    private void foundItembutton() {
        Intent intent = new Intent(this,FoundActivity.class);
        startActivity(intent);
    }
}

