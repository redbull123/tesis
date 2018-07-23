package com.example.android.tesis.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.tesis.R;
import com.example.android.tesis.model.Itinerario;
import com.example.android.tesis.model.Usuario;
import com.example.android.tesis.my_interface.APIService;
import com.example.android.tesis.network.ApiUtils;
import com.example.android.tesis.network.RetrofitInstance;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by rjsan on 7/5/2018.
 */

public class Register extends AppCompatActivity {
    private APIService apiService;
    private static final String LOG_TAG = Schedule.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
    }

    public void registrarUsuario(View view){

        Log.d(LOG_TAG, "    Entro!!! ");
        String name ;
        String lastName;
        int ci;
        String address;
        String email;
        String usuario;
        String password;

        EditText nameText   = (EditText)findViewById(R.id.ingName);
        name = nameText.getText().toString();

        EditText lastNameText   = (EditText)findViewById(R.id.ingLast);
        lastName = lastNameText.getText().toString();

        EditText ciText  = (EditText)findViewById(R.id.ingCi);
        ci = Integer.parseInt(ciText.getText().toString());

        EditText addressText   = (EditText)findViewById(R.id.ingAddress);
        address = addressText.getText().toString();

        EditText emailText   = (EditText)findViewById(R.id.ingEmail);
        email = emailText.getText().toString();

        EditText userNameText   = (EditText)findViewById(R.id.ingPass);
        usuario = userNameText.getText().toString();

        EditText passwordText   = (EditText)findViewById(R.id.ingPass);
        password = passwordText.getText().toString();



        Usuario user = new Usuario(lastName, ci, name, password, "op", 1, usuario);

        Log.d(LOG_TAG, "Genero este usuario: " + user.getNombre() + user.getApellido());

        if(apiService == null) {
            apiService = RetrofitInstance.getRetrofitInstance(ApiUtils.BASE_URL).create(APIService.class);
        } else {
            Log.d(LOG_TAG, "el apiService está inicializado");
        }

        Log.d(LOG_TAG, "ARRIBA");
        Call<Usuario> call = apiService.doSetUsuariosList(user);
        Log.d(LOG_TAG, "Hizo PUT de un objeto Call de la apiService");

        call.enqueue(new Callback<Usuario>() {

            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                Log.i(LOG_TAG, "post submitted to API.");

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e(LOG_TAG, "fallo con " + t.getMessage());
                call.cancel();
            }
        });
    }

    public void cancelar(View view){

        Intent route = new Intent(this, MainActivity.class);
        startActivity(route);

    }
}
