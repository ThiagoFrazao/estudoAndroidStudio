package com.example.helloworld.cliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.helloworld.R;

public class MenuCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cliente);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("Nome");

        TextView textView = findViewById(R.id.textView5);
        textView.setText("Escolha uma opção \n" + nome);
    }

    public void encontrarClienteMenu(View view){

        Intent intent = new Intent(this,FindCliente.class);

        TextView textView = findViewById(R.id.textView5);
        String nome = textView.getText().toString().split("\n")[1];
        intent.putExtra("Nome",nome);
        startActivity(intent);
    }

    public void listarClienteMenu(View view){

        Intent intent = new Intent(this,ListarClientes.class);

        TextView textView = findViewById(R.id.textView5);
        String nome = textView.getText().toString().split("\n")[1];
        intent.putExtra("Nome",nome);
        startActivity(intent);
    }
}
