package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.apache.commons.lang3.StringUtils;

public class TelaInicial extends AppCompatActivity {

    public static final String NAME = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
    }

    public void iniciar(View view){
        // intent para passar de uma tela para a outra
        Intent intent = new Intent(this, MenuPrincipal.class);

        //texto para conseguir pegar o texto digitado na tela do APP
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        if(StringUtils.isBlank(message)){
            editText.setText("");
            editText.setHint(R.string.erro_nome_vazio);
        }
        else{
            intent.putExtra(NAME,message);
            startActivity(intent);
        }

    }
}
