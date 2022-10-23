package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.example.myapplication.model.User;

public class MainActivity2 extends AppCompatActivity {
    TextView bemvindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Captura o id do usuário passado pela intent anterior
        int idUsuario = getIntent().getIntExtra("idUsuario", -1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Mapeia o campo para a mensagem de bem vindo
        bemvindo = findViewById(R.id.bemvindo);
        //Chama a função que monta a mensagem de boas vindas
        mensagemBoasVindas(idUsuario);
    }

    public void mensagemBoasVindas(int idUsuario) {

        for (int x = 0; x < User.getUsers().size(); x++) {
            //Valida se tem algum usuário da lista com o mesmo usuário e a mesma senha
            if (User.getUsers().get(x).getId() == idUsuario) {
                //Mostra a mensagem de bem vindo com o nome do usuário
                bemvindo.setText("Bem vindo, " + User.getUsers().get(x).getName());
            }

        }
    }
}