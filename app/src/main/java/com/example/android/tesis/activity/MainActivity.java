package com.example.android.tesis.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.tesis.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void schedule(View view){
        Intent iti = new Intent(this, Schedule.class);
        startActivity(iti);
    }

    public void register(View view){
        Intent iti = new Intent(this, Register.class);
        startActivity(iti);
    }

    public void login(View view){
        Intent iti = new Intent(this, Login.class);
        startActivity(iti);
    }

}
