package com.moringaschool.g_samaritan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText county;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name =findViewById(R.id.editText);
        county=findViewById(R.id.edittext);
    }
//
//    public void switchActivity(View view){
//        Intent intent = new Intent(this.lostActivityclass)
//        intent.putExtra("user",name.getText());
//        intent.putExtra("country",county.getText());
//        startActivity(intent);
//    }
//}