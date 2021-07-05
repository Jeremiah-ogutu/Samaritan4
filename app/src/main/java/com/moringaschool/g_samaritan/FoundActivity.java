package com.moringaschool.g_samaritan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FoundActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;

    private String[] found  =new String[] {
            "B.M.X bicycle","TecknoSpark7", "KDF675N Subaru","ID No.456372","Ranger KMFE354y","Child name: Kitelo","HUduma card 1034567","Guchi laptopbag","Puma shoe","K.C.S.E certificate"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);
        listView =(ListView) findViewById(R.id.listView);
        textView =(TextView) findViewById(R.id.TextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,found );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String found = ((TextView)view).getText().toString();
                Toast.makeText(FoundActivity.this,found, Toast.LENGTH_LONG).show();
            }
        });



        textView.setText("Here is the list of items that were found and given to the owners");


    }
}