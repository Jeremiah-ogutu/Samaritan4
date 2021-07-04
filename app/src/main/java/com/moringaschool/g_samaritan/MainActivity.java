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

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText county;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name =findViewById(R.id.findViewById);
        county=findViewById(R.id.EditText);
    }
//
    public void switchActivity(View view){
        Intent intent = new Intent(this,LostActivity.class);
        intent.putExtra("name",name.getText() .toString()) ;
        intent.putExtra("county",county.getText() .toString());
        startActivity(intent);
    }
}
//public class MainActivity extends AppCompatActivity {
//    public static final String TAG = MainActivity.class.getSimpleName();
//
//    private Button mlogInbutton;
//    private EditText mEdittext;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        mEdittext = (EditText) findViewById(R.id.edittext);
//        mlogInbutton = (Button) findViewById(R.id.mlogInbutton);
//        mlogInbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//                public void onClick(View v) {
//                    String edittex = mEdittext.getText().toString();
//                    Intent intent = new Intent(MainActivity.this, lostActivity.class);
//                    startActivity(intent);
//                }
//
//
//
//        });
//    }
//}


