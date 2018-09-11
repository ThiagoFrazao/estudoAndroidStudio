package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.helloworld.cliente.MenuCliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.util.concurrent.ExecutionException;

import entity.Resposta;
import utils.HttpUtils;


public class MenuPrincipal extends AppCompatActivity {

    private final static String PATH = "http://10.0.2.2:8080/segunda-api/rest/loja/cliente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(TelaInicial.NAME);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textViewName);
        textView.setText("Bem vindo \n" + message );
    }

    public void testarServidor(View view){

        Resposta resp = null;
        try {
            resp = (Resposta) HttpUtils.get(PATH, new Resposta());

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(resp.getMensagem());
    }

    public void menuCliente(View view){
        Intent intent = new Intent(this, MenuCliente.class);

        TextView textView = findViewById(R.id.textViewName);
        String nome = textView.getText().toString().split("\n")[1];
        intent.putExtra("Nome",nome);
        startActivity(intent);
    }

}
