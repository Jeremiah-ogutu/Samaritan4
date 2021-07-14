package com.moringaschool.samaritan2;


//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.moringaschool.g_samaritan.R;
//
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//
//public class SamaritanActivity extends AppCompatActivity {
//    @BindView(R.id.progressBar)
//    ProgressBar mProgressBar;
//    @BindView(R.id.ErrorTextView)
//    TextView mErrorTextView;
//    @BindView(R.id.samaritanRecyclerView)
//    RecyclerView msamaritanRecyclerView;
//    public List<GsamaritanResponse> msamaritan;
//    private stateProvinceAdapter mAdapter;
////    private String msamaritan;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//
//        getStateProvince();
//    }
//
//    public void getStateProvince() {
//        SamaritanApi myClient = SamaritanClient.getClient();
//        Call<GsamaritanResponse> call = myClient.getLostItems(Constants.G_SAMARITAN_BASE_URL);
//
//        call.enqueue(new Callback<GsamaritanResponse>() {
//            @Override
//            public void onResponse(Call<GsamaritanResponse> call, Response<GsamaritanResponse> response) {
//                hideProgressBar();
//                Log.e("juma ni mkuu","kionozi");
//
//                if (response.isSuccessful()) {
//                    msamaritan = response.body().getGsamaritanResponse;
//                    mAdapter = new stateProvinceAdapter(SamaritanActivity.this, msamaritan);
//                    msamaritanRecyclerView.setAdapter(mAdapter);
//                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SamaritanActivity.this);
//                    msamaritanRecyclerView.setLayoutManager(layoutManager);
//                    msamaritanRecyclerView.setHasFixedSize(true);
//
//                    showGsamaritanResponse();
//                } else {
//                    showFaliureMessage();
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<GsamaritanResponse> call, Throwable t) {
//                Log.e("juma ni mkuu","faliure");
//
//                hideProgressBar();
//                showFaliureMessage();
//            }
//
//        });
//    }
//
//    public void hideProgressBar() {
//        mProgressBar.setVisibility(View.GONE);
//    }
//
//    public void showGsamaritanResponse() {
//        msamaritanRecyclerView.setVisibility(View.VISIBLE);
//    }
//
//    public void showFaliureMessage() {
//        mErrorTextView.setText("Check your internate connection");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//}


