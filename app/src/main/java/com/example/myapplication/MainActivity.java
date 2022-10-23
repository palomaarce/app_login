package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.model.User;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    TextView retornoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Definindo o arquivo de layout xml
        setContentView(R.layout.activity_main);
        //Capturando o valor digitado pelo usuário no campo username do layout
        username = findViewById(R.id.username);
        //Capturando o valor digitado pelo usuário no campo password do layout
        password = findViewById(R.id.senha);
        //Mapeando o componente textview para preencher com o retorno do login
        retornoLogin = findViewById(R.id.retornoLogin);



        //Evento de clique do botão de logar
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Chama a função de verificar login
                verificaLogin(username, password);
            }
        });

    }

    public void verificaLogin(EditText username, EditText password){
        //Percorre o array de usuários
        for(int x=0; x<User.getUsers().size(); x++){
            //Valida se tem algum usuário da lista com o mesmo usuário e a mesma senha
            if(User.getUsers().get(x).getLogin().equals(username.getText().toString())
            && User.getUsers().get(x).getPassword().equals(password.getText().toString())){
                System.out.println("Autenticado");
                //Direciona para a tela principal do app
                Intent intent = new Intent(this, MainActivity2.class);
                //Passa para a próxima tela o id do usuário
                intent.putExtra("idUsuario", User.getUsers().get(x).getId());
                startActivity(intent);
            } else {
                System.out.println("Não autenticado");
                //Mostra a mensagem de login incorreto para o usuário
                retornoLogin.setText("Usuário não encontrado ou senha incorreta");

            }
        }

    }


}