package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    // Criação da variável binding que servirá para manipular a tela.
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout da atividade de login usando o binding gerado pelo Data Binding.
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura o listener de clique para o botão de login.
        binding.buttonEntrar.setOnClickListener {
            // Obtém o nome de usuário e senha digitados e remove espaços em branco.
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            // Verifica se o nome de usuário e a senha correspondem aos valores esperados.
            if (username == "abc" && password == "123") {
                // Se as credenciais estiverem corretas, cria uma Intent para iniciar a MainActivity.
                val i = Intent(this, MainActivity::class.java)
                // Passa o nome de usuário como um extra para a próxima atividade.
                i.putExtra("username", username)
                startActivity(i)
                // Finaliza a atividade de login para que o usuário não possa retornar pressionando o botão "Voltar".
                finish()
            } else {
                // Se as credenciais estiverem incorretas, exibe uma mensagem de erro.
                Toast.makeText(applicationContext, "Erro", Toast.LENGTH_LONG).show()
            }
        }
    }
}
