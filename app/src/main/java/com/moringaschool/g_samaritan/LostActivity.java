package com.moringaschool.g_samaritan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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
    TextView textView;
    ListView listView;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    UniversityAdapter adapter;

    List<Universities> universitiesList = new ArrayList<>();

//    private UniversityAdapter mAdapter;

//    @BindView(R.id.listView) ListView listView;

//    private String[] lost = new String[]{"John Baraza","Kivuki Tuka","Shutuka Kizee","Doe moen","Pirre Smart", "Dokore Daka","Ogutu Sultan","Mwana Wababu","Oushe Biggy","Jeshi Krotone" };
//    private String[] cuisines  =new String[] {
//            "B.M.X bicycle","TecknoSpark7", "KDF675N Subaru","ID No.456372","Ranger KMFE354y","Child name: Kitelo","HUduma card 1034567","Guchi laptopbag","Puma shoe","K.C.S.E certificate"
//    };
////

//
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);
//        ButterKnife.bind(this);
        recyclerView = findViewById(R.id.postRecyclerView);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UniversityAdapter(universitiesList);
        recyclerView.setAdapter(adapter);
//        listView =(ListView) findViewById(R.id.listview);
//        textView =(TextView) findViewById(R.id.findViewById);

        button = findViewById(R.id.foundItembutton);
        fetchPosts();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foundItembutton();
            }
        });



//        LostArrayAdapter adapter = new LostArrayAdapter(this, android.R.layout.simple_list_item_1,lost, cuisines);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lost); //
//        listView.setAdapter(adapter);

//        listView .setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                String lost =((TextView)view).getText().toString();
//
//                Toast.makeText(LostActivity.this,lost,Toast.LENGTH_LONG).show();
//            }
//        });



        Intent intent =getIntent();
        String name= intent.getStringExtra("name");
        String county =intent.getStringExtra("county");
//        textView=findViewById(R.id.findViewById);
//        textView.setText("Welcome back good samaritan "  + name +  " here is the list of the lost items in   "   + county +   " lets help find their owners" );


        //IP2

    }
    private void fetchPosts(){
        progressBar.setVisibility(View.VISIBLE);
        UniversityClient.getClient().getUniversities().enqueue(new Callback<Universities>() {
            @Override
            public void onResponse(Call<Universities> call, Response<Universities> response) {
                if(response.isSuccessful() && response.body() !=null){
                    universitiesList.addAll((Collection<? extends Universities>) response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);

                }

            }

            @Override
            public void onFailure(Call<Universities> call, Throwable t) {
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

