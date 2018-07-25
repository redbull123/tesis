package com.example.android.tesis.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.example.android.tesis.R;
import com.example.android.tesis.model.Usuario;
import com.example.android.tesis.my_interface.APIService;
import com.example.android.tesis.network.ApiUtils;
import com.example.android.tesis.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by rjsan on 7/5/2018.
 */

public class Register extends AppCompatActivity {
    private static final String LOG_TAG = Register.class.getSimpleName();
    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
    }

    public void registrarUsuario(View view) {

        String name;
        String lastName;
        int ci= 0;
        String address;
        String email;
        String usuario;
        String password;

        EditText nameText = (EditText) findViewById(R.id.ingName);
        name = nameText.getText().toString();

        EditText lastNameText = (EditText) findViewById(R.id.ingLast);
        lastName = lastNameText.getText().toString();

        EditText ciText = (EditText) findViewById(R.id.ingCi);
        ci = Integer.parseInt(ciText.getText().toString());

        EditText addressText = (EditText) findViewById(R.id.ingAddress);
        address = addressText.getText().toString();

        EditText emailText = (EditText) findViewById(R.id.ingEmail);
        email = emailText.getText().toString();

        EditText userNameText = (EditText) findViewById(R.id.ingUser);
        usuario = userNameText.getText().toString();


        EditText passwordText = (EditText) findViewById(R.id.ingPass);
        password = passwordText.getText().toString();


        if(!name.equals("") && !lastName.equals("") && ci != 0 && !address.equals("") &&
                !email.equals("") && !usuario.equals("") && !password.equals("")){
        Usuario user = new Usuario(lastName, ci, name, password, "us", 1, usuario);

        if (apiService == null) {
            apiService = RetrofitInstance.getRetrofitInstance(ApiUtils.BASE_URL).create(APIService.class);
        } else {
            Log.d(LOG_TAG, "el apiService está inicializado");
        }

        Call<Usuario> call = apiService.doSetUsuariosList(user);
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
        PopUp();}

        if(name.equals("")){
            Log.d(LOG_TAG, "El Nombre es null");
        }

        if(lastName.equals("")){
            Log.d(LOG_TAG, "El Apellido es null");
        }
        if(ci == 0){
            Log.d(LOG_TAG, "El Cedula es null");
        }
        if(address.equals("")){
            Log.d(LOG_TAG, "El Direccion es null");
        }
        if(email.equals("")){
            Log.d(LOG_TAG, "El Correo es null");
        }
        if(usuario.equals("")){
            Log.d(LOG_TAG, "El usuario es null");
        }
        if(password.equals("")){
            Log.d(LOG_TAG, "El Contrasena es null");
        }

    }


    public void PopUp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Usuario creado con Exito!!")
                .setTitle("NOTIFICACION")
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Intent route = new Intent(Register.this, Login.class);
                                startActivity(route);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void cancelar(View view) {

        Intent route = new Intent(this, MainActivity.class);
        startActivity(route);
    }
}
