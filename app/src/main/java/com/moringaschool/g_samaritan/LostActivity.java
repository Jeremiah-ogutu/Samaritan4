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
import com.moringaschool.g_samaritan.network.UniApi;
import com.moringaschool.samaritan2.Constants;
import com.moringaschool.samaritan2.GsamaritanResponse;
import com.moringaschool.samaritan2.SamaritanApi;
import com.moringaschool.g_samaritan.network.UniversityClient;
import com.moringaschool.g_samaritan.adapter.UniversityAdapterAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Callback;
import retrofit2.Response;


public class LostActivity extends  AppCompatActivity {
    TextView textView;
//    @BindView(R.id.textView) TextView textView;
    ListView listView;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    UniversitiesAdapter adapter;

    List<Universities> universitiesList = new ArrayList<>();

    private UniversityAdapterAdapter mAdapter;
    private List<GsamaritanResponse> msamaritan;

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
        listView =(ListView) findViewById(R.id.listview);
        textView =(TextView) findViewById(R.id.findViewById);

        button = findViewById(R.id.foundItembutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foundItembutton();
            }
        });


//        LostArrayAdapter adapter = new LostArrayAdapter(this, android.R.layout.simple_list_item_1,lost, cuisines);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lost); //
//        listView.setAdapter(adapter);

        listView .setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String lost =((TextView)view).getText().toString();

                Toast.makeText(LostActivity.this,lost,Toast.LENGTH_LONG).show();
            }
        });



        Intent intent =getIntent();
        String name= intent.getStringExtra("name");
        String county =intent.getStringExtra("county");
//        textView=findViewById(R.id.findViewById);
        textView.setText("Welcome back good samaritan "  + name +  " here is the list of the lost items in   "   + county +   " lets help find their owners" );


        //IP2

        UniApi myClient = UniversityClient.getClient();
        Call<GsamaritanResponse> call = myClient.getLostItems(Constants.G_SAMARITAN_BASE_URL);

        call.enqueue(new Callback<GsamaritanResponse>() {
            @Override
            public void onResponse(Call<GsamaritanResponse> call, Response<GsamaritanResponse> response) {
                hideProgressBar();
                if(response.isSuccessful()){
                    msamaritan = response.body().getGsamaritanResponse;
                    mAdapter= new UniversityAdapterAdapter(LostActivity.this,msamaritan);
                    msamaritanRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LostActivity.this);
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







    private void foundItembutton() {
        Intent intent = new Intent(this,FoundActivity.class);
        startActivity(intent);
    }
}

