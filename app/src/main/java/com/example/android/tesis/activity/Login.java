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
import com.example.android.tesis.SecurePassword;
import com.example.android.tesis.model.Usuario;
import com.example.android.tesis.my_interface.APIService;
import com.example.android.tesis.network.ApiUtils;
import com.example.android.tesis.network.RetrofitInstance;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by rjsan on 7/5/2018.
 */

public class Login extends AppCompatActivity {
    private static final String LOG_TAG = Login.class.getSimpleName();
    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
    }

    public void input(View view) {

        final String user;
        final String password;

        SecurePassword sp = new SecurePassword();

        EditText userText = (EditText) findViewById(R.id.user);
        user = userText.getText().toString();

        EditText passText = (EditText) findViewById(R.id.pass);
        password = passText.getText().toString();

        int conteoPalabras = 0;
        boolean palabra = false;
        int finDeLinea = user.length() - 1;

        for (int i = 0; i < user.length(); i++) {
            // Si el char is una letra, word = true.
            if (Character.isLetter(user.charAt(i)) && i != finDeLinea) {
                palabra = true;
                // Si el char no es una letra y aún hay más letras,
                // el contador continua.
            } else if (!Character.isLetter(user.charAt(i)) && palabra) {
                conteoPalabras++;
                palabra = false;
                // última palabra de la cadena; si no termina con una no letra ,
            } else if (Character.isLetter(user.charAt(i)) && i == finDeLinea) {
                conteoPalabras++;
            }
        }

        if (conteoPalabras >= 2) {
            PopUp("No se puede ingresar un usuario con espacios");
        }


        if (password.length() != 0) {
            if (password.length() < 4) {
                PopUp("La contrasena debe ser mayor a 4 caracteres");
            } else if (password.length() > 10) {
                PopUp("La contrasena debe ser menor a 10 caracteres");
            }
        } else if (password.length() == 0) {
            PopUp("Campo del password vacio");
        }


        final String encrytPassword = sp.getPasswordHash(password);

        if (apiService == null) {
            apiService = RetrofitInstance.getRetrofitInstance(ApiUtils.BASE_URL).create(APIService.class);
        } else {
            Log.d(LOG_TAG, "el apiService está inicializado");
        }

        Call<List<Usuario>> call = apiService.doGetUsuariosList();

        call.enqueue(new Callback<List<Usuario>>() {

            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                int flag = 0;
                for (Usuario userRec : response.body()) {

                    if (user.equals(userRec.getUsuario())) {
                        if (encrytPassword.equals(userRec.getPassword())) {
                            flag = 2;
                        } else {
                            flag = 1;
                        }
                    }
                }
                if (flag == 2) {
                    Log.i(LOG_TAG, "Login correcto");
                    Intent iti = new Intent(Login.this, PaginaMantenimiento.class);
                    startActivity(iti);
                } else if (flag == 1) {
                    PopUp("Password Incorrecto");
                } else if (flag == 0) {
                    PopUp("Usuario Incorrecto");
                }

            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.e(LOG_TAG, "fallo con " + t.getMessage());
                call.cancel();
            }
        });
    }

    public void PopUp(String issue) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(issue)
                .setTitle("NOTIFICACION")
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
