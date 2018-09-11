package com.example.helloworld.cliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.helloworld.R;

import java.util.List;
import java.util.concurrent.ExecutionException;

import entity.Cliente;
import utils.HttpUtils;

public class ListarClientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);
    }

    public void listarClientes(View view){

        String path = "http://10.0.2.2:8080/segunda-api/rest/loja/cliente/listar";

        try {
            List<Cliente> listaClientes =  HttpUtils.getListaClientes(path);

            for(Cliente cliente : listaClientes){
                Log.i("Cliente",cliente.getPrimeiroNome() + " " + cliente.getSegundoNome());
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
