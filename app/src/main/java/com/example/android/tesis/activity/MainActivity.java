package com.example.android.tesis.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Toast;

import com.example.android.tesis.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View schedule = findViewById(R.id.itine);
        schedule.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent iti = new Intent(MainActivity.this, Schedule.class);
                startActivity(iti);
            }
        });

        View register = findViewById(R.id.regis);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent iti = new Intent(MainActivity.this, Register.class);
                startActivity(iti);
            }
        });

        View login = findViewById(R.id.log);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent iti = new Intent(MainActivity.this, Login.class);
                startActivity(iti);
            }
        });

//        View foru = findViewById(R.id.forum);
//        foru.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//
//                Intent iti = new Intent(MainActivity.this, outSiteService.class);
//                startActivity(iti);
//            }
//        });
    }

}
