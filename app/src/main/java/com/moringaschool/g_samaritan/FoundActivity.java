package com.moringaschool.g_samaritan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class FoundActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;

    private String[] cuisines  =new String[] {
            "B.M.X bicycle","TecknoSpark7", "KDF675N Subaru","ID No.456372","Ranger KMFE354y","Child name: Kitelo","HUduma card 1034567","Guchi laptopbag","Puma shoe","K.C.S.E certificate"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);
        listView =(ListView) findViewById(R.id.listView);
        textView =(TextView) findViewById(R.id.TextView);

        textView.setText("Here is the list of items that were found and given to the owners");


    }
}