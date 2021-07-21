package com.moringaschool.g_samaritan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
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

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentAddress;


    private static final String TAG = LostActivity.class.getSimpleName();
    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    UniversityAdapter adapter;

    List<Universities> universitiesList = new ArrayList<>();

    private  void SharedPreferences(String country){
        mEditor.putString(Constants.PREFERENCES_COUNTRY_KEY, country).apply();
    }







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

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_COUNTRY_KEY, null);
        if(mRecentAddress != null){
            fetchPosts(mRecentAddress);
        }


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

        //IP3



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem menuItem = menu.findItem(R.id.search_badge);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String country) {
                addToSharedPreferences(country);
                fetchPosts(country);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }

    private void fetchPosts(String country) {
        fetchPosts();
    }

    private void addToSharedPreferences(String country) {
        mEditor.putString(Constants.PREFERENCES_COUNTRY_KEY,country).apply();
    }

    ;

//IP2
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

