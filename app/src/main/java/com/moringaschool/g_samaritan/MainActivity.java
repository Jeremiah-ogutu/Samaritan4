package com.moringaschool.g_samaritan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
//    EditText name;
    @BindView(R.id.findViewById) EditText name ;
//    EditText county;
    @BindView(R.id.EditText) EditText county;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//
    }
//
    public void switchActivity(View view){
        Intent intent = new Intent(this,LostActivity.class);
        intent.putExtra("name",name.getText() .toString()) ;
        intent.putExtra("county",county.getText() .toString());
        startActivity(intent);
    }


}


