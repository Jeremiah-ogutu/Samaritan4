package com.moringaschool.g_samaritan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ValueEventListener mSearchedCountryReferenceListener;

    private DatabaseReference mSearchedCountryReference;



    @BindView(R.id.findViewById) EditText name ;
    @BindView(R.id.EditText) EditText county;
    @BindView(R.id.savedUniversitiesButton) Button mSavedUniversitiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSearchedCountryReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);

mSearchedCountryReferenceListener = mSearchedCountryReference.addValueEventListener(new  ValueEventListener() {
    @Override
    public void onDataChange(@NonNull  DataSnapshot datasnapshot) {
        for(DataSnapshot countrySnapshot :datasnapshot.getChildren()){
            String country = countrySnapshot.getValue().toString();
            Log.d("Country update","country" + country);
        }

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSavedUniversitiesButton.setOnClickListener(this);

//
    }
//
    public void switchActivity(View view){
        Intent intent = new Intent(this,LostActivity.class);
        intent.putExtra("name",name.getText() .toString()) ;
        intent.putExtra("county",county.getText() .toString());
        startActivity(intent);

        String Country = county.getText().toString();

        saveCountryToFirebase(Country);

    }

    private void saveCountryToFirebase(String country) {
        mSearchedCountryReference.push().setValue(country);
    }


    @Override
    public void onClick(View v) {
        if(v==mSavedUniversitiesButton) {
            Intent intent = new Intent(MainActivity.this,SavedUniversitiesListActivity.class);
            startActivity(intent);
        }

    }

  @Override
    protected void  onDestroy(){
        super.onDestroy();
        mSearchedCountryReference.removeEventListener(mSearchedCountryReferenceListener);
  }


}


