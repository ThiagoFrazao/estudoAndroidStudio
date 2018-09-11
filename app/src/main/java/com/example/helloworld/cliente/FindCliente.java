package com.example.helloworld.cliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloworld.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ExecutionException;

import entity.Cliente;
import okhttp3.HttpUrl;
import utils.HttpUtils;

public class FindCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_cliente);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("Nome");

        TextView textView = findViewById(R.id.textView2);
        textView.setText("Escolha uma opção \n" + nome);
    }

    public void mostrarCliente(View view){
        EditText textPrimNome = (EditText) findViewById(R.id.editText2);
        String nome  = textPrimNome.getText().toString();

        if(StringUtils.isNotBlank(nome)){
            String msg = null;
            String path = "http://10.0.2.2:8080/segunda-api/rest/loja/cliente/find";

            // Separar primeiro nome do segundo
            String[] nomeSplit = nome.split(" ");

            //Primeira posicao sera o Primeiro Nome
            String primeiroNome = nomeSplit[0];

            //Removendo primeiro nome do array
            nomeSplit[0] = "";

            //Restante sera o segundo nome
            String segundoNome = StringUtils.join(nomeSplit, " ").trim();

            HttpUrl.Builder url = HttpUrl.parse(path).newBuilder();
            url.addQueryParameter("primeiroNome",primeiroNome);
            url.addQueryParameter("segundoNome",segundoNome);

            path = url.build().toString();

            try {
                Cliente cliente = (Cliente) HttpUtils.get(path, new Cliente());
                if(cliente != null){
                    Gson gson = new GsonBuilder().create();
                    msg = cliente.toString();
                }
                else{
                    msg = "Cliente não encontrado";
                }

            } catch (ExecutionException e) {
                Log.e("Erro",e.getMessage());
            } catch (InterruptedException e) {
                Log.e("Erro",e.getMessage());
            }
            TextView textView = (TextView) findViewById(R.id.textView3);
            textView.setText(msg);
        }
        else {
            EditText editText = (EditText) findViewById(R.id.editText2);
            editText.setHint(R.string.erro_nome_vazio);
        }
    }
}