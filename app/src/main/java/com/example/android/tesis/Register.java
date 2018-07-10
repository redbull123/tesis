package com.example.android.tesis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by rjsan on 7/5/2018.
 */

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
    }

    public void cancelar(View view){

        Intent route = new Intent(this, MainActivity.class);
        startActivity(route);

    }
}
